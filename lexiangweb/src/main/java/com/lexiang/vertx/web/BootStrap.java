package com.lexiang.vertx.web;

import com.google.inject.Injector;
import com.lexiang.vertx.web.handler.ExceptionHandler;
import com.lexiang.vertx.web.provider.LeXiangInjectProvider;
import com.lexiang.vertx.web.provider.Resource;
import com.lexiang.vertx.web.provider.ResourceResolver;
import com.lexiang.vertx.web.utils.Funcs;
import com.lexiang.vertx.web.utils.JsonStringBuilder;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.http.CaseInsensitiveHeaders;
import io.vertx.core.http.HttpMethod;
import io.vertx.core.http.HttpServerRequest;
import io.vertx.ext.web.Route;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.handler.BodyHandler;
import io.vertx.ext.web.handler.CookieHandler;
import io.vertx.ext.web.handler.CorsHandler;
import io.vertx.ext.web.handler.ResponseTimeHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rx.Scheduler;
import rx.schedulers.Schedulers;
import rx.util.async.Async;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author wills.tan
 * @since 1.0.0
 */
public class BootStrap extends AbstractVerticle{
    private final static Logger logger =
        LoggerFactory.getLogger(BootStrap.class);
    private Injector injector;
    private final ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 100, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(10000));
    private final Scheduler scheduler = Schedulers.from(executor);



    private void startWebServer() {
        //init guice container
        LeXiangInjectProvider.load(vertx);
        injector = LeXiangInjectProvider.getInjector();
        final Router mainRouter = Router.router(vertx);
        registerGlobalHandler(mainRouter);
        registerResourceHandler(mainRouter);
        // start a HTTP web server on port 10086
        vertx.createHttpServer().requestHandler(mainRouter::accept).listen(18080);
        System.out.println("start webserver success... listen on 18080");
    }

    @Override
    public void start() throws Exception {
        Funcs.timeMillis(1, c -> startWebServer());
    }


    public static void main(String[] args) {
        Runner.runMod(BootStrap.class);
       /* String verticleId=BootStrap.class.getName();
        VertxOptions options =new VertxOptions();
        Consumer<Vertx> runner = vertx1 -> {
            vertx1.deployVerticle(verticleId);
        };
        Vertx vertx = Vertx.vertx(options);
        runner.accept(vertx);*/


    }

    private void registerGlobalHandler(Router mainRouter) {
        // Exception handler
        mainRouter.route().failureHandler(ExceptionHandler.create());
        mainRouter.route().handler(ResponseTimeHandler.create());
        // We need cookies and request bodies.
        // We need a cookie handler first
        mainRouter.route().handler(CookieHandler.create());
        mainRouter.route().handler(BodyHandler.create());
        mainRouter .route()
                .handler(
                        CorsHandler.create("*")
                                .allowedMethod(io.vertx.core.http.HttpMethod.GET)
                                .allowedMethod(io.vertx.core.http.HttpMethod.POST)
                                .allowedMethod(io.vertx.core.http.HttpMethod.OPTIONS)
                                .allowedMethod(io.vertx.core.http.HttpMethod.PUT)
                                .allowedMethod(io.vertx.core.http.HttpMethod.DELETE)
                                .allowedHeader("Content-Type")
                                .allowedHeader("X-Requested-With")
                                .allowedHeader("Access-Control-Allow-Origin"));
        //acl拦截判断
      /*  mainRouter.route().handler(ctx -> {
            HttpServerRequest request = ctx.request();
            CaseInsensitiveHeaders cmpHeaders =  new CaseInsensitiveHeaders();
            cmpHeaders.setAll(request.headers());
            ctx.next();
        });*/
    }

    private void registerResourceHandler(Router mainRouter) {
        List<Resource> resolve = ResourceResolver.resolve();
        resolve.forEach(r ->
                r.getMethods().forEach(m -> {
                    Object obj = injector.getInstance(r.getResourceClazz());
                    Route route = mainRouter.route();
                    if (m.path() == null) {
                        route.path(r.path());
                    } else {
                        route.path(r.path().equals("/") ? r.path() + m.path() : r.path() + "/" + m.path());
                    }
                    if (m.httpMethod() != null) {
                        route.method(HttpMethod.valueOf(m.httpMethod()));
                    }
                    if (!m.consumedTypes().isEmpty()) {
                        m.consumedTypes().forEach(t -> route.consumes(t));
                    } else if (!r.consumedTypes().isEmpty()) {
                        r.consumedTypes().forEach(t -> route.consumes(t));
                    }
                    if (!m.producedTypes().isEmpty()) {
                        m.producedTypes().forEach(t -> route.produces(t));
                    } else if (!r.producedTypes().isEmpty()) {
                        r.producedTypes().forEach(t -> route.produces(t));
                    }
                    route.handler(ctx ->
                            Async.start(() -> {
                                try {
                                    m.getMethod().invoke(obj, ctx);
                                } catch (Exception e) {
                                    handleFailure(ctx, e);
                                }
                                return null;
                            }, scheduler).subscribe()
                    );
                })
        );
    }

    private void handleFailure(RoutingContext ctx, Throwable e) {
        int code = 1;
        String msg = "";
        if (e instanceof InvocationTargetException) {
            Throwable targetException = ((InvocationTargetException) e).getTargetException();
            logger.error(targetException.getMessage(), targetException);
            msg = targetException.getMessage();
        } else {
            msg = e.getMessage();
            logger.error(e.getMessage(), e);
        }
        String jsonString = JsonStringBuilder.create().writeNumber("errorCode", code).writeString("errorMessage", msg).build();
        ctx.response().setStatusCode(400);
        ctx.response().putHeader("Content-Length", String.valueOf(jsonString.getBytes().length));
        ctx.response().end(jsonString, "utf-8");
    }
}

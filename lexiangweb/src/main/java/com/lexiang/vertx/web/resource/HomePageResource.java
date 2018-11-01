package com.lexiang.vertx.web.resource;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;
import com.lexiang.vertx.web.entity.LexiangProduct;
import com.lexiang.vertx.web.entity.StaticPages;
import com.lexiang.vertx.web.service.PhotoService;
import com.lexiang.vertx.web.service.ProductService;
import com.lexiang.vertx.web.service.StaticPageService;
import com.lexiang.vertx.web.utils.Commons;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.RoutingContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Map;


@Singleton
@Path("/home")
public class HomePageResource {

    private final Logger LOG = LoggerFactory.getLogger(HomePageResource.class);

    @Inject
    StaticPageService staticPageService;


    @GET
    public void getHomePage(RoutingContext ctx) {
        Map<String, Object> map = Maps.newHashMap();
        LexiangProduct lexiangProduct = new LexiangProduct();
        lexiangProduct.setStatus(Commons.status_recommend);
        map.put("homepage", staticPageService.getStaticPage().getHomePage());
        ctx.response().end(JSON.toJSONString(map));
    }

    @GET
    @Path("aboutus")
    public void getAboutUsPage(RoutingContext ctx) {
        Map<String, Object> map = Maps.newHashMap();
        LexiangProduct lexiangProduct = new LexiangProduct();
        lexiangProduct.setStatus(Commons.status_recommend);
        map.put("aboutUsPage", staticPageService.getStaticPage().getAboutUsPage());
        ctx.response().end(JSON.toJSONString(map));
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(RoutingContext ctx){
        JsonObject json = ctx.getBodyAsJson();
        StaticPages staticPages = new StaticPages();
        staticPages.setAboutUsPage(json.getString("about_page"));
        staticPages.setHomePage(json.getString("home_page"));
        staticPageService.upSert(staticPages);
    }
}

package com.lexiang.vertx.web.handler.impl;

import com.lexiang.vertx.web.handler.ExceptionHandler;
import com.lexiang.vertx.web.utils.JsonStringBuilder;
import io.vertx.ext.web.RoutingContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Singleton;

/**
 * @author sneaky
 * @since 1.0.0
 */
@Singleton
public class ExceptionHandlerImpl implements ExceptionHandler {
  private final static Logger logger = LoggerFactory.getLogger(ExceptionHandlerImpl.class);

  @Override
  public void handle(RoutingContext context) {
    int code = 400;
    String msg = "";

    if (context.failed()) {
      Throwable failure = context.failure();
      if (failure != null) {
        msg = failure.getMessage();
      }
      int statusCode = context.statusCode();
      if (statusCode < 400) {
        context.response().setStatusCode(400);
      } else {
        context.response().setStatusCode(statusCode);
      }
      context.response().end(JsonStringBuilder.create().writeNumber("errorCode", code).writeString("errorMessage", msg).build());
    }
  }

}

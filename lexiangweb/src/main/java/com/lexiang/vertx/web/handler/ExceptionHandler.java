package com.lexiang.vertx.web.handler;

import com.lexiang.vertx.web.handler.impl.ExceptionHandlerImpl;
import io.vertx.core.Handler;
import io.vertx.ext.web.RoutingContext;

/**
 * @author wills
 * @since 1.0.0
 */
public interface ExceptionHandler extends Handler<RoutingContext> {
  static ExceptionHandler create() {
    return new ExceptionHandlerImpl();
  }
}

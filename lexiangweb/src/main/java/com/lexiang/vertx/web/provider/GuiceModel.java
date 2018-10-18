package com.lexiang.vertx.web.provider;

import io.vertx.core.Vertx;
import org.mybatis.guice.XMLMyBatisModule;

import java.util.Properties;

/**
 * @author wills
 * @since 1.0.0
 */
public class GuiceModel extends XMLMyBatisModule {
  private Vertx vertx;

  public GuiceModel(Vertx vertx) {
    this.vertx = vertx;
  }


  @Override
  protected void initialize() {
    setEnvironmentId("mysql");
    setClassPathResource("mybatis-config.xml");
    addProperties(new Properties());

  }
}

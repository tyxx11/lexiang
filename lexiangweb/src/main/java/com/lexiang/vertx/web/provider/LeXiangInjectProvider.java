package com.lexiang.vertx.web.provider;

import com.google.inject.Guice;
import com.google.inject.Injector;
import io.vertx.core.Vertx;
import org.mybatis.guice.XMLMyBatisModule;

import java.util.Properties;

/**
 * @author WillsTan on 8/26/18.
 * @since 1.0.0
 * email: tywills09@gmail.com
 */
public class LeXiangInjectProvider {
    private static Injector injector;

    //init mybatis injector
    public static void load(Vertx vertx) {
        injector = Guice.createInjector(new XMLMyBatisModule() {
            @Override
            protected void initialize() {
                setEnvironmentId("mysql");
                setClassPathResource("mybatis-config.xml");
                addProperties(new Properties());
            }
        }, binder -> {

            binder.bind(Vertx.class).toInstance(vertx);
         /*   binder.bind(DataLineageResource.class);
            binder.bind(TableDictService.class).to(TableDictServiceImpl.class);
            binder.bind(FieldDictService.class).to(FieldDictServiceImpl.class);
            binder.bind(JobDictService.class).to(JobDictServiceImpl.class);
            binder.bind(TableLineageService.class).to(TableLineageServiceImpl.class);
            binder.bind(FieldLineageService.class).to(FieldLineageServiceImpl.class);
            binder.bind(JobLineageService.class).to(JobLineageServiceImpl.class);
            binder.bind(JobTableRefService.class).to(JobTableRefServiceImpl.class);*/

        });
    }

    public static Injector getInjector() {
        return injector;
    }
}

package com.lexiang.vertx.web.resource;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;
import com.lexiang.vertx.web.entity.LexiangProduct;
import com.lexiang.vertx.web.service.PhotoService;
import com.lexiang.vertx.web.service.ProductService;
import com.lexiang.vertx.web.utils.Commons;
import io.vertx.ext.web.RoutingContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.List;
import java.util.Map;


@Singleton
@Path("/home")
public class HomePageResource {

    private final Logger LOG = LoggerFactory.getLogger(HomePageResource.class);
    String photoUploadPath = "/home/wills/";

    @Inject
    ProductService productService;

    @Inject
    PhotoService photoService;

    @GET
    public void getProductAll(RoutingContext ctx) {
        Map<String, Object> map = Maps.newHashMap();
        LexiangProduct lexiangProduct = new LexiangProduct();
        lexiangProduct.setStatus(Commons.status_recommend);
        map.put("pics", photoService.getHomePagePics());
        map.put("products", productService.getBy(lexiangProduct));
        ctx.response().end(JSON.toJSONString(map));
    }

}

package com.lexiang.vertx.web.resource;


import com.alibaba.fastjson.JSON;
import com.lexiang.vertx.web.entity.LexiangProduct;
import com.lexiang.vertx.web.service.ProductService;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.RoutingContext;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Singleton
@Path("/lexiangproduct")
public class ProductResource {
    @Inject
    ProductService productService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(RoutingContext ctx) {
        JsonObject json = ctx.getBodyAsJson();
        LexiangProduct product = new LexiangProduct();
        product.setAddress(json.getString("address"));
        product.setIntro(json.getString("prod_inro"));
        product.setDays(json.getInteger("prod_days"));
        product.setPrice(json.getInteger("price"));
        product.setTitle(json.getString("title"));
        int result = productService.save(product);
        ctx.response().end(String.valueOf(result));

    }

    @GET
    @Path("all")
    public void getProductAll(RoutingContext ctx) {
        List<LexiangProduct> lexiangProductList = productService.getAll();
        ctx.response().end(JSON.toJSONString(lexiangProductList));
    }

}

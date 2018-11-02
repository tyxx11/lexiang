package com.lexiang.vertx.web.resource;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;
import com.lexiang.vertx.web.entity.LexiangProduct;
import com.lexiang.vertx.web.service.ProductService;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.FileUpload;
import io.vertx.ext.web.RoutingContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.File;
import java.util.List;
import java.util.Map;

@Singleton
@Path("/lexiangproduct")
public class ProductResource {
    private final Logger LOG = LoggerFactory.getLogger(ProductResource.class);


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



    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void getPhotos(RoutingContext ctx){
        JsonObject json = ctx.getBodyAsJson();
        String file = json.getString("filePath");
        ctx.response().sendFile(file);
    }

    @DELETE
    @Path("deleteProduct/:id")
    public void deleteProduct(RoutingContext ctx){
        productService.deteleProduct(Integer.parseInt(ctx.request().getParam("id")));
        ctx.response().end("delete ok!");
    }

}

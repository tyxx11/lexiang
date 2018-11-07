package com.lexiang.vertx.web.resource;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.lexiang.vertx.web.entity.LexiangProduct;
import com.lexiang.vertx.web.entity.LexiangProductWithBLOBs;
import com.lexiang.vertx.web.entity.Lunbo;
import com.lexiang.vertx.web.entity.Photos;
import com.lexiang.vertx.web.service.HomePageService;
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

    @Inject
    HomePageService homePageService;


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(RoutingContext ctx) {
        JsonObject json = ctx.getBodyAsJson();
        LexiangProductWithBLOBs product = new LexiangProductWithBLOBs();
        product.setTargetAddress(json.getString("target_address"));
        product.setIntro(json.getString("prod_inro"));
        product.setDays(json.getInteger("prod_days"));
        product.setPrice(json.getInteger("price"));
        product.setTitle(json.getString("title"));
        product.setPhotoPath(json.getString("photo_path"));
        product.setTravalType(json.getInteger("traval_type"));
        if (json.getInteger("status") != null){
            product.setStatus(json.getInteger("status"));
        }
        int result = productService.save(product);
        ctx.response().end(String.valueOf(result));
    }

    @POST
    @Path("fix")
    public void fix(RoutingContext ctx){
        List<LexiangProductWithBLOBs> lexiangProductList = productService.getAll();
        for (LexiangProductWithBLOBs product : lexiangProductList){
            String path = product.getPhotoPath();
            path = path.replaceAll("/home/lexiang","http://47.106.250.195:80");
            product.setPhotoPath(path);
            productService.update(product);
        }
        ctx.response().end("update ok;");
    }

    @GET
    @Path("all")
    public void getProductAll(RoutingContext ctx) {
        List<LexiangProductWithBLOBs> lexiangProductList = productService.getAll();
        ctx.response().putHeader("content-type", "application/json; charset=utf-8").end(JSON.toJSONString(lexiangProductList));
    }

    @GET
    @Path("productShow")
    public void getProductShowPage(RoutingContext ctx) {
        List<LexiangProductWithBLOBs> lexiangProductList = productService.getAll();
        Map<String,Object> map =homePageService.getNavigatorAndSysTemSetting();
        map.put("products", lexiangProductList);
        List<Lunbo> lunboList = productService.getProductShowLunbo();
        map.put("lunbos", lunboList);
        ctx.response().putHeader("content-type", "application/json; charset=utf-8").end(JSON.toJSONString(map));
    }



    @POST
    @Path("getPic")
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

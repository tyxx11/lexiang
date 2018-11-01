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
    String photoUploadPath = "/home/wills/";
    String picPreFix = "< lexiangpic: ";
    String picEndFix = " >";


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
    @Path("uploadphotos")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public void fileUpload(RoutingContext ctx){
        JSONObject resJson = new JSONObject();
        if(ctx.fileUploads() == null || ctx.fileUploads().isEmpty()){
            resJson.put("error code", "201");
            resJson.put("error msg", "请上传文件");
            LOG.info("上传文件失败，请上传文件");
            ctx.response().end(resJson.toJSONString());
            return;
        }
        FileUpload fileUpload = (FileUpload) ctx.fileUploads().toArray()[0];
        File file = new File(fileUpload.uploadedFileName());
        file.renameTo(new File(photoUploadPath + fileUpload.fileName()));
        Map<String,String> map = Maps.newHashMap();
        map.put("error Message", "file uploaded");
        map.put("pic path", picPreFix + photoUploadPath + fileUpload.fileName() + picEndFix);
        ctx.response().end(JSON.toJSONString(map));
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

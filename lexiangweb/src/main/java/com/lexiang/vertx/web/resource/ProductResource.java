package com.lexiang.vertx.web.resource;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.lexiang.vertx.web.entity.*;
import com.lexiang.vertx.web.service.HomePageService;
import com.lexiang.vertx.web.service.ProductDetailService;
import com.lexiang.vertx.web.service.ProductService;
import com.lexiang.vertx.web.utils.Jsons;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.FileUpload;
import io.vertx.ext.web.RoutingContext;
import org.apache.commons.lang3.StringUtils;
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

    @Inject
    ProductDetailService productDetailService;


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

    @POST
    @Path("detail")
    @Consumes(MediaType.APPLICATION_JSON)
    public void createDetail(RoutingContext ctx) {
        JsonObject json = ctx.getBodyAsJson();
        ProductDetailWithBLOBs detailWithBLOBs = new ProductDetailWithBLOBs();
        JsonObject productDetail = json.getJsonObject("product_detail");
        int productId = productDetail.getInteger("product_id");
        detailWithBLOBs.setProductId(productId);
        detailWithBLOBs.setDivBaomingwuyou(productDetail.getString("baomingwuyou"));
        detailWithBLOBs.setDivCancelOrder(productDetail.getString("cancel_order"));
        detailWithBLOBs.setDivCommonProblems(productDetail.getString("common_problem"));
        detailWithBLOBs.setDivJiagewuyou(productDetail.getString("jiagewuyou"));
        detailWithBLOBs.setDivTiyanwuyou(productDetail.getString("tiyanwuyou"));
        detailWithBLOBs.setDivExplain(productDetail.getString("div_explain"));
        detailWithBLOBs.setDivTravelCharacteristic(productDetail.getString("div_travel_character"));
        detailWithBLOBs.setDisbandedPlace(productDetail.getString("disbanded_place"));
        detailWithBLOBs.setGatheringPlace(productDetail.getString("gathering_place"));
        detailWithBLOBs.setSignUpPeople(productDetail.getString("signup_people"));
        detailWithBLOBs.setTeamMemberUpperLimit(productDetail.getInteger("team_member_upper_limit"));

        productDetailService.saveProductDetail(detailWithBLOBs);

        List<Map<String,Object>> travelTopoList = Jsons.objectFromJSONStr(json.getValue("travel_topo").toString(), List.class);
        for (Map<String,Object> map : travelTopoList){
            TravelTopoWithBLOBs travelTopoWithBLOBs = new TravelTopoWithBLOBs();
            travelTopoWithBLOBs.setDiv1(map.get("div1").toString());
            travelTopoWithBLOBs.setDiv2(map.get("div2").toString());
            travelTopoWithBLOBs.setDiv3(map.get("div3").toString());
            travelTopoWithBLOBs.setName(map.get("name").toString());
            travelTopoWithBLOBs.setFood(String.valueOf(map.get("food")));
            travelTopoWithBLOBs.setAccommodation(String.valueOf(map.get("accommodation").toString()));
            travelTopoWithBLOBs.setProductId(productId);
            travelTopoWithBLOBs.setPhotoAddress(String.valueOf(map.get("photoAddress").toString()));
            travelTopoWithBLOBs.setRangeOfDriving(String.valueOf(map.get("rangeOfDriving").toString()));
            travelTopoWithBLOBs.setRangeOfDriving(String.valueOf(map.get("travelDate").toString()));
            productDetailService.saveTravelTopo(travelTopoWithBLOBs);
        }

        List<Map<String,Object>> readBeforeTravelTagList = Jsons.objectFromJSONStr(
                json.getValue("read_before_travel_tags").toString(), List.class);
        for(Map<String,Object> map : readBeforeTravelTagList){
            ReadBeforeTravelTagWithBLOBs readBeforeTravelTag = new ReadBeforeTravelTagWithBLOBs();
            readBeforeTravelTag.setTagDescribe(String.valueOf(map.get("tagDescribe")));
            readBeforeTravelTag.setTagName(String.valueOf(map.get("tagName")));
            productDetailService.saveReadBeforeTravelTags(productId,readBeforeTravelTag);
        }

        List<Map<String,Object>> priceTagList = Jsons.objectFromJSONStr(
                json.getValue("price_contain_tags").toString(), List.class);
        for (Map<String,Object> map : priceTagList){
            PriceTag priceTag = new PriceTag();
            priceTag.setTagDescribe(String.valueOf(map.get("tagDescribe")));
            priceTag.setTagName(String.valueOf(map.get("tagName")));
            priceTag.setTagPhoto(String.valueOf(map.get("tagPhoto")));

            productDetailService.savePriceContainTags(productId,priceTag);
        }

        List<Map<String,Object>> priceNotContainTagList = Jsons.objectFromJSONStr(
                json.getValue("price_not_contain_tags").toString(), List.class);
        for (Map<String,Object> map : priceNotContainTagList){
            PriceTag priceTag = new PriceTag();
            priceTag.setTagDescribe(String.valueOf(map.get("tagDescribe")));
            priceTag.setTagName(String.valueOf(map.get("tagName")));
            priceTag.setTagPhoto(String.valueOf(map.get("tagPhoto")));
            productDetailService.savePriceNotContainTags(productId,priceTag);
        }
        ctx.response().end("save ok;");
    }

    @GET
    @Path("detail/:productId")
    public void getDetail(RoutingContext ctx){
        int productId = Integer.parseInt(ctx.request().getParam("productId"));
        Map<String,Object> map = productDetailService.getProductDetail(productId);
        map.put("productIntro",productService.getById(productId));
        ctx.response().putHeader("content-type", "application/json; charset=utf-8").end(JSON.toJSONString(map));
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
        //Map<String,Object> map =homePageService.getNavigatorAndSysTemSetting();
        Map<String,Object> map = Maps.newHashMap();
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

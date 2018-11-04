package com.lexiang.vertx.web.resource;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;
import com.lexiang.vertx.web.entity.*;
import com.lexiang.vertx.web.service.HomePageService;
import com.lexiang.vertx.web.service.PhotoService;
import com.lexiang.vertx.web.service.ProductService;
import com.lexiang.vertx.web.service.StaticPageService;
import com.lexiang.vertx.web.utils.Commons;
import com.lexiang.vertx.web.utils.Jsons;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.RoutingContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Singleton
@Path("/home")
public class HomePageResource {

    private final Logger LOG = LoggerFactory.getLogger(HomePageResource.class);


    @Inject
    HomePageService homePageService;

    @Inject
    ProductService productService;


    @GET
    public void getHomePage(RoutingContext ctx) {
        Map<String, Object>  map = homePageService.getHomePageAll();
        LexiangProduct product = new LexiangProduct();
        product.setStatus(Commons.status_recommend);
        List<LexiangProduct> lexiangProductList = productService.getBy(product);
        map.put("recommendProduct", lexiangProductList);
        ctx.response().putHeader("content-type", "application/json; charset=utf-8").end(JSON.toJSONString(map));
    }

   /* @GET
    @Path("aboutus")
    public void getAboutUsPage(RoutingContext ctx) {
        Map<String, Object> map = Maps.newHashMap();
        LexiangProduct lexiangProduct = new LexiangProduct();
        lexiangProduct.setStatus(Commons.status_recommend);
        map.put("aboutUsPage", staticPageService.getStaticPage().getAboutUsPage());
        ctx.response().end(JSON.toJSONString(map));
    }*/

    @POST
    @Path("navigator")
    @Consumes(MediaType.APPLICATION_JSON)
    public void createNavigator(RoutingContext ctx){
        JsonObject json = ctx.getBodyAsJson();
        List<Map<String,Object>> navegatorList = Jsons.objectFromJSONStr(json.getValue("navigators").toString(),List.class);
        for (Map<String,Object> map : navegatorList){
            Navigator navigator = new Navigator();
            navigator.setAttribute((Integer) map.get("attribute"));
            navigator.setName(map.get("name").toString());
            if (map.get("parent_name") != null && navigator.getAttribute() == Commons.attribute_navigator_main){
                navigator.setParentName(map.get("parent_name").toString());
            }
            if (map.get("status") != null){
                navigator.setStatus((Integer) map.get("status"));
            }
            homePageService.upSertNavigator(navigator);
        }
        ctx.response().end(JSON.toJSONString("save ok."));
    }

    @POST
    @Path("lunbo")
    @Consumes(MediaType.APPLICATION_JSON)
    public void createLunbo(RoutingContext ctx){
        JsonObject json = ctx.getBodyAsJson();
        List<Map<String,Object>> lunboList = Jsons.objectFromJSONStr(json.getValue("lunbo").toString()
                ,List.class);
        for (Map<String,Object> map : lunboList){
            Lunbo lunbo = new Lunbo();
            lunbo.setAttribute((Integer) map.get("attribute"));
            lunbo.setPhotoAddress(map.get("photoAddress").toString());
            if (map.get("status") != null){
                lunbo.setStatus((Integer) map.get("status"));
            }
            homePageService.upSertLunbo(lunbo);
        }
        ctx.response().end(JSON.toJSONString("save ok."));
    }

    @POST
    @Path("homepagecontent")
    @Consumes(MediaType.APPLICATION_JSON)
    public void createHomePageContent(RoutingContext ctx){
        JsonObject json = ctx.getBodyAsJson();
        List<Map<String,Object>> contentList = Jsons.objectFromJSONStr(
                json.getValue("homepagecontent").toString(), List.class);
        for (Map<String,Object> map : contentList){
            HomePageContentWithBLOBs content = new HomePageContentWithBLOBs();
            content.setDivBot(map.get("divbot").toString());
            content.setDivMid(map.get("divmid").toString());
            content.setDivTop(map.get("divtop").toString());
            if (map.get("status") != null){
                content.setStatus((Integer) map.get("status"));
            }
            homePageService.upSertHomePageContent(content);
        }
        ctx.response().end(JSON.toJSONString("save ok."));
    }

    @POST
    @Path("systemsetting")
    @Consumes(MediaType.APPLICATION_JSON)
    public void createSystemSetting(RoutingContext ctx){
        JsonObject json = ctx.getBodyAsJson();
        List<Map<String,Object>> systemSettingList = Jsons.objectFromJSONStr(json.getValue("systemsetting").toString(), List.class);
        for (Map<String,Object> map : systemSettingList){
            SystemSetting systemSetting = new SystemSetting();
            systemSetting.setAddress(map.get("address").toString());
            systemSetting.setCompanyName(map.get("company_name").toString());
            systemSetting.setLog1(map.get("log1").toString());
            systemSetting.setLog2(map.get("log2").toString());
            systemSetting.setTelNum(map.get("tel_num").toString());
            homePageService.upSertSystemSetting(systemSetting);
        }
        ctx.response().end(JSON.toJSONString("save ok."));

    }


}

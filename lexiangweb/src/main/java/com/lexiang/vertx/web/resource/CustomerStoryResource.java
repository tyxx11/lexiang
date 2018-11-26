package com.lexiang.vertx.web.resource;

import com.alibaba.fastjson.JSON;
import com.lexiang.vertx.web.entity.CustomerStoryDetailWithBLOBs;
import com.lexiang.vertx.web.entity.CustomerStoryWithBLOBs;
import com.lexiang.vertx.web.service.CustomStoryService;
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

/**
 * @author WillsTan on 11/19/18.
 * @since 1.0.0
 * email: tywills09@gmail.com
 */
@Singleton
@Path("/customerstory")
public class CustomerStoryResource {
    @Inject
    CustomStoryService customStoryService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(RoutingContext ctx) {
        JsonObject json = ctx.getBodyAsJson();
        CustomerStoryWithBLOBs customerStoryWithBLOBs = new CustomerStoryWithBLOBs();
        customerStoryWithBLOBs.setDivCustomer(json.getString("div"));
        customerStoryWithBLOBs.setPicAddress(json.getString("pic_address"));
        customStoryService.save(customerStoryWithBLOBs);
        ctx.response().end("save successed");
    }

    @GET
    @Path("all")
    public void getAll(RoutingContext ctx){
        List<CustomerStoryWithBLOBs> customerStoryWithBLOBsList = customStoryService.getAll();
        ctx.response().putHeader("content-type", "application/json; charset=utf-8").end(JSON.toJSONString(customerStoryWithBLOBsList));
    }

    @GET
    @Path("detail/:customerStoryId")
    public void getDetail(RoutingContext ctx){
        int storyId = Integer.parseInt(ctx.request().getParam("customerStoryId"));
        ctx.response().putHeader("content-type", "application/json; charset=utf-8").end(JSON.toJSONString(customStoryService.getDetail(storyId)));
    }

    @POST
    @Path("detail")
    @Consumes(MediaType.APPLICATION_JSON)
    public void createDetail(RoutingContext ctx) {
        JsonObject json = ctx.getBodyAsJson();
        CustomerStoryDetailWithBLOBs story = new CustomerStoryDetailWithBLOBs();
        story.setDivCustomerDetail(json.getString("div"));
        story.setPicAddress(json.getString("pic_address"));
        story.setCustomerStoryId(json.getInteger("customer_story_id"));
        customStoryService.saveDetail(story);
        ctx.response().end("save successed");
    }

    @POST
    @Path("detail/update")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateDetail(RoutingContext ctx) {
        JsonObject json = ctx.getBodyAsJson();
        CustomerStoryDetailWithBLOBs story = new CustomerStoryDetailWithBLOBs();
        story.setDivCustomerDetail(json.getString("div"));
        story.setPicAddress(json.getString("pic_address"));
        story.setCustomerStoryId(json.getInteger("customer_story_id"));
        story.setId(json.getInteger("id"));
        customStoryService.updateDetail(story);
        ctx.response().end("update successed");
    }

}

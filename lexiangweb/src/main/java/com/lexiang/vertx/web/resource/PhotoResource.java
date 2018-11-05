package com.lexiang.vertx.web.resource;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;
import io.vertx.ext.web.FileUpload;
import io.vertx.ext.web.RoutingContext;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Singleton;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import java.io.File;
import java.util.Map;

/**
 * @author WillsTan on 11/1/18.
 * @since 1.0.0
 * email: tywills09@gmail.com
 */
@Singleton
@Path("/photo")
public class PhotoResource {
    private final Logger LOG = LoggerFactory.getLogger(ProductResource.class);
    String photoUploadPath = "/home/lexiang/";

    @POST
    @Path("uploadphotos")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public void fileUpload(RoutingContext ctx){
        JSONObject resJson = new JSONObject();
        String prefix = ctx.request().getFormAttribute("prefix");
        if (StringUtils.isEmpty(prefix)){
            resJson.put("error code", "201");
            resJson.put("error msg", "must have prefix attribute!");
            LOG.info("must have prefix attribute!");
            ctx.response().end(resJson.toJSONString());
            return;
        }
        if(ctx.fileUploads() == null || ctx.fileUploads().isEmpty()){
            resJson.put("error code", "201");
            resJson.put("error msg", "请上传文件");
            LOG.info("上传文件失败，请上传文件");
            ctx.response().end(resJson.toJSONString());
            return;
        }
        FileUpload fileUpload = (FileUpload) ctx.fileUploads().toArray()[0];
        File file = new File(fileUpload.uploadedFileName());
        String dir = photoUploadPath + prefix;
        String fileName = photoUploadPath + prefix + "/" + fileUpload.fileName();
        File destDir = new File(dir);
        File destFile = new File(fileName);
        if (!destDir.exists()){
            destDir.mkdir();
        }
        file.renameTo(destFile);
        file.delete();
        Map<String,String> map = Maps.newHashMap();
        map.put("error Message", "file uploaded");
        map.put("pic path", fileName);
        ctx.response().end(JSON.toJSONString(map));
    }
}

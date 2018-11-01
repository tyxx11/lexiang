package com.lexiang.vertx.web.service;

import com.lexiang.vertx.web.entity.Photos;
import com.lexiang.vertx.web.entity.PhotosExample;
import com.lexiang.vertx.web.mapper.PhotosMapper;
import com.lexiang.vertx.web.utils.Commons;

import javax.inject.Inject;
import java.util.List;

public class PhotoService {
    @Inject
    PhotosMapper photosMapper;

    public List<Photos> getHomePagePics(){
        PhotosExample example = new PhotosExample();
        example.createCriteria().andStatusEqualTo(Commons.pic_status_homepage);
        return photosMapper.selectByExample(example);
    }
}

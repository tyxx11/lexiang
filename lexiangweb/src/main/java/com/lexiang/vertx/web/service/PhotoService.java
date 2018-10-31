package com.lexiang.vertx.web.service;

import com.lexiang.vertx.web.entity.Photos;
import com.lexiang.vertx.web.mapper.PhotosMapper;

import javax.inject.Inject;
import java.util.List;

public class PhotoService {
    @Inject
    PhotosMapper photosMapper;

    public List<Photos> getHomePagePics(){
        //todo changed to where select
        return photosMapper.selectAll();
    }
}

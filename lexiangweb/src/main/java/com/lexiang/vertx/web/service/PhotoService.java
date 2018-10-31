package com.lexiang.vertx.web.service;

import com.lexiang.vertx.web.entity.Photos;
import com.lexiang.vertx.web.mapper.PhotosMapper;
import com.lexiang.vertx.web.utils.Commons;

import javax.inject.Inject;
import java.util.List;

public class PhotoService {
    @Inject
    PhotosMapper photosMapper;

    public List<Photos> getHomePagePics(){
        Photos photos = new Photos();
        photos.setStatus(Commons.pic_status_homepage);
        return photosMapper.selectByCon(photos);
    }
}

package com.lexiang.vertx.web.mapper;

import com.lexiang.vertx.web.entity.Photos;
import java.util.List;

public interface PhotosMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Photos record);

    Photos selectByPrimaryKey(Integer id);

    List<Photos> selectAll();

    int updateByPrimaryKey(Photos record);

    List<Photos> selectByCon(Photos record);
}
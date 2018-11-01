package com.lexiang.vertx.web.mapper;

import com.lexiang.vertx.web.entity.Photos;
import com.lexiang.vertx.web.entity.PhotosExample;
import com.lexiang.vertx.web.entity.PhotosKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PhotosMapper {
    int countByExample(PhotosExample example);

    int deleteByExample(PhotosExample example);

    int deleteByPrimaryKey(PhotosKey key);

    int insert(Photos record);

    int insertSelective(Photos record);

    List<Photos> selectByExample(PhotosExample example);

    Photos selectByPrimaryKey(PhotosKey key);

    int updateByExampleSelective(@Param("record") Photos record, @Param("example") PhotosExample example);

    int updateByExample(@Param("record") Photos record, @Param("example") PhotosExample example);

    int updateByPrimaryKeySelective(Photos record);

    int updateByPrimaryKey(Photos record);
}
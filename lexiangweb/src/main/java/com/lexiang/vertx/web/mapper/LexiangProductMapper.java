package com.lexiang.vertx.web.mapper;

import com.lexiang.vertx.web.entity.LexiangProduct;
import java.util.List;

public interface LexiangProductMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LexiangProduct record);

    LexiangProduct selectByPrimaryKey(Integer id);

    List<LexiangProduct> selectAll();

    int updateByPrimaryKey(LexiangProduct record);
}
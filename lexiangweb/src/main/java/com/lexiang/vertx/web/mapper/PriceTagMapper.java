package com.lexiang.vertx.web.mapper;

import com.lexiang.vertx.web.entity.PriceTag;
import com.lexiang.vertx.web.entity.PriceTagExample;
import com.lexiang.vertx.web.entity.PriceTagKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PriceTagMapper {
    int countByExample(PriceTagExample example);

    int deleteByExample(PriceTagExample example);

    int deleteByPrimaryKey(PriceTagKey key);

    int insert(PriceTag record);

    int insertSelective(PriceTag record);

    List<PriceTag> selectByExample(PriceTagExample example);

    PriceTag selectByPrimaryKey(PriceTagKey key);

    int updateByExampleSelective(@Param("record") PriceTag record, @Param("example") PriceTagExample example);

    int updateByExample(@Param("record") PriceTag record, @Param("example") PriceTagExample example);

    int updateByPrimaryKeySelective(PriceTag record);

    int updateByPrimaryKey(PriceTag record);
}
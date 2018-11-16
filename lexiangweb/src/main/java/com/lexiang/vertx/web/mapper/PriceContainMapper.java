package com.lexiang.vertx.web.mapper;

import com.lexiang.vertx.web.entity.PriceContain;
import com.lexiang.vertx.web.entity.PriceContainExample;
import com.lexiang.vertx.web.entity.PriceContainKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PriceContainMapper {
    int countByExample(PriceContainExample example);

    int deleteByExample(PriceContainExample example);

    int deleteByPrimaryKey(PriceContainKey key);

    int insert(PriceContain record);

    int insertSelective(PriceContain record);

    List<PriceContain> selectByExample(PriceContainExample example);

    PriceContain selectByPrimaryKey(PriceContainKey key);

    int updateByExampleSelective(@Param("record") PriceContain record, @Param("example") PriceContainExample example);

    int updateByExample(@Param("record") PriceContain record, @Param("example") PriceContainExample example);

    int updateByPrimaryKeySelective(PriceContain record);

    int updateByPrimaryKey(PriceContain record);
}
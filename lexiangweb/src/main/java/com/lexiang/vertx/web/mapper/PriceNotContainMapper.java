package com.lexiang.vertx.web.mapper;

import com.lexiang.vertx.web.entity.PriceNotContain;
import com.lexiang.vertx.web.entity.PriceNotContainExample;
import com.lexiang.vertx.web.entity.PriceNotContainKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PriceNotContainMapper {
    int countByExample(PriceNotContainExample example);

    int deleteByExample(PriceNotContainExample example);

    int deleteByPrimaryKey(PriceNotContainKey key);

    int insert(PriceNotContain record);

    int insertSelective(PriceNotContain record);

    List<PriceNotContain> selectByExample(PriceNotContainExample example);

    PriceNotContain selectByPrimaryKey(PriceNotContainKey key);

    int updateByExampleSelective(@Param("record") PriceNotContain record, @Param("example") PriceNotContainExample example);

    int updateByExample(@Param("record") PriceNotContain record, @Param("example") PriceNotContainExample example);

    int updateByPrimaryKeySelective(PriceNotContain record);

    int updateByPrimaryKey(PriceNotContain record);
}
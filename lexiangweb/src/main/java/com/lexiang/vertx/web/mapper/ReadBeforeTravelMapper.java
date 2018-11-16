package com.lexiang.vertx.web.mapper;

import com.lexiang.vertx.web.entity.ReadBeforeTravel;
import com.lexiang.vertx.web.entity.ReadBeforeTravelExample;
import com.lexiang.vertx.web.entity.ReadBeforeTravelKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ReadBeforeTravelMapper {
    int countByExample(ReadBeforeTravelExample example);

    int deleteByExample(ReadBeforeTravelExample example);

    int deleteByPrimaryKey(ReadBeforeTravelKey key);

    int insert(ReadBeforeTravel record);

    int insertSelective(ReadBeforeTravel record);

    List<ReadBeforeTravel> selectByExample(ReadBeforeTravelExample example);

    ReadBeforeTravel selectByPrimaryKey(ReadBeforeTravelKey key);

    int updateByExampleSelective(@Param("record") ReadBeforeTravel record, @Param("example") ReadBeforeTravelExample example);

    int updateByExample(@Param("record") ReadBeforeTravel record, @Param("example") ReadBeforeTravelExample example);

    int updateByPrimaryKeySelective(ReadBeforeTravel record);

    int updateByPrimaryKey(ReadBeforeTravel record);
}
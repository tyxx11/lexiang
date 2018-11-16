package com.lexiang.vertx.web.mapper;

import com.lexiang.vertx.web.entity.ReadBeforeTravelTag;
import com.lexiang.vertx.web.entity.ReadBeforeTravelTagExample;
import com.lexiang.vertx.web.entity.ReadBeforeTravelTagKey;
import com.lexiang.vertx.web.entity.ReadBeforeTravelTagWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ReadBeforeTravelTagMapper {
    int countByExample(ReadBeforeTravelTagExample example);

    int deleteByExample(ReadBeforeTravelTagExample example);

    int deleteByPrimaryKey(ReadBeforeTravelTagKey key);

    int insert(ReadBeforeTravelTagWithBLOBs record);

    int insertSelective(ReadBeforeTravelTagWithBLOBs record);

    List<ReadBeforeTravelTagWithBLOBs> selectByExampleWithBLOBs(ReadBeforeTravelTagExample example);

    List<ReadBeforeTravelTag> selectByExample(ReadBeforeTravelTagExample example);

    ReadBeforeTravelTagWithBLOBs selectByPrimaryKey(ReadBeforeTravelTagKey key);

    int updateByExampleSelective(@Param("record") ReadBeforeTravelTagWithBLOBs record, @Param("example") ReadBeforeTravelTagExample example);

    int updateByExampleWithBLOBs(@Param("record") ReadBeforeTravelTagWithBLOBs record, @Param("example") ReadBeforeTravelTagExample example);

    int updateByExample(@Param("record") ReadBeforeTravelTag record, @Param("example") ReadBeforeTravelTagExample example);

    int updateByPrimaryKeySelective(ReadBeforeTravelTagWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(ReadBeforeTravelTagWithBLOBs record);

    int updateByPrimaryKey(ReadBeforeTravelTag record);
}
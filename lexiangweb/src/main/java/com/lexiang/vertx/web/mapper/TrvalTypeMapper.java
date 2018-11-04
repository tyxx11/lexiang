package com.lexiang.vertx.web.mapper;

import com.lexiang.vertx.web.entity.TrvalType;
import com.lexiang.vertx.web.entity.TrvalTypeExample;
import com.lexiang.vertx.web.entity.TrvalTypeKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TrvalTypeMapper {
    int countByExample(TrvalTypeExample example);

    int deleteByExample(TrvalTypeExample example);

    int deleteByPrimaryKey(TrvalTypeKey key);

    int insert(TrvalType record);

    int insertSelective(TrvalType record);

    List<TrvalType> selectByExample(TrvalTypeExample example);

    TrvalType selectByPrimaryKey(TrvalTypeKey key);

    int updateByExampleSelective(@Param("record") TrvalType record, @Param("example") TrvalTypeExample example);

    int updateByExample(@Param("record") TrvalType record, @Param("example") TrvalTypeExample example);

    int updateByPrimaryKeySelective(TrvalType record);

    int updateByPrimaryKey(TrvalType record);
}
package com.lexiang.vertx.web.mapper;

import com.lexiang.vertx.web.entity.StaticPages;
import com.lexiang.vertx.web.entity.StaticPagesExample;
import com.lexiang.vertx.web.entity.StaticPagesKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StaticPagesMapper {
    int countByExample(StaticPagesExample example);

    int deleteByExample(StaticPagesExample example);

    int deleteByPrimaryKey(StaticPagesKey key);

    int insert(StaticPages record);

    int insertSelective(StaticPages record);

    List<StaticPages> selectByExample(StaticPagesExample example);

    StaticPages selectByPrimaryKey(StaticPagesKey key);

    int updateByExampleSelective(@Param("record") StaticPages record, @Param("example") StaticPagesExample example);

    int updateByExample(@Param("record") StaticPages record, @Param("example") StaticPagesExample example);

    int updateByPrimaryKeySelective(StaticPages record);

    int updateByPrimaryKey(StaticPages record);
}
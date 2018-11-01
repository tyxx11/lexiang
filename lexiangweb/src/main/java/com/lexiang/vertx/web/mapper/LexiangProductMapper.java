package com.lexiang.vertx.web.mapper;

import com.lexiang.vertx.web.entity.LexiangProduct;
import com.lexiang.vertx.web.entity.LexiangProductExample;
import com.lexiang.vertx.web.entity.LexiangProductKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LexiangProductMapper {
    int countByExample(LexiangProductExample example);

    int deleteByExample(LexiangProductExample example);

    int deleteByPrimaryKey(LexiangProductKey key);

    int insert(LexiangProduct record);

    int insertSelective(LexiangProduct record);

    List<LexiangProduct> selectByExample(LexiangProductExample example);

    LexiangProduct selectByPrimaryKey(LexiangProductKey key);

    int updateByExampleSelective(@Param("record") LexiangProduct record, @Param("example") LexiangProductExample example);

    int updateByExample(@Param("record") LexiangProduct record, @Param("example") LexiangProductExample example);

    int updateByPrimaryKeySelective(LexiangProduct record);

    int updateByPrimaryKey(LexiangProduct record);
}
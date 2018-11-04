package com.lexiang.vertx.web.mapper;

import com.lexiang.vertx.web.entity.LexiangProduct;
import com.lexiang.vertx.web.entity.LexiangProductExample;
import com.lexiang.vertx.web.entity.LexiangProductKey;
import com.lexiang.vertx.web.entity.LexiangProductWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LexiangProductMapper {
    int countByExample(LexiangProductExample example);

    int deleteByExample(LexiangProductExample example);

    int deleteByPrimaryKey(LexiangProductKey key);

    int insert(LexiangProductWithBLOBs record);

    int insertSelective(LexiangProductWithBLOBs record);

    List<LexiangProductWithBLOBs> selectByExampleWithBLOBs(LexiangProductExample example);

    List<LexiangProduct> selectByExample(LexiangProductExample example);

    LexiangProductWithBLOBs selectByPrimaryKey(LexiangProductKey key);

    int updateByExampleSelective(@Param("record") LexiangProductWithBLOBs record, @Param("example") LexiangProductExample example);

    int updateByExampleWithBLOBs(@Param("record") LexiangProductWithBLOBs record, @Param("example") LexiangProductExample example);

    int updateByExample(@Param("record") LexiangProduct record, @Param("example") LexiangProductExample example);

    int updateByPrimaryKeySelective(LexiangProductWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(LexiangProductWithBLOBs record);

    int updateByPrimaryKey(LexiangProduct record);
}
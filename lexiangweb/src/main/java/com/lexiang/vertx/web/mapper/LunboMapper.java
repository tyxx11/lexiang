package com.lexiang.vertx.web.mapper;

import com.lexiang.vertx.web.entity.Lunbo;
import com.lexiang.vertx.web.entity.LunboExample;
import com.lexiang.vertx.web.entity.LunboKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LunboMapper {
    int countByExample(LunboExample example);

    int deleteByExample(LunboExample example);

    int deleteByPrimaryKey(LunboKey key);

    int insert(Lunbo record);

    int insertSelective(Lunbo record);

    List<Lunbo> selectByExample(LunboExample example);

    Lunbo selectByPrimaryKey(LunboKey key);

    int updateByExampleSelective(@Param("record") Lunbo record, @Param("example") LunboExample example);

    int updateByExample(@Param("record") Lunbo record, @Param("example") LunboExample example);

    int updateByPrimaryKeySelective(Lunbo record);

    int updateByPrimaryKey(Lunbo record);
}
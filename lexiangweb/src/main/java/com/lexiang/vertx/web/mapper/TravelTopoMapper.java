package com.lexiang.vertx.web.mapper;

import com.lexiang.vertx.web.entity.TravelTopo;
import com.lexiang.vertx.web.entity.TravelTopoExample;
import com.lexiang.vertx.web.entity.TravelTopoKey;
import com.lexiang.vertx.web.entity.TravelTopoWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TravelTopoMapper {
    int countByExample(TravelTopoExample example);

    int deleteByExample(TravelTopoExample example);

    int deleteByPrimaryKey(TravelTopoKey key);

    int insert(TravelTopoWithBLOBs record);

    int insertSelective(TravelTopoWithBLOBs record);

    List<TravelTopoWithBLOBs> selectByExampleWithBLOBs(TravelTopoExample example);

    List<TravelTopo> selectByExample(TravelTopoExample example);

    TravelTopoWithBLOBs selectByPrimaryKey(TravelTopoKey key);

    int updateByExampleSelective(@Param("record") TravelTopoWithBLOBs record, @Param("example") TravelTopoExample example);

    int updateByExampleWithBLOBs(@Param("record") TravelTopoWithBLOBs record, @Param("example") TravelTopoExample example);

    int updateByExample(@Param("record") TravelTopo record, @Param("example") TravelTopoExample example);

    int updateByPrimaryKeySelective(TravelTopoWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(TravelTopoWithBLOBs record);

    int updateByPrimaryKey(TravelTopo record);
}
package com.lexiang.vertx.web.mapper;

import com.lexiang.vertx.web.entity.HomePageContent;
import com.lexiang.vertx.web.entity.HomePageContentExample;
import com.lexiang.vertx.web.entity.HomePageContentKey;
import com.lexiang.vertx.web.entity.HomePageContentWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HomePageContentMapper {
    int countByExample(HomePageContentExample example);

    int deleteByExample(HomePageContentExample example);

    int deleteByPrimaryKey(HomePageContentKey key);

    int insert(HomePageContentWithBLOBs record);

    int insertSelective(HomePageContentWithBLOBs record);

    List<HomePageContentWithBLOBs> selectByExampleWithBLOBs(HomePageContentExample example);

    List<HomePageContent> selectByExample(HomePageContentExample example);

    HomePageContentWithBLOBs selectByPrimaryKey(HomePageContentKey key);

    int updateByExampleSelective(@Param("record") HomePageContentWithBLOBs record, @Param("example") HomePageContentExample example);

    int updateByExampleWithBLOBs(@Param("record") HomePageContentWithBLOBs record, @Param("example") HomePageContentExample example);

    int updateByExample(@Param("record") HomePageContent record, @Param("example") HomePageContentExample example);

    int updateByPrimaryKeySelective(HomePageContentWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(HomePageContentWithBLOBs record);

    int updateByPrimaryKey(HomePageContent record);
}
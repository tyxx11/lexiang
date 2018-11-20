package com.lexiang.vertx.web.mapper;

import com.lexiang.vertx.web.entity.CustomerStory;
import com.lexiang.vertx.web.entity.CustomerStoryExample;
import com.lexiang.vertx.web.entity.CustomerStoryKey;
import com.lexiang.vertx.web.entity.CustomerStoryWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CustomerStoryMapper {
    int countByExample(CustomerStoryExample example);

    int deleteByExample(CustomerStoryExample example);

    int deleteByPrimaryKey(CustomerStoryKey key);

    int insert(CustomerStoryWithBLOBs record);

    int insertSelective(CustomerStoryWithBLOBs record);

    List<CustomerStoryWithBLOBs> selectByExampleWithBLOBs(CustomerStoryExample example);

    List<CustomerStory> selectByExample(CustomerStoryExample example);

    CustomerStoryWithBLOBs selectByPrimaryKey(CustomerStoryKey key);

    int updateByExampleSelective(@Param("record") CustomerStoryWithBLOBs record, @Param("example") CustomerStoryExample example);

    int updateByExampleWithBLOBs(@Param("record") CustomerStoryWithBLOBs record, @Param("example") CustomerStoryExample example);

    int updateByExample(@Param("record") CustomerStory record, @Param("example") CustomerStoryExample example);

    int updateByPrimaryKeySelective(CustomerStoryWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(CustomerStoryWithBLOBs record);

    int updateByPrimaryKey(CustomerStory record);
}
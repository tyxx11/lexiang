package com.lexiang.vertx.web.mapper;

import com.lexiang.vertx.web.entity.CustomerStoryDetail;
import com.lexiang.vertx.web.entity.CustomerStoryDetailExample;
import com.lexiang.vertx.web.entity.CustomerStoryDetailKey;
import com.lexiang.vertx.web.entity.CustomerStoryDetailWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CustomerStoryDetailMapper {
    int countByExample(CustomerStoryDetailExample example);

    int deleteByExample(CustomerStoryDetailExample example);

    int deleteByPrimaryKey(CustomerStoryDetailKey key);

    int insert(CustomerStoryDetailWithBLOBs record);

    int insertSelective(CustomerStoryDetailWithBLOBs record);

    List<CustomerStoryDetailWithBLOBs> selectByExampleWithBLOBs(CustomerStoryDetailExample example);

    List<CustomerStoryDetail> selectByExample(CustomerStoryDetailExample example);

    CustomerStoryDetailWithBLOBs selectByPrimaryKey(CustomerStoryDetailKey key);

    int updateByExampleSelective(@Param("record") CustomerStoryDetailWithBLOBs record, @Param("example") CustomerStoryDetailExample example);

    int updateByExampleWithBLOBs(@Param("record") CustomerStoryDetailWithBLOBs record, @Param("example") CustomerStoryDetailExample example);

    int updateByExample(@Param("record") CustomerStoryDetail record, @Param("example") CustomerStoryDetailExample example);

    int updateByPrimaryKeySelective(CustomerStoryDetailWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(CustomerStoryDetailWithBLOBs record);

    int updateByPrimaryKey(CustomerStoryDetail record);
}
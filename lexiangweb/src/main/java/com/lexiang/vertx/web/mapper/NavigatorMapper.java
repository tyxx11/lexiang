package com.lexiang.vertx.web.mapper;

import com.lexiang.vertx.web.entity.Navigator;
import com.lexiang.vertx.web.entity.NavigatorExample;
import com.lexiang.vertx.web.entity.NavigatorKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NavigatorMapper {
    int countByExample(NavigatorExample example);

    int deleteByExample(NavigatorExample example);

    int deleteByPrimaryKey(NavigatorKey key);

    int insert(Navigator record);

    int insertSelective(Navigator record);

    List<Navigator> selectByExample(NavigatorExample example);

    Navigator selectByPrimaryKey(NavigatorKey key);

    int updateByExampleSelective(@Param("record") Navigator record, @Param("example") NavigatorExample example);

    int updateByExample(@Param("record") Navigator record, @Param("example") NavigatorExample example);

    int updateByPrimaryKeySelective(Navigator record);

    int updateByPrimaryKey(Navigator record);
}
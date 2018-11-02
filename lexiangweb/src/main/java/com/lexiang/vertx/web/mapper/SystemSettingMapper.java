package com.lexiang.vertx.web.mapper;

import com.lexiang.vertx.web.entity.SystemSetting;
import com.lexiang.vertx.web.entity.SystemSettingExample;
import com.lexiang.vertx.web.entity.SystemSettingKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SystemSettingMapper {
    int countByExample(SystemSettingExample example);

    int deleteByExample(SystemSettingExample example);

    int deleteByPrimaryKey(SystemSettingKey key);

    int insert(SystemSetting record);

    int insertSelective(SystemSetting record);

    List<SystemSetting> selectByExample(SystemSettingExample example);

    SystemSetting selectByPrimaryKey(SystemSettingKey key);

    int updateByExampleSelective(@Param("record") SystemSetting record, @Param("example") SystemSettingExample example);

    int updateByExample(@Param("record") SystemSetting record, @Param("example") SystemSettingExample example);

    int updateByPrimaryKeySelective(SystemSetting record);

    int updateByPrimaryKey(SystemSetting record);
}
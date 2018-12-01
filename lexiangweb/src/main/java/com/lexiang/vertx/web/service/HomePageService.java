package com.lexiang.vertx.web.service;

import com.google.common.collect.Maps;
import com.lexiang.vertx.web.entity.*;
import com.lexiang.vertx.web.mapper.HomePageContentMapper;
import com.lexiang.vertx.web.mapper.LunboMapper;
import com.lexiang.vertx.web.mapper.NavigatorMapper;
import com.lexiang.vertx.web.mapper.SystemSettingMapper;
import com.lexiang.vertx.web.utils.Commons;

import javax.inject.Inject;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author WillsTan on 11/1/18.
 * @since 1.0.0
 * email: tywills09@gmail.com
 */
public class HomePageService {

    @Inject
    NavigatorMapper navigatorMapper;

    @Inject
    LunboMapper lunboMapper;

    @Inject
    SystemSettingMapper systemSettingMapper;

    @Inject
    HomePageContentMapper homePageContentMapper;

    public void upSertNavigator(Navigator navigator){
        navigator.setTimeStamp(new Date());
        NavigatorExample example = new NavigatorExample();
        example.createCriteria().andNameEqualTo(navigator.getName()).andStatusEqualTo(0);
        if (navigatorMapper.countByExample(example) == 0){
            navigator.setStatus(0);
            navigatorMapper.insert(navigator);
        } else {
            navigatorMapper.updateByExampleSelective(navigator,example);
        }
    }

    public void upSertLunbo(Lunbo lunbo){
        lunbo.setTimeStamp(new Date());
        LunboExample example = new LunboExample();
        example.createCriteria().andPhotoAddressEqualTo(lunbo.getPhotoAddress()).andAttributeEqualTo(lunbo.getAttribute()).andStatusEqualTo(0);
        if (lunbo.getId() == null && lunboMapper.countByExample(example) == 0){
            lunbo.setStatus(0);
            lunboMapper.insert(lunbo);
        } else {
            lunboMapper.updateByExampleSelective(lunbo,example);
        }
    }

    public void upSertSystemSetting(SystemSetting systemSetting){
        SystemSettingExample example = new SystemSettingExample();
        example.createCriteria().getAllCriteria();
        if (systemSettingMapper.countByExample(example) == 0){
            systemSettingMapper.insert(systemSetting);
        } else {
            systemSettingMapper.updateByExampleSelective(systemSetting,example);
        }
    }

    public void upSertHomePageContent(HomePageContentWithBLOBs content){
        content.setTimeStamp(new Date());
        HomePageContentExample example = new HomePageContentExample();
        example.createCriteria().andStatusEqualTo(0);
        if (homePageContentMapper.countByExample(example) == 0){
            content.setStatus(0);
            homePageContentMapper.insert(content);
        } else {
            homePageContentMapper.updateByExampleSelective(content,example);
        }
    }

    public Map<String,Object> getNavigatorAndSysTemSetting(){
        Map<String,Object> map = Maps.newHashMap();
        SystemSettingExample systemSettingExample = new SystemSettingExample();
        systemSettingExample.createCriteria().getAllCriteria();
        SystemSetting systemSetting = systemSettingMapper.selectByExample(systemSettingExample).get(0);
        map.put("systemsetting", systemSetting);
        NavigatorExample navigatorExample = new NavigatorExample();
        navigatorExample.createCriteria().andStatusEqualTo(0);
        List<Navigator> navigatorList = navigatorMapper.selectByExample(navigatorExample);
        map.put("navigator", navigatorList);
        return map;
    }

    public Map<String,Object> getHomePageAll(){
        Map<String,Object> map = Maps.newHashMap();
        NavigatorExample navigatorExample = new NavigatorExample();
        navigatorExample.createCriteria().andStatusEqualTo(0);
        List<Navigator> navigatorList = navigatorMapper.selectByExample(navigatorExample);
        map.put("navigator", navigatorList);
        HomePageContentExample homePageContentExample = new HomePageContentExample();
        homePageContentExample.createCriteria().andStatusEqualTo(0);
        HomePageContentWithBLOBs homePageContents = homePageContentMapper.selectByExampleWithBLOBs(homePageContentExample).get(0);
        map.put("homepageContent", homePageContents);
        SystemSettingExample systemSettingExample = new SystemSettingExample();
        systemSettingExample.createCriteria().getAllCriteria();
        SystemSetting systemSettingList = systemSettingMapper.selectByExample(systemSettingExample).get(0);
        map.put("systemsetting", systemSettingList);
        LunboExample lunboExample = new LunboExample();
        lunboExample.createCriteria().andStatusEqualTo(0).andAttributeEqualTo(Commons.attribute_homepage_lunbo);
        List<Lunbo> lunboList = lunboMapper.selectByExample(lunboExample);
        map.put("lunbo", lunboList);
        return map;
    }

}

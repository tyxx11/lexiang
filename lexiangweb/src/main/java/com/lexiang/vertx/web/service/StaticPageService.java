package com.lexiang.vertx.web.service;

import com.lexiang.vertx.web.entity.StaticPages;
import com.lexiang.vertx.web.entity.StaticPagesExample;
import com.lexiang.vertx.web.mapper.StaticPagesMapper;

import javax.inject.Inject;
import java.util.Date;

public class StaticPageService {

    @Inject
    StaticPagesMapper staticPagesMapper;

    public StaticPages getStaticPage(){
        StaticPagesExample example = new StaticPagesExample();
        example.createCriteria().andStatusEqualTo(0);
        return staticPagesMapper.selectByExample(example).get(0);
    }

    public void upSert(StaticPages staticPages){
        staticPages.setTimeStamp(new Date());
        staticPages.setStatus(0);
        StaticPagesExample example = new StaticPagesExample();
        example.createCriteria().andStatusEqualTo(0);
        if(staticPagesMapper.countByExample(example) == 0){
            staticPagesMapper.insert(staticPages);
        } else {
            staticPagesMapper.updateByExampleSelective(staticPages, example);
        }
    }
}

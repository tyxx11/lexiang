package com.lexiang.vertx.web.service;

import com.lexiang.vertx.web.entity.*;
import com.lexiang.vertx.web.mapper.CustomerStoryDetailMapper;
import com.lexiang.vertx.web.mapper.CustomerStoryMapper;

import javax.inject.Inject;
import java.util.Date;
import java.util.List;

/**
 * @author WillsTan on 11/19/18.
 * @since 1.0.0
 * email: tywills09@gmail.com
 */
public class CustomStoryService {
    @Inject
    CustomerStoryMapper customerStoryMapper;

    @Inject
    CustomerStoryDetailMapper customerStoryDetailMapper;

    public List<CustomerStoryWithBLOBs> getAll(){
        CustomerStoryExample example  = new CustomerStoryExample();
        example.createCriteria().andStatusEqualTo(0);
        return customerStoryMapper.selectByExampleWithBLOBs(example);
    }

    public CustomerStoryDetailWithBLOBs getDetail(int id){
        CustomerStoryDetailExample example = new CustomerStoryDetailExample();
        example.createCriteria().andStatusEqualTo(0).andCustomerStoryIdEqualTo(id);
        List<CustomerStoryDetailWithBLOBs> list = customerStoryDetailMapper.selectByExampleWithBLOBs(example);
        return list.size() == 0 ? null : list.get(0);
    }

    public void save(CustomerStoryWithBLOBs customerStoryWithBLOBs){
        CustomerStoryExample example  = new CustomerStoryExample();
        customerStoryWithBLOBs.setTimeStamp(new Date());
        if (customerStoryWithBLOBs.getId() != null){
            example.createCriteria().andIdEqualTo(customerStoryWithBLOBs.getId());
            if (customerStoryMapper.countByExample(example) != 0){
                customerStoryMapper.updateByExampleSelective(customerStoryWithBLOBs,example);
            } else {
                customerStoryWithBLOBs.setStatus(0);
                customerStoryMapper.insertSelective(customerStoryWithBLOBs);
            }
        } else {
            customerStoryWithBLOBs.setStatus(0);
            customerStoryMapper.insertSelective(customerStoryWithBLOBs);
        }
    }

    public void saveDetail(CustomerStoryDetailWithBLOBs story){
        CustomerStoryDetailExample example  = new CustomerStoryDetailExample();
        story.setTimeStamp(new Date());
        if (story.getId() != null){
            example.createCriteria().andIdEqualTo(story.getId());
            if (customerStoryDetailMapper.countByExample(example) != 0){
                customerStoryDetailMapper.updateByExampleSelective(story,example);
            } else {
                story.setStatus(0);
                customerStoryDetailMapper.insertSelective(story);
            }
        } else {
            story.setStatus(0);
            customerStoryDetailMapper.insertSelective(story);
        }
    }

}

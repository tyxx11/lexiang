package com.lexiang.vertx.web.service;

import com.lexiang.vertx.web.entity.CustomerStoryExample;
import com.lexiang.vertx.web.entity.CustomerStoryWithBLOBs;
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

    public List<CustomerStoryWithBLOBs> getAll(){
        CustomerStoryExample example  = new CustomerStoryExample();
        example.createCriteria().andStatusEqualTo(0);
        return customerStoryMapper.selectByExampleWithBLOBs(example);
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

}

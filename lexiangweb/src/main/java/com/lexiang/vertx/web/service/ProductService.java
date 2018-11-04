package com.lexiang.vertx.web.service;

import com.lexiang.vertx.web.entity.*;
import com.lexiang.vertx.web.mapper.LexiangProductMapper;
import com.lexiang.vertx.web.mapper.LunboMapper;
import com.lexiang.vertx.web.utils.Commons;

import javax.inject.Inject;
import java.util.Date;
import java.util.List;

public class ProductService {

    @Inject
    LexiangProductMapper productMapper;

    @Inject
    LunboMapper lunboMapper;

    public int save(LexiangProductWithBLOBs product){
        product.setCreatedate(new Date());
        product.setModifydate(new Date());
        product.setStatus(0);
        return productMapper.insert(product);
    }

    public List<LexiangProductWithBLOBs> getAll(){
        LexiangProductExample example = new LexiangProductExample();
        example.createCriteria().getAllCriteria();
        return productMapper.selectByExampleWithBLOBs(example);
    }

    public int deteleProduct(int id){
        LexiangProductKey lexiangProductKey = new LexiangProductKey();
        lexiangProductKey.setId(id);
        return  productMapper.deleteByPrimaryKey(lexiangProductKey);
    }

    public List<LexiangProduct> getBy(LexiangProduct product){
        LexiangProductExample example = new LexiangProductExample();
        example.createCriteria().andStatusEqualTo(product.getStatus());
        return productMapper.selectByExample(example);
    }

    public List<Lunbo> getProductShowLunbo(){
        LunboExample example = new LunboExample();
        example.createCriteria().andStatusEqualTo(0).andAttributeEqualTo(Commons.attribute_productShow_lunbo);
        return lunboMapper.selectByExample(example);
    }

}

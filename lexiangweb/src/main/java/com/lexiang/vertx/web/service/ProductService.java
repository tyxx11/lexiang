package com.lexiang.vertx.web.service;

import com.lexiang.vertx.web.entity.LexiangProduct;
import com.lexiang.vertx.web.entity.LexiangProductExample;
import com.lexiang.vertx.web.entity.LexiangProductKey;
import com.lexiang.vertx.web.mapper.LexiangProductMapper;

import javax.inject.Inject;
import java.util.Date;
import java.util.List;

public class ProductService {

    @Inject
    LexiangProductMapper productMapper;

    public int save(LexiangProduct product){
        product.setCreatedate(new Date());
        product.setModifydate(new Date());
        product.setStatus(0);
        return productMapper.insert(product);
    }

    public List<LexiangProduct> getAll(){
        LexiangProductExample example = new LexiangProductExample();
        example.createCriteria().getAllCriteria();
        return productMapper.selectByExample(example);
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

}

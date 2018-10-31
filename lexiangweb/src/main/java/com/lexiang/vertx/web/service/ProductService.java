package com.lexiang.vertx.web.service;

import com.lexiang.vertx.web.entity.LexiangProduct;
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
        return productMapper.selectAll();
    }

    public int deteleProduct(int id){
        return  productMapper.deleteByPrimaryKey(id);
    }

    public List<LexiangProduct> getBy(LexiangProduct product){
        //todo changed to where select
        return productMapper.selectAll();
    }
}

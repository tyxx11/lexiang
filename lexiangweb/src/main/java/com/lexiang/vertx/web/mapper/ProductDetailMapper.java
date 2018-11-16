package com.lexiang.vertx.web.mapper;

import com.lexiang.vertx.web.entity.ProductDetail;
import com.lexiang.vertx.web.entity.ProductDetailExample;
import com.lexiang.vertx.web.entity.ProductDetailKey;
import com.lexiang.vertx.web.entity.ProductDetailWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProductDetailMapper {
    int countByExample(ProductDetailExample example);

    int deleteByExample(ProductDetailExample example);

    int deleteByPrimaryKey(ProductDetailKey key);

    int insert(ProductDetailWithBLOBs record);

    int insertSelective(ProductDetailWithBLOBs record);

    List<ProductDetailWithBLOBs> selectByExampleWithBLOBs(ProductDetailExample example);

    List<ProductDetail> selectByExample(ProductDetailExample example);

    ProductDetailWithBLOBs selectByPrimaryKey(ProductDetailKey key);

    int updateByExampleSelective(@Param("record") ProductDetailWithBLOBs record, @Param("example") ProductDetailExample example);

    int updateByExampleWithBLOBs(@Param("record") ProductDetailWithBLOBs record, @Param("example") ProductDetailExample example);

    int updateByExample(@Param("record") ProductDetail record, @Param("example") ProductDetailExample example);

    int updateByPrimaryKeySelective(ProductDetailWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(ProductDetailWithBLOBs record);

    int updateByPrimaryKey(ProductDetail record);
}
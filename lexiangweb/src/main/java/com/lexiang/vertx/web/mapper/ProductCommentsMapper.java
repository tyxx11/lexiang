package com.lexiang.vertx.web.mapper;

import com.lexiang.vertx.web.entity.ProductComments;
import com.lexiang.vertx.web.entity.ProductCommentsExample;
import com.lexiang.vertx.web.entity.ProductCommentsKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProductCommentsMapper {
    int countByExample(ProductCommentsExample example);

    int deleteByExample(ProductCommentsExample example);

    int deleteByPrimaryKey(ProductCommentsKey key);

    int insert(ProductComments record);

    int insertSelective(ProductComments record);

    List<ProductComments> selectByExample(ProductCommentsExample example);

    ProductComments selectByPrimaryKey(ProductCommentsKey key);

    int updateByExampleSelective(@Param("record") ProductComments record, @Param("example") ProductCommentsExample example);

    int updateByExample(@Param("record") ProductComments record, @Param("example") ProductCommentsExample example);

    int updateByPrimaryKeySelective(ProductComments record);

    int updateByPrimaryKey(ProductComments record);
}
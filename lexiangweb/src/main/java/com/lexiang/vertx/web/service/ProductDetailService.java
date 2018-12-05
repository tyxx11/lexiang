package com.lexiang.vertx.web.service;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.lexiang.vertx.web.entity.*;
import com.lexiang.vertx.web.mapper.*;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;

/**
 * @author WillsTan on 11/15/18.
 * @since 1.0.0
 * email: tywills09@gmail.com
 */
public class ProductDetailService {
    @Inject
    TravelTopoMapper travelTopoMapper;
    @Inject
    PriceContainMapper priceContainMapper;
    @Inject
    PriceNotContainMapper priceNotContainMapper;
    @Inject
    PriceTagMapper priceTagMapper;
    @Inject
    ProductDetailMapper productDetailMapper;
    @Inject
    ReadBeforeTravelMapper readBeforeTravelMapper;
    @Inject
    ReadBeforeTravelTagMapper readBeforeTravelTagMapper;

    public Map<String,Object> getProductDetail(int productId){
        Map<String,Object> result = Maps.newHashMap();
        ProductDetailKey key = new ProductDetailKey();
        key.setId(productId);
        ProductDetail productDetail = productDetailMapper.selectByPrimaryKey(key);
        result.put("productDetail", productDetail);
        TravelTopoExample travelTopoExample = new TravelTopoExample();
        travelTopoExample.createCriteria().andProductIdEqualTo(productId);
        List<TravelTopoWithBLOBs>  travelTopos = travelTopoMapper.selectByExampleWithBLOBs(travelTopoExample);
        result.put("travelTopo",travelTopos);
        //deal with price contain
        PriceContainExample priceContainExample = new PriceContainExample();
        priceContainExample.createCriteria().andProductIdEqualTo(productId);
        List<PriceContain> priceContainList = priceContainMapper.selectByExample(priceContainExample);
        PriceTagExample priceTagExample = new PriceTagExample();
        List<Integer> priceContainIds = Lists.newArrayList();
        for (PriceContain priceContain : priceContainList){
            priceContainIds.add(priceContain.getTagId());
        }
        priceTagExample.createCriteria().andIdIn(priceContainIds);
        result.put("priceContain",priceTagMapper.selectByExample(priceTagExample));
        //deal with price not contain
        PriceNotContainExample priceNotContainExample = new PriceNotContainExample();
        priceContainExample.createCriteria().andProductIdEqualTo(productId);
        List<PriceNotContain> priceNotContainList = priceNotContainMapper.selectByExample(priceNotContainExample);
        priceTagExample = new PriceTagExample();
        List<Integer> priceNotContainIds = Lists.newArrayList();
        for (PriceNotContain priceNotContain : priceNotContainList){
            priceNotContainIds.add(priceNotContain.getTagId());
        }
        priceTagExample.createCriteria().andIdIn(priceNotContainIds);
        result.put("priceNotContain", priceTagMapper.selectByExample(priceTagExample));
        //read before travel
        ReadBeforeTravelExample readBeforeTravelExample = new ReadBeforeTravelExample();
        readBeforeTravelExample.createCriteria().andProductIdEqualTo(productId);
        List<ReadBeforeTravel> readBeforeTravelList = readBeforeTravelMapper.selectByExample(readBeforeTravelExample);
        ReadBeforeTravelTagExample readBeforeTravelTagExample = new ReadBeforeTravelTagExample();
        List<Integer> readBeforeTagIds = Lists.newArrayList();
        for (ReadBeforeTravel readBeforeTravel: readBeforeTravelList){
            readBeforeTagIds.add(readBeforeTravel.getTagId());
        }
        readBeforeTravelExample.createCriteria().andIdIn(readBeforeTagIds);
        result.put("readBeforeTravel",readBeforeTravelTagMapper.selectByExampleWithBLOBs(readBeforeTravelTagExample));

        return result;

    }

    public void saveProductDetail(ProductDetailWithBLOBs productDetailWithBLOBs){
        ProductDetailExample example = new ProductDetailExample();
        if (productDetailWithBLOBs.getId() != null ){
            example.createCriteria().andIdEqualTo(productDetailWithBLOBs.getId());
            if (productDetailMapper.countByExample(example)!=0){
                productDetailMapper.updateByPrimaryKeySelective(productDetailWithBLOBs);
            } else {
                productDetailMapper.insertSelective(productDetailWithBLOBs);
            }
        } else {
            productDetailMapper.insertSelective(productDetailWithBLOBs);
        }
    }

    public void saveTravelTopo(TravelTopoWithBLOBs travelTopoWithBLOBs){
        TravelTopoExample example = new TravelTopoExample();
        if (travelTopoWithBLOBs.getId() != null){
            example.createCriteria().andIdEqualTo(travelTopoWithBLOBs.getId());
            if (travelTopoMapper.countByExample(example) != 0){
                travelTopoMapper.updateByPrimaryKeySelective(travelTopoWithBLOBs);
                return;
            }
        }
        travelTopoMapper.insertSelective(travelTopoWithBLOBs);
    }

    public void saveReadBeforeTravelTags(int productId, ReadBeforeTravelTagWithBLOBs readBeforeTravelTagWithBLOBs){
        ReadBeforeTravelTagExample example = new ReadBeforeTravelTagExample();
        int id;
        if (readBeforeTravelTagWithBLOBs.getId() != null ){
            example.createCriteria().andIdEqualTo(readBeforeTravelTagWithBLOBs.getId());
            if (readBeforeTravelTagMapper.countByExample(example) != 0){
                readBeforeTravelTagMapper.updateByPrimaryKeySelective(readBeforeTravelTagWithBLOBs);
                id = readBeforeTravelTagWithBLOBs.getId();
            } else {
                id = readBeforeTravelTagMapper.insertSelective(readBeforeTravelTagWithBLOBs);
            }
        } else {
            id = readBeforeTravelTagMapper.insertSelective(readBeforeTravelTagWithBLOBs);
        }
        ReadBeforeTravel readBeforeTravel = new ReadBeforeTravel();
        readBeforeTravel.setProductId(productId);
        readBeforeTravel.setTagId(id);
        ReadBeforeTravelExample readBeforeTravelExample = new ReadBeforeTravelExample();
        readBeforeTravelExample.createCriteria().andProductIdEqualTo(productId).andTagIdEqualTo(id);
        if (readBeforeTravelMapper.countByExample(readBeforeTravelExample) != 0){
            readBeforeTravelMapper.updateByExampleSelective(readBeforeTravel,readBeforeTravelExample);
        }else {
            readBeforeTravelMapper.insertSelective(readBeforeTravel);
        }
    }

    public void savePriceContainTags(int productId, PriceTag priceTag){
        PriceTagExample example = new PriceTagExample();
        if (priceTag.getId() != null){
            example.createCriteria().andIdEqualTo(priceTag.getId());
            if (priceTagMapper.countByExample(example) != 0){
                priceTagMapper.updateByPrimaryKeySelective(priceTag);
            } else {
                priceTagMapper.insertSelective(priceTag);
            }
        } else {
            priceTagMapper.insertSelective(priceTag);
        }
        PriceContainExample priceContainExample = new PriceContainExample();
        PriceContain priceContain = new PriceContain();
        priceContain.setProductId(productId);
        priceContain.setTagId(priceTag.getId());
        priceContainExample.createCriteria().andProductIdEqualTo(productId).andTagIdEqualTo(priceTag.getId());
        if (priceContainMapper.countByExample(priceContainExample) != 0){
            priceContainMapper.updateByExampleSelective(priceContain,priceContainExample);
        } else {
            priceContainMapper.insertSelective(priceContain);
        }
    }

    public void savePriceNotContainTags(int productId, PriceTag priceTag){
        PriceTagExample example = new PriceTagExample();
        if (priceTag.getId() != null){
            example.createCriteria().andIdEqualTo(priceTag.getId());
            if (priceTagMapper.countByExample(example) != 0){
                priceTagMapper.updateByPrimaryKeySelective(priceTag);
                priceTag.getId();
            } else {
                 priceTagMapper.insertSelective(priceTag);
            }
        } else {
            priceTagMapper.insertSelective(priceTag);
        }

        PriceNotContainExample priceContainExample = new PriceNotContainExample();
        PriceNotContain priceNotContain = new PriceNotContain();
        priceNotContain.setProductId(productId);
        priceNotContain.setTagId(priceTag.getId());
        priceContainExample.createCriteria().andProductIdEqualTo(productId).andTagIdEqualTo(priceTag.getId());
        if (priceNotContainMapper.countByExample(priceContainExample) != 0){
            priceNotContainMapper.updateByExampleSelective(priceNotContain,priceContainExample);
        } else {
            priceNotContainMapper.insertSelective(priceNotContain);
        }
    }

}

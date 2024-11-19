//package com.dinegood.springbootproject.Services;
//
//import com.dinegood.springbootproject.elasticrepo.ItemElasticSearchrepo;
//import com.dinegood.springbootproject.manager.RedisManager;
//import com.dinegood.springbootproject.model.Itemdetails;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cache.annotation.Cacheable;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//@Service
//public class ElasticItemService {
//    @Autowired
//    private ItemElasticSearchrepo itemElasticSearchrepo;
//    @Autowired
//    private RedisManager redisManager;
//    @Cacheable(value = "HighRated", key = "#id")
//    public List<Itemdetails> getToprating(final int id){
//        String key = "HighRated:" + id;
//        List<Itemdetails> items = (List<Itemdetails>) redisManager.getItemFromRedis(key);
//        if (items != null) {
//            return items;
//        }
//        items = this.itemElasticSearchrepo.findByCategoryAndRatingGreaterThanEqual(id, 5);
//        redisManager.storeItemInRedis(key, items);
//        return items;
//    }
//
//}

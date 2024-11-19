package com.dinegood.springbootproject.services;

import com.dinegood.springbootproject.dao.Itemdao;
import com.dinegood.springbootproject.manager.RedisManager;
//import com.dinegood.springbootproject.elasticrepo.ItemElasticSearchrepo;
import com.dinegood.springbootproject.repo.ItemRepo;
import com.dinegood.springbootproject.model.Itemdetails;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;

import java.util.List;

@Service
public class ItemService {
    @Autowired
    private ItemRepo itemRepo;
    @Autowired
    private Itemdao itemdao;
    @Autowired
    private static RedisManager redisManager;
    @Autowired
    private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(ItemService.class);


    @Cacheable(value = "AllItems")
    public List<Itemdetails> getallitem(){
        return itemdao.GAI();
    }
    @Cacheable(value = "AllCatItems", key = "#id")
    public List<Itemdetails> getCatItems(final int id){
        return itemdao.GCI(id);
    }
    @Cacheable(value = "LowestCost", key = "#id")
    public List<Itemdetails> getTop5ItemsWithLowestCost(final int id){
        return itemdao.getfirst5ItemsWithLowestCost(id);
    }
    @Cacheable(value = "HighRated", key = "#id")
    public List<Itemdetails> getToprating(final int id){
        return itemdao.gethighrating(id);
    }
    public Itemdetails saveItem(final Itemdetails item) {
        return itemRepo.save(item);
    }


}

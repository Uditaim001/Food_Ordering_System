package com.dinegood.springbootproject.dao;

import com.dinegood.springbootproject.manager.RedisManager;
import com.dinegood.springbootproject.model.Itemdetails;
import com.dinegood.springbootproject.repo.ItemRepo;
import com.dinegood.springbootproject.services.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


@Component
public class ItemDao {
    @Autowired
    private ItemRepo itemRepo;

    @Autowired
    private static RedisManager redisManager;
    @Autowired
    private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(ItemService.class);

    public List<Itemdetails> gethighrating(final int id){
        try {
            String key = "HighRated:" + id;

        List<Itemdetails> items = (List<Itemdetails>) redisManager.getItemFromRedis(key);
        if (items != null) {
            return items;
        }
        items = this.itemRepo.findByCategoryAndRatingGreaterThanEqual(id, 5);
        redisManager.storeItemInRedis(key, items);
        return items;}
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public List<Itemdetails> getfirst5ItemsWithLowestCost(final int id){
        try{String key = "LowestCost:" + id;
        if (redisManager.containsKey(key)) {

            LOGGER.info(
                    "Redis searched");
            return (List<Itemdetails>) redisManager.getItemFromRedis(key);
        }
        LOGGER.error("Redis not reached {}",key);
        List<Itemdetails> items = this.itemRepo.findTop5ByCategoryOrderByCostAsc(id);
        redisManager.storeItemInRedis(key, items);
        return items;}
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public List<Itemdetails> GCI(final int id){
        try{
        List<Itemdetails> catitems= this.itemRepo.findByCategory(id);
        return catitems;}
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public List<Itemdetails> GAI(){
        try{List<Itemdetails> items= (List<Itemdetails>)itemRepo.findAll();
        return items;}
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public Optional<Itemdetails> findByCategs(int id){
        return itemRepo.findById(id);
    };
//    List<Itemdetails> findTop5ByCatgsOrderByCostAsc(int id);
//    List<Itemdetails> findByCatgsAndRatingGreaterThanEqual(int catId, int rating);
}

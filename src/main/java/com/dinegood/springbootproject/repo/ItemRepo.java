package com.dinegood.springbootproject.repo;

import com.dinegood.springbootproject.cofig.RedisConfig;
import com.dinegood.springbootproject.model.Itemdetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ItemRepo extends CrudRepository<Itemdetails, Integer> {
    public List<Itemdetails> findByCategory(int id);
    List<Itemdetails> findTop5ByCategoryOrderByCostAsc(int id);
    Page<Itemdetails> findByCategoryAndRatingGreaterThanEqual(int catId, int rating, Pageable pageable);


}

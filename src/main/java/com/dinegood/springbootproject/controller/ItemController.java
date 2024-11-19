package com.dinegood.springbootproject.controller;


import com.dinegood.springbootproject.model.Itemdetails;
import com.dinegood.springbootproject.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ItemController {
    @Autowired
    private ItemService itemService;
    @Autowired

    @GetMapping("/items")
    public List<Itemdetails> getallitems(){
        return this.itemService.getallitem();
    }
    @GetMapping("/items/by-category")
    public List<Itemdetails> getitems(@RequestParam final int id){
        return itemService.getCatItems(id);
    }
    @GetMapping("/items/lowest-cost/by-category")
    public List<Itemdetails> getlowestcost(@RequestParam final int id){
        return itemService.getTop5ItemsWithLowestCost(id);
    }
    @GetMapping("/items/high-rating/by-category")
    public List<Itemdetails> gettoprated(@RequestParam final int id){
        return itemService.getToprating(id);
    }

    @PostMapping("/add/items")
    public ResponseEntity<Itemdetails> createItem(@RequestBody final Itemdetails item) {
        Itemdetails savedItem = itemService.saveItem(item);
        return ResponseEntity.ok(savedItem);
    }
}

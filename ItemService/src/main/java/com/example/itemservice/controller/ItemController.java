package com.example.itemservice.controller;

import com.example.itemservice.model.Item;
import com.example.itemservice.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/item")
public class ItemController {
    @Autowired
    private ItemService itemService;
    @GetMapping("/get-all")
    public List<Item> getAll() {
       return itemService.getAll();
   }
}

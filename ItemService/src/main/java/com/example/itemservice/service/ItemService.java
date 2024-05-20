package com.example.itemservice.service;

import com.example.itemservice.model.Item;
import com.example.itemservice.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {
    @Autowired
    private ItemRepository itemRepository;
    public List<Item> getAll() {
        return itemRepository.findAll();
    }

}

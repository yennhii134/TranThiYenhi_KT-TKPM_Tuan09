package com.example.itemservice;

import com.example.itemservice.model.Item;
import com.example.itemservice.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ItemServiceApplication {
    @Autowired
    private ItemRepository itemRepository;
    public static void main(String[] args) {
        SpringApplication.run(ItemServiceApplication.class, args);
    }
//    @Bean
//    CommandLineRunner commandLineRunner(){
//        return new CommandLineRunner() {
//            @Override
//            public void run(String... args) throws Exception {
//                for (int i=1; i<=10; i++){
//                    itemRepository.save(new Item("Item" + i));
//                }
//            }
//        };
//    }
}

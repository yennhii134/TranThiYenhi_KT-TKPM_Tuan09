package com.example.orderservice.controller;

import com.example.orderservice.model.Order;
import com.example.orderservice.service.OrderService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/order")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderController {
    @Autowired
    OrderService orderService;
    static final String BASEURL = "http://localhost:8082/api/item";
    static final String ORDER_SERVICE = "OrderService";
    @Autowired
    RestTemplate restTemplate;
    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
    @GetMapping("/get-items")
    @CircuitBreaker(name = ORDER_SERVICE, fallbackMethod = "orderFallBack")
    public ResponseEntity<?> getItems() {
        List<Order> orders = restTemplate.getForObject(BASEURL + "/get-all", ArrayList.class);
        return new ResponseEntity<>(orders, HttpStatus.OK);    }
    public ResponseEntity<?> orderFallBack(Exception e) {
        System.out.println("Fallback method called due to: " + e.getMessage());
        return new ResponseEntity<>("Item service is down", HttpStatus.OK);
    }
}

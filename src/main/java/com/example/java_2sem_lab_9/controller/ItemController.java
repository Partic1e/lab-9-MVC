package com.example.java_2sem_lab_9.controller;

import net.minidev.json.JSONObject;
import com.example.java_2sem_lab_9.model.Item;
import com.example.java_2sem_lab_9.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class ItemController {
    @Autowired
    private ItemService itemService;

    @PostMapping("/list")
    public HttpStatus createItem(@RequestBody JSONObject object) {
        itemService.addProduct(object.getAsString("name"));
        return HttpStatus.OK;
    }

    @GetMapping("/list")
    public Iterable<Item> getAll() {
        return itemService.getAll();
    }

    @PutMapping("/list/{id}")
    public HttpStatus checkItem(@PathVariable int id) {
        itemService.checkItem(id);
        return HttpStatus.OK;
    }

    @DeleteMapping("/list/{id}")
    public HttpStatus deleteItem(@PathVariable int id) {
        itemService.deleteItem(id);
        return HttpStatus.OK;
    }
}
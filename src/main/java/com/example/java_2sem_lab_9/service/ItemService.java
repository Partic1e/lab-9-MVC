package com.example.java_2sem_lab_9.service;


import com.example.java_2sem_lab_9.model.Item;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ItemService {
    private final ArrayList<Item> list = new ArrayList<Item>(){};
    private int count = 0;

    public ArrayList<Item> getAll() {
        return list;
    }

    public Item addProduct(String name) {
        Item item = new Item(count, name);
        count++;
        list.add(item);
        return item;
    }

    public Item getItem(int id) {
        for (Item item: list) {
            if(item.getId() == id)
                return item;
        }
        return null;
    }

    public void checkItem(int id) {
        getItem(id).setIsCheck();
    }

    public void deleteItem(int id) {
        list.remove(getItem(id));
    }
}
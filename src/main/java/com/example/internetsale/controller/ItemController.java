package com.example.internetsale.controller;

import com.example.internetsale.model.Item;
import com.example.internetsale.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemController {

//    List<Item> items = new ArrayList<>();
    @Autowired
    ItemService itemService;

    @GetMapping
    public List<Item> items(@RequestParam (name = "name", required = false) String name){
        return itemService.listItems(name);
    }

    @PostMapping("/create")
    public Item createItem(@RequestBody Item newItem){
        return itemService.saveItem(newItem);
    }

    @PutMapping("/{id}")
    public Item updateItem(@RequestBody Item newItem, @PathVariable Long id) {
      return itemService.updateItem(id, newItem);

    }

    @DeleteMapping("/delete/{id}")
    public void deleteItem(@PathVariable Long id){
        itemService.deleteItem(id);
    }
}

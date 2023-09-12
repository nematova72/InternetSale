package com.example.internetsale.controller;

import com.example.internetsale.model.Item;
import com.example.internetsale.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/itemsW")
public class WebProductController {

//    List<Item> items = new ArrayList<>();
    @Autowired
    ItemService itemService;

    @GetMapping
    public String items(@RequestParam (name = "name", required = false) String name, Model model){
        model.addAttribute("items", itemService.listItems(name));
        return "items";
    }

    @PostMapping("/create")
    public String addItem(@RequestBody Item item){
        itemService.saveItem(item);
        return "redirect:/";
    }

    @PutMapping("/{id}")
    public String itemInfo(@PathVariable Long id, Model model) {
        model.addAttribute("item", itemService.getItemById(id));
        return "item-info";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteItem(@PathVariable ("items_id") Long id){
        itemService.deleteItem(id);
        return "redirect:/";
    }

    @DeleteMapping
    public String deleteAll(){
        return "Deleted";
    }

}

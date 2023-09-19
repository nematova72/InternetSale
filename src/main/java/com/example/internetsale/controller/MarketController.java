package com.example.internetsale.controller;

import com.example.internetsale.entity.MarketDto;
import com.example.internetsale.model.Market;
import com.example.internetsale.service.MarketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/markets")
public class MarketController {

    @Autowired
    MarketService marketService;

    @GetMapping
    public List<MarketDto> markets(@RequestParam(name = "name", required = false) String name){
        return marketService.listMarkets(name);
    }

    @PostMapping("/create")
    public Market createMarket(@RequestBody Market newMarket){
        return marketService.saveMarket(newMarket);
    }

    @PutMapping("/{id}")
    public Market updateMarket(@RequestBody Market newMarket, @PathVariable Long id) {
        return marketService.updateMarket(id, newMarket);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteMarket(@PathVariable Long id){
        marketService.deleteItem(id);
    }
}

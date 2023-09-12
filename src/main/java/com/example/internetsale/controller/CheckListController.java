package com.example.internetsale.controller;

import com.example.internetsale.model.Item;
import com.example.internetsale.service.ListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/list")
public class CheckListController {

    @Autowired
    ListService listService;

    @GetMapping
    public Item lists(@RequestParam (name = "name", required = false) String name) {
        return  listService.listLists(name);
    }


}

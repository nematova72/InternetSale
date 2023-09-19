package com.example.internetsale.service;

import com.example.internetsale.model.Item;
import com.example.internetsale.repo.ListRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListService {

    private final ListRepo listRepo;


    public ListService(ListRepo listRepo) {
        this.listRepo = listRepo;
    }

    public List<com.example.internetsale.model.List> listLists(String name){
            return listRepo.findAllByName(name);
        }
//        return items.stream()
//                .filter(item -> item.getName().contains(itemName))
//                .collect(Collectors.toList());
    }



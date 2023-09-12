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

    public Item listLists(String name){


            return listRepo.findByName(name);
        }

}

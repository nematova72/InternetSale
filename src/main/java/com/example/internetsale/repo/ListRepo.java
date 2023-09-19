package com.example.internetsale.repo;

import com.example.internetsale.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ListRepo extends JpaRepository<Item, Long> {



    List<com.example.internetsale.model.List> findAllByName(String name);

}

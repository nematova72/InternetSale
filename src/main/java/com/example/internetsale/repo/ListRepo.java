package com.example.internetsale.repo;

import com.example.internetsale.model.Item;
import com.example.internetsale.model.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListRepo extends JpaRepository<Item, Long> {


    Item findByName(String name);

}

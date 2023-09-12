package com.example.internetsale.repo;

import com.example.internetsale.model.Item;
import org.apache.catalina.LifecycleState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepo extends JpaRepository<Item, Long> {

 List<Item> findAllByName(String name);

 Item findByItemsId(Long items_id);
 Item findByName(Long name);
}

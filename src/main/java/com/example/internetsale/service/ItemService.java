package com.example.internetsale.service;

import com.example.internetsale.model.Item;
import com.example.internetsale.repo.ItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    private final ItemRepo itemRepo;

    @Autowired
    public ItemService(ItemRepo itemRepo) {
        this.itemRepo = itemRepo;
    }

    public List<Item> listItems(String name){
        if(name == null)
               return itemRepo.findAll();
        else {
            return itemRepo.findAllByName(name);
        }
//        return items.stream()
//                .filter(item -> item.getName().contains(itemName))
//                .collect(Collectors.toList());
    }

    public Item saveItem(Item newItem) {

        return itemRepo.save(newItem);
    }

    public Item findById(Long items_Id){

        return itemRepo.findByItemsId(items_Id);
    }

    public void deleteItem(Long items_Id) {
        itemRepo.deleteById(items_Id);
    }

    public Item updateItem(Long items_id, Item newItem){
        Item item = itemRepo.findByItemsId(items_id);
        item.setName(newItem.getName());
        item.setColor(newItem.getColor());
        item.setPrice(newItem.getPrice());

        return itemRepo.save(item);
    }

    public Item getItemById(Long items_id){
        Item result = itemRepo.findByItemsId(items_id);
        //тут обработка
        return result;
    }


}

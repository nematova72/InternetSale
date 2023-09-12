package com.example.internetsale.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table (name="items")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "items_id")
    private Long itemsId;
    @Column(name="name")
    private String name;
    @Column(name="color")
    private String color;
    @Column(name="price")
    int price;

    public Item() {
    }

    public Item(Long itemsId, String name, String color, int price) {
        this.itemsId = itemsId;
        this.name = name;
        this.color = color;
        this.price = price;
    }

    public Long getItemsId() {
        return itemsId;
    }

    public void setItemsId(Long items_id) {
        this.itemsId = items_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}

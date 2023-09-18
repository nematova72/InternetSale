package com.example.internetsale.model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
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
    @NotEmpty(message= "Name should not be empty")
    @Size(min = 2, max = 30, message = "Name shoud be between 2 and 30 character")
    @Column(name="name")
    private String name;

    @NotEmpty(message = "Color should not be empty")
    @Column(name="color")
    private String color;
    @Min(value = 0, message = "price should be greater than 0")
    @Column(name="price")
    private int price;


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

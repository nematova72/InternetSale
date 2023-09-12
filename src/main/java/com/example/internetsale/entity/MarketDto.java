package com.example.internetsale.entity;

public class MarketDto {

    private Long id;
    private String name;
    private String location;

    private String items_name;

    public MarketDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getItems_name() {
        return items_name;
    }

    public void setItems_name(String items_name) {
        this.items_name = items_name;
    }

    public MarketDto(Long id, String name, String location, String items_name) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.items_name = items_name;
    }
}

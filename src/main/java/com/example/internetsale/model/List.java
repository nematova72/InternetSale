package com.example.internetsale.model;

import javax.persistence.*;

@Entity
@Table ( name="lists")
public class List {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name = "list_id")
    private Long listId;
    @Column(name = "name")
    private String name;
    @Column(name = "departure")
    private String departure;
    @Column(name = "location")
    private String location;

   public List() {
   }
    public List(Long listId, String name, String departure, String location) {
        this.listId = listId;
        this.name = name;
        this.departure = departure;
        this.location = location;
    }

    public Long getListId() {
        return listId;
    }

    public void setListId(Long listId) {
        this.listId = listId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}

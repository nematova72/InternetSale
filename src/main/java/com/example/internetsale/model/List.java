package com.example.internetsale.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Entity
@Table (name="lists")
public class List {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name = "list_id")
    private Long listId;
    @Column(name = "surname")
    private String surname;
    @Column(name = "name")
    private String name;
    @Column(name = "items_id")
    private Long items_id;
    @Column(name = "markets_id")
    private Long markets_id;
}
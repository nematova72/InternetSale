package com.example.internetsale.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="markets")
@AllArgsConstructor
@Data
@NoArgsConstructor
public class Market {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "location")
    private String location;
    @Column(name = "items_id")
    private Long items_id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "items_id", referencedColumnName = "items_id",insertable = false, updatable = false)
    Item itemNo;

}
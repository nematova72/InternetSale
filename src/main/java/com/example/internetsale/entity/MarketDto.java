package com.example.internetsale.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MarketDto {

    private Long id;
    private String name;
    private String location;
    private String items_name;

}

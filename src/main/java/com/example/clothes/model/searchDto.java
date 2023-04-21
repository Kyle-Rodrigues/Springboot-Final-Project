package com.example.clothes.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class searchDto {
    private String brand;
    private String name;

    public String getBrand(){
        return brand;
    }
    public String getName(){
        return name;
    }
}

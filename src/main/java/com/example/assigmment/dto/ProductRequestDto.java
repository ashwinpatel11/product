package com.example.assigmment.dto;

import lombok.Data;

@Data
public class ProductRequestDto {

    private String name;
    private String description;
    private String brand;
    private String tags[];
    private String category;

}

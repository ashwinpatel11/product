package com.example.assigmment.entity;

import com.example.assigmment.dto.ProductRequestDto;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.UUID;


@Getter
@Setter
@Entity
public class Product {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;
    private String name;
    private String description;
    private String brand;
    private String tags[];
    private String category;
    private LocalDateTime createdAt = LocalDateTime.now();



    public static Product dtoToProduct(ProductRequestDto requestDto){
        Product product=new Product();
        product.setName(requestDto.getName());
        product.setBrand(requestDto.getBrand());
        product.setTags(requestDto.getTags());
        product.setCategory(requestDto.getCategory());
        product.setDescription(requestDto.getDescription());
        return product;
    }
}

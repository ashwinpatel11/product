package com.techavidus.product.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pid;

    @NotBlank
    @Size(min = 5, max = 100, message = "product name  must be 5 to 100 characters")
    private String productName;

    @NotBlank
    @Size(min = 10, max = 100, message = "product details  must be 10 to 100 characters")
    private String productDetails;

    @Min(value = 1000, message = "minimum price 1000 required")
    private Double productPrice;

    @Min(value = 1, message = "mininmunm qty 1 required")
    private int qty;

    private Date cretedDate;


}

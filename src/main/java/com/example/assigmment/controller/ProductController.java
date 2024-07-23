package com.example.assigmment.controller;

import com.example.assigmment.dto.ProductRequestDto;
import com.example.assigmment.entity.Product;
import com.example.assigmment.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/v1/products")
@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public Product addProduct(@RequestBody ProductRequestDto productRequestDto) {
        return productService.addProduct(productRequestDto);

    }

    @GetMapping
    public List<Product> getAllProduct(@RequestParam(required = false) String searchCategory,
                                       @RequestParam(required = false, defaultValue = "1") int pageSize,
                                       @RequestParam(required = false, defaultValue = "1") int pageNo) {
        List<Product> productList = productService.getAllProduct(searchCategory, pageNo, pageSize);
        return productList;
    }


}

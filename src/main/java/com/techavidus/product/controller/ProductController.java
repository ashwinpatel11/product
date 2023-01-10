package com.techavidus.product.controller;

import com.techavidus.product.entity.Product;
import com.techavidus.product.service.ProductService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(tags = "Product")
@RestController
@RequestMapping("/v1")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/test")
    public String test() {
        return "hello how are you?";
    }

    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody @Valid Product product) {
        return productService.addProduct(product);
    }

    @GetMapping("/getProduct/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @GetMapping("/getAllProducts")
    public List<Product> getAllProducts() {
        return productService.getAllProduct();
    }

    @PutMapping("/updateProduct")
    public Product updateProduct(@RequestBody Product Product) {
        return productService.updateProduct(Product);
    }

    @DeleteMapping("/deleteProduct/{id}")
    public String deleteProductById(@PathVariable Long id) {
        productService.deleteProduct(id);
        return "product deleted";
    }
}

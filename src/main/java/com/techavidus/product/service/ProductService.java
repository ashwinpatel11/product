package com.techavidus.product.service;

import com.techavidus.product.exception.BusinessException;
import com.techavidus.product.repository.ProductRepository;
import com.techavidus.product.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    public Product getProductById(Long pid) {
        Optional<Product> product= productRepository.findById(pid);
        if(product.isPresent()){
            return product.get();
        }
        throw new BusinessException("product not found");
    }


    public List<Product> getAllProduct() {
       List<Product> productList= productRepository.findAll();
       if(productList.isEmpty()){
           throw new BusinessException("product not found");
       }
       return productList;
    }

    public Product updateProduct(Product product) {
        Optional<Product> product1= productRepository.findById(product.getPid());
        if(product1.isPresent()){
         return productRepository.save(product);
        }
        throw new BusinessException("product not found");
    }

    public void deleteProduct(Long pid) {
        Optional<Product> product= productRepository.findById(pid);
        if(product.isPresent()){
            productRepository.deleteById(pid);
        }
        throw new BusinessException("product not found");

    }
}

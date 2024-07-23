package com.example.assigmment.service;


import com.example.assigmment.dto.ProductRequestDto;
import com.example.assigmment.entity.Product;
import com.example.assigmment.exception.ProductNotFoundException;
import com.example.assigmment.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;


    public Product addProduct(ProductRequestDto productRequestDto) {
        Product product = Product.dtoToProduct(productRequestDto);
        return productRepository.save(product);
    }


    public List<Product> getAllProduct(String searchCategory, int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        Page<Product> productPage = null;

        if (searchCategory != null) {
            productPage = productRepository.findByCategoryOrderByCreatedAtDesc(searchCategory, pageable);

        } else {
            productPage = productRepository.findAllByOrderByCreatedAtDesc(pageable);
        }
        List<Product> productList = productPage.getContent();
        if (productList.isEmpty()) {
            throw new ProductNotFoundException("No product available");
        }
        return productList;
    }


}

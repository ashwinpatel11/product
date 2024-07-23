package com.example.assigmment.repository;

import com.example.assigmment.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {

    Page<Product> findByCategoryOrderByCreatedAtDesc(String category,Pageable pageable);

    Page<Product> findAllByOrderByCreatedAtDesc(Pageable pageable);






}

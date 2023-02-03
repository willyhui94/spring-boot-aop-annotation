package com.willyhui94.springbootaopannotation.repository;

import com.willyhui94.springbootaopannotation.entity.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {}

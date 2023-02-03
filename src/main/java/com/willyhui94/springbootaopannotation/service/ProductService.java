package com.willyhui94.springbootaopannotation.service;

import com.willyhui94.springbootaopannotation.entity.model.Product;

import java.util.List;

public interface ProductService {

  List<Product> findAllProducts();

  List<Product> addProducts(List<Product> products);
}

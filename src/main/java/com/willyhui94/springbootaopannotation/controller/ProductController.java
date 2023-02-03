package com.willyhui94.springbootaopannotation.controller;

import com.willyhui94.springbootaopannotation.entity.model.Product;
import com.willyhui94.springbootaopannotation.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class ProductController {

  @Autowired private ProductService productServiceImpl;

  public ProductController(ProductService productServiceImpl) {
    this.productServiceImpl = productServiceImpl;
  }

  @GetMapping("/products")
  public List<Product> getAllProducts() {
    List<Product> productList = productServiceImpl.findAllProducts();
    return productList;
  }

  @PostMapping("/products")
  public List<Product> saveProducts(@RequestBody List<Product> products) {
    List<Product> productList = productServiceImpl.addProducts(products);
    return productList;
  }
}

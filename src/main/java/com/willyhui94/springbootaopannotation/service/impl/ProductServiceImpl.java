package com.willyhui94.springbootaopannotation.service.impl;

import com.willyhui94.springbootaopannotation.annotation.AfterReturningTraceable;
import com.willyhui94.springbootaopannotation.annotation.AfterTraceable;
import com.willyhui94.springbootaopannotation.annotation.AroundTraceable;
import com.willyhui94.springbootaopannotation.annotation.BeforeTraceable;
import com.willyhui94.springbootaopannotation.entity.model.Product;
import com.willyhui94.springbootaopannotation.repository.ProductRepository;
import com.willyhui94.springbootaopannotation.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

  @Autowired private ProductRepository productRepository;

  public ProductServiceImpl(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  @PostConstruct
  public void initDB() {
    List<Product> products = new ArrayList<>();
    Product product1 = Product.builder().id(10001).name("Book 10001").price(10.99).build();
    Product product2 = Product.builder().id(10002).name("Book 10002").price(20.99).build();
    Product product3 = Product.builder().id(10003).name("Book 10003").price(30.99).build();
    Product product4 = Product.builder().id(10004).name("Book 10004").price(40.99).build();
    Product product5 = Product.builder().id(10005).name("Book 10005").price(50.99).build();
    products.add(product1);
    products.add(product2);
    products.add(product3);
    products.add(product4);
    products.add(product5);
    productRepository.saveAll(products);
  }

  @AroundTraceable(param1 = "ProductServiceImpl param1", param2 = "ProductServiceImpl param2")
  @BeforeTraceable
  @AfterTraceable
  @AfterReturningTraceable
  @Override
  public List<Product> findAllProducts() {
    return productRepository.findAll();
  }

  @AroundTraceable()
  @BeforeTraceable
  @AfterTraceable
  @AfterReturningTraceable
  @Override
  public List<Product> addProducts(List<Product> products) {
    return productRepository.saveAll(products);
  }
}

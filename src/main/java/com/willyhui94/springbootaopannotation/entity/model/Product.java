package com.willyhui94.springbootaopannotation.entity.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Product {

  @Id private int id;
  private String name;
  private double price;
}

package com.javabeans.io.productcatalog.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String brand;
    private String color;
    private Double price;
    private Long ram;
    private Long rom;
    private Long version;
    private String processor;
    private Long camera;
    private Long batteryCapacity;
    private String special;
    private Double rating;
    private Long warrenty;

}

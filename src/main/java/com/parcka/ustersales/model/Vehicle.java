package com.parcka.ustersales.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Vehicle {
    @Id
    @GeneratedValue
    Long id;
    String brand;
    String model;
    String plate;
    char LicenseRequired;

}

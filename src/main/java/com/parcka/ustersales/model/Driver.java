package com.parcka.ustersales.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Driver {
    @Id
    @GeneratedValue
    Long id;
    String name;
    String surname;
    char license;


}

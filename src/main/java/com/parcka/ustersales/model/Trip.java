package com.parcka.ustersales.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity
public class Trip {

    @Id
    Long id;

    @ManyToOne
    Driver driver;

    @ManyToOne
    Vehicle vehicle;

    Date date;

}

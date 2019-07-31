package com.parcka.ustersales.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Trip {

    @Id
    @GeneratedValue
    Long id;

    @ManyToOne
    Driver driver;

    @ManyToOne
    Vehicle vehicle;
    @DateTimeFormat(pattern = "MM/dd/yyyy")
    Date date;

}

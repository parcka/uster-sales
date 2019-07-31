package com.parcka.ustersales.repository;


import com.parcka.ustersales.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface VehicleRepository extends JpaRepository<Vehicle, Long>{

    @Query("SELECT DISTINCT v.brand from Vehicle v")
    List<String> findDistinctBrand();

    @Query("SELECT DISTINCT v.model from Vehicle v")
    List<String> findDistinctModel();

    List<Vehicle> findAllByBrand(String brand);

    @Query("SELECT v FROM Vehicle v left join Trip t on t.vehicle.id = v.id and t.date = ?1 where t.vehicle.id is null ")
    List<Vehicle> findByNotInDate(Date date);
}

package com.parcka.ustersales.service;

import com.parcka.ustersales.model.Vehicle;
import com.parcka.ustersales.repository.VehicleRepository;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService {


    @Autowired
    VehicleRepository vehicleRepository;

    public Vehicle save(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);

    }

    public List<Vehicle> getAll() {
        return vehicleRepository.findAll();
    }

}

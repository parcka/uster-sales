package com.parcka.ustersales.service;

import com.parcka.ustersales.model.Vehicle;
import com.parcka.ustersales.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleService {


    @Autowired
    VehicleRepository vehicleRepository;

    public Vehicle save(Vehicle vehicle) {
        return vehicleRepository.saveAndFlush(vehicle);

    }

    public List<Vehicle> getAll() {
        return vehicleRepository.findAll();
    }

    public Optional<Vehicle> findByID(Long id) {
        return vehicleRepository.findById(id);
    }

    public void delete(Vehicle vehicle) {
        vehicleRepository.delete(vehicle);
    }

    public void deleteById(long id) {
        vehicleRepository.deleteById(id);
    }

}

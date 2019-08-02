package com.parcka.ustersales.service;

import com.parcka.ustersales.model.Vehicle;
import com.parcka.ustersales.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class VehicleService {


    @Autowired
    VehicleRepository vehicleRepository;

    public Vehicle save(Vehicle vehicle) {
        return vehicleRepository.saveAndFlush(vehicle);

    }

    public List<Vehicle> saveBulk(List<Vehicle> vehicle) {
        List<Vehicle> result = vehicleRepository.saveAll(vehicle);
        vehicleRepository.flush();
        return result;

    }

    public List<String> getAllBrands() {
        return vehicleRepository.findDistinctBrand();
    }

    public List<String> getAllModels() {
        return vehicleRepository.findDistinctModel();
    }

    public List<Vehicle> getAll() {
        return vehicleRepository.findAll();
    }

    public Page<Vehicle> getAll(int page, int size) {
        return vehicleRepository.findAll(PageRequest.of(page,size));
    }

    public List<Vehicle> findByNotInDate(Date date) {
        return vehicleRepository.findByNotInDate(date);
    }

    public Optional<Vehicle> findByID(Long id) {
        return vehicleRepository.findById(id);
    }

    public List<Vehicle> findByBrand(String brand) {
        return vehicleRepository.findAllByBrand(brand);
    }

    public void delete(Vehicle vehicle) {
        vehicleRepository.delete(vehicle);
    }

    public void deleteById(long id) {
        vehicleRepository.deleteById(id);
    }

}

package com.parcka.ustersales.service;

import com.parcka.ustersales.model.Driver;
import com.parcka.ustersales.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DriverService {


    @Autowired
    DriverRepository driverRepository;

    public Driver save(Driver driver) {
        return driverRepository.saveAndFlush(driver);

    }

    public List<Driver> getAll() {
        return driverRepository.findAll();
    }

    public Optional<Driver> findByID(Long id) {
        return driverRepository.findById(id);
    }

    public void delete(Driver driver) {
        driverRepository.delete(driver);
    }

    public void deleteById(long id) {
        driverRepository.deleteById(id);
    }

}

package com.parcka.ustersales.service;

import com.parcka.ustersales.model.Driver;
import com.parcka.ustersales.model.Vehicle;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class MainService {

    @Autowired
    VehicleService vehicleService;
    @Autowired
    DriverService driverService;

    public void populateDB() {
        List<Driver> drivers = new ArrayList<>();
        List<Vehicle> vehicles = new ArrayList<>();
        for (int i = 0; i <= 20; i++) {
            Driver driver = createDriver("Paco" + i);
            Vehicle vehicle = createVehicle("XDJA" + i);

            drivers.add(driver);
            vehicles.add(vehicle);

        }

        vehicleService.saveBulk(vehicles);
        driverService.saveBulk(drivers);
    }


    private Vehicle createVehicle(String plate) {
        return Vehicle.builder()
                .plate(plate)
                .model("Trooper")
                .brand("Isuzu")
                .licenseRequired('A').build();
    }

    private Driver createDriver(String name) {
        return Driver.builder()
                .name(name)
                .surname("Panzon")
                .license('A').build();
    }


}

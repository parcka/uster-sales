package com.parcka.ustersales.controller;

import com.parcka.ustersales.model.Driver;
import com.parcka.ustersales.model.Trip;
import com.parcka.ustersales.model.Vehicle;
import com.parcka.ustersales.service.DriverService;
import com.parcka.ustersales.service.VehicleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Slf4j
@RequestMapping("/trips")
public class TripController {


    @Autowired
    VehicleService vehicleService;

    @Autowired
    DriverService driverService;

    private static final String TRIP_CREATION = "pages/trip-creation";
    private static final String REDIRECT_TRIPS_LIST_TRIPS = "redirect:/trips/listTrips";


    @GetMapping("/listTrips")
    public String getListVehicle(Model model, @RequestParam(defaultValue = "0") int page) {

        model.addAttribute("trip", new Trip());
        return TRIP_CREATION;
    }

    @GetMapping("/createTrip")
    public String getCreateTrip(Model model, @RequestParam(defaultValue = "0") int page) {

        model.addAttribute("trip", new Trip());
        return TRIP_CREATION;
    }


    @ModelAttribute("brands")
    public List<String> getComboBrandVehicles() {
        log.info("Getting all brand vehicles");
        return vehicleService.getAllBrands();
    }

    @GetMapping("/getModels")
    @ResponseBody
    public List<String> getComboModelVehicles() {
        log.info("Getting all models vehicles");
        return vehicleService.getAllModels();
    }

    @ModelAttribute("comboVehicles")
    public List<Vehicle> getComboVehicles() {
        log.info("Getting all vehicles");
        return vehicleService.getAll();
    }

    @ModelAttribute("comboDriver")
    public List<Driver> getComboDrivers() {
        log.info("Getting all drivers");
        return driverService.getAll();
    }

//    @PostMapping("/saveVehicle")
////    @ModelAttribute(value = "vehicle")
//    public String saveVehicle(Vehicle vehicle) {
//        log.info("Saving vehicle: {}", vehicle);
//        vehicleService.save(vehicle);
//        return REDIRECT_TRIPS_LIST_TRIPS;
//    }
//
//    @GetMapping("/delete")
//    public String delete(long id) {
//        log.info("Deleting vehicle ID: {}", id);
//        vehicleService.deleteById(id);
//        return REDIRECT_TRIPS_LIST_TRIPS;
//    }
//
//
//    @GetMapping("/findOne")
//    @ResponseBody
//    public Vehicle findOne(long id) {
//        log.info("Getting vehicle ID: {}", id);
//
//        return vehicleService.findByID(id).get();
//    }
//
//
//    public String update(Vehicle vehicle) {
//        log.info("Updating vehicle: {}", vehicle);
//        vehicleService.save(vehicle);
//        return REDIRECT_TRIPS_LIST_TRIPS;
//    }

    private Vehicle createTestVehicle() {
        return Vehicle.builder()
                .brand("ISUZU")
                .licenseRequired('3')
                .model("TROOPER")
                .plate("A256IL")
                .build();

    }

}

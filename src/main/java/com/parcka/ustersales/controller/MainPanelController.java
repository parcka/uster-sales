package com.parcka.ustersales.controller;


import com.parcka.ustersales.dao.VehicleDao;
import com.parcka.ustersales.model.Vehicle;
import com.parcka.ustersales.service.VehicleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
public class MainPanelController {

    private static final String MAIN_PANEL = "main-panel";
    private static final String LIST_VEHICLE = "pages/listVehicle";


    @Autowired
    VehicleService vehicleService;

    @GetMapping("/")
    public String getMainPanel(){

        return MAIN_PANEL;
    }

    @GetMapping("/list-vehicle")
    public String getListVehicle(Model model, @RequestParam(defaultValue = "0") int page){

        model.addAttribute("dataVehicle",vehicleService.getAll());
        return LIST_VEHICLE;
    }

    @PostMapping("/saveVehicle")
    public String saveVehicle(Vehicle vehicle){
      log.info("Saving vehicle: {}",vehicle);
      vehicleService.save(vehicle);
      return LIST_VEHICLE;
    }

    private Vehicle createTestVehicle(){
        return Vehicle.builder()
                .brand("ISUZU")
                .LicenseRequired("3")
                .model("TROOPER")
                .plate("A256IL")
                .build();

    }

}

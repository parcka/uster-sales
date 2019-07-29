package com.parcka.ustersales.controller;

import com.parcka.ustersales.model.Vehicle;
import com.parcka.ustersales.service.VehicleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Slf4j
//@RequestMapping("/vehicle")
public class VehicleController {


    @Autowired
    VehicleService vehicleService;

    private static final String LIST_VEHICLE = "pages/listVehicle";
    private static final String REDIRECT_LIST_VEHICLE = "redirect:/listVehicle";


    @GetMapping("/listVehicle")
    public String getListVehicle(Model model, @RequestParam(defaultValue = "0") int page) {

        model.addAttribute("dataVehicle", vehicleService.getAll());
        return LIST_VEHICLE;
    }

    @PostMapping("/saveVehicle")
    public String saveVehicle(Vehicle vehicle) {
        log.info("Saving vehicle: {}", vehicle);
        vehicleService.save(vehicle);
        return REDIRECT_LIST_VEHICLE;
    }

    @GetMapping("/delete")
    public String delete(long id) {
        log.info("Deleting vehicle ID: {}", id);
        vehicleService.deleteById(id);
        return REDIRECT_LIST_VEHICLE;
    }


    @GetMapping("/findOne")
    @ResponseBody
    public Vehicle findOne(long id) {
        log.info("Getting vehicle ID: {}", id);

        return vehicleService.findByID(id).get();
    }

    public String update(Vehicle vehicle) {
        log.info("Updating vehicle: {}", vehicle);
        vehicleService.save(vehicle);
        return REDIRECT_LIST_VEHICLE;
    }

    private Vehicle createTestVehicle() {
        return Vehicle.builder()
                .brand("ISUZU")
                .LicenseRequired("3")
                .model("TROOPER")
                .plate("A256IL")
                .build();

    }

}

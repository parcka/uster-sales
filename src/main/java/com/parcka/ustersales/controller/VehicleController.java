package com.parcka.ustersales.controller;

import com.parcka.ustersales.model.Vehicle;
import com.parcka.ustersales.service.VehicleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.lang.Character.toUpperCase;

@Controller
@Slf4j
@RequestMapping("/vehicles")
public class VehicleController {


    @Autowired
    VehicleService vehicleService;

    private static final String LIST_VEHICLE = "pages/listVehicle";
    private static final String REDIRECT_LIST_VEHICLE = "redirect:/vehicles/listVehicle";


    @GetMapping("/listVehicle")
    public String getListVehicle(Model model, @RequestParam(defaultValue = "0") int page) {


        int size = 5; //default page size is 5
        Page<Vehicle> vehiclePage = vehicleService.getAll(page,size);
        int totalPages = vehiclePage.getTotalPages();

        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }


        model.addAttribute("dataVehicle", vehiclePage);
        return LIST_VEHICLE;
    }

    @PostMapping("/saveVehicle")
//    @ModelAttribute(value = "vehicle")
    public String saveVehicle(Vehicle vehicle) {
        licenseToUperCase(vehicle);
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
                .licenseRequired('3')
                .model("TROOPER")
                .plate("A256IL")
                .build();

    }

    private void licenseToUperCase(Vehicle vehicle){
        char license = Character.toUpperCase(vehicle.getLicenseRequired());
        vehicle.setLicenseRequired(license);
    }

}

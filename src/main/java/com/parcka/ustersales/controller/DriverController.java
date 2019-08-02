package com.parcka.ustersales.controller;

import com.parcka.ustersales.model.Driver;
import com.parcka.ustersales.service.DriverService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@Slf4j
@RequestMapping("/drivers")
public class DriverController {


    @Autowired
    DriverService driverService;

    private static final String LIST_DRIVER = "pages/listDriver";
    private static final String REDIRECT_LIST_DRIVER = "redirect:/drivers/listDriver";


    @GetMapping("/listDriver")
    public String getListDriver(Model model, @RequestParam(defaultValue = "0") int page) {


        int size = 5; //default page size is 5

        Page<Driver> vehiclePage = driverService.getAll(page, size);
        int totalPages = vehiclePage.getTotalPages();

        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }


        model.addAttribute("dataDriver", vehiclePage);
        return LIST_DRIVER;
    }

    @PostMapping("/saveDriver")
//    @ModelAttribute(value = "Driver")
    public String saveDriver(Driver driver) {
        licenseToUperCase(driver);
        log.info("Saving Driver: {}", driver);
        driverService.save(driver);
        return REDIRECT_LIST_DRIVER;
    }

    @GetMapping("/delete")
    public String delete(long id) {
        log.info("Deleting Driver ID: {}", id);
        driverService.deleteById(id);
        return REDIRECT_LIST_DRIVER;
    }


    @GetMapping("/findOne")
    @ResponseBody
    public Driver findOne(long id) {
        log.info("Getting Driver ID: {}", id);

        return driverService.findByID(id).get();
    }


    public String update(Driver Driver) {
        log.info("Updating Driver: {}", Driver);
        driverService.save(Driver);
        return REDIRECT_LIST_DRIVER;
    }

    private Driver createTestDriver() {
        return Driver.builder()

                .build();

    }

    private void licenseToUperCase(Driver driver) {
        char license = Character.toUpperCase(driver.getLicense());
        driver.setLicense(license);
    }

}

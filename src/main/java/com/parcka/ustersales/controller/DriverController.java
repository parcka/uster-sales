package com.parcka.ustersales.controller;

import com.parcka.ustersales.model.Driver;
import com.parcka.ustersales.service.DriverService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

        model.addAttribute("dataDriver", driverService.getAll());
        return LIST_DRIVER;
    }

    @PostMapping("/saveDriver")
//    @ModelAttribute(value = "Driver")
    public String saveDriver(Driver Driver) {
        log.info("Saving Driver: {}", Driver);
        driverService.save(Driver);
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

}

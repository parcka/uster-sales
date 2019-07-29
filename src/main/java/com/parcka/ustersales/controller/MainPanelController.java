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

@Slf4j
@Controller
public class MainPanelController {

    private static final String MAIN_PANEL = "pages/main-panel";



    @Autowired
    VehicleService vehicleService;

    @GetMapping("/")
    public String getMainPanel() {

        return MAIN_PANEL;
    }



}

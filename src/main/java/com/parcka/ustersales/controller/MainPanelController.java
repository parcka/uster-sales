package com.parcka.ustersales.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainPanelController {

    private static final String MAIN_PANEL = "main-panel";
    private static final String CRUD_VEHICLE = "pages/crud-vehicle";

    @GetMapping("/")
    public String getMainPanel(){
        return MAIN_PANEL;
    }

    @GetMapping("/crud-vehicle")
    public String getCrudVehicle(){
        return CRUD_VEHICLE;
    }

}

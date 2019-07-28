package com.parcka.ustersales.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainPanelController {

    private static final String MAIN_PANEL = "main-panel";

    @GetMapping("/")
    public String getMainPanel(){
        return MAIN_PANEL;
    }

}

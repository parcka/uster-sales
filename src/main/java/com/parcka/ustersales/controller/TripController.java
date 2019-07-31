package com.parcka.ustersales.controller;

import com.parcka.ustersales.model.Driver;
import com.parcka.ustersales.model.Trip;
import com.parcka.ustersales.model.Vehicle;
import com.parcka.ustersales.service.DriverService;
import com.parcka.ustersales.service.TripService;
import com.parcka.ustersales.service.VehicleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@Slf4j
@RequestMapping("/trips")
public class TripController {


    @Autowired
    VehicleService vehicleService;

    @Autowired
    DriverService driverService;

    @Autowired
    TripService tripService;

//    Pages
    private static final String TRIP_CREATION = "pages/trip-creation";
    private static final String TRIP_PICK_DATE = "pages/trip-pick-date";
    private static final String TRIP_PICK_VEHICLE = "pages/trip-pick-vehicle";
    private static final String TRIP_PICK_DRIVER = "pages/trip-pick-driver";
    private static final String TRIP_LIST_TRIP = "pages/list-trip";

//    Actions
    private static final String REDIRECT_TRIPS_LIST_TRIPS = "redirect:/trips/listTrip";
    private static final String REDIRECT_TRIPS_PICK_DATE = "redirect:/trips/pickDate";
    private static final String REDIRECT_TRIPS_PICK_VEHICLE = "redirect:/trips/pickVehicle";
    private static final String REDIRECT_TRIPS_PICK_DRIVER = "redirect:/trips/pickDriver";
    private static final String REDIRECT_TO_HOME = "redirect:/";


    //Session var
    private static final String ACTUAL_TRIP = "trip";


    @GetMapping("/listTrip")
    public String getListVehicle(Model model, @RequestParam(defaultValue = "0") int page) {

        model.addAttribute("dataTrip", tripService.getAll());
        return TRIP_LIST_TRIP;
    }

    @GetMapping("/createTrip")
    public String getCreateTrip(Model model) {

        model.addAttribute("trip", new Trip());
        return REDIRECT_TRIPS_PICK_DATE;
    }

    @GetMapping("/pickDate")
    public String getPickDate(Model model) {

//        model.addAttribute("trip", Trip.builder().date(new Date()).build());
        model.addAttribute("trip", new Trip());
        return TRIP_PICK_DATE;
    }

    @PostMapping("/pickDate")
    public String postPickDate(@ModelAttribute("trip") Trip trip, Model model, HttpSession session) {

        session.setAttribute("trip",trip);
//        model.addAttribute("trip", trip);
        return REDIRECT_TRIPS_PICK_VEHICLE;
    }

    @GetMapping("/pickVehicle")
    public String getPickVehicle(@ModelAttribute(value = "trip") Trip trip ,Model model, HttpSession session) {

        model.addAttribute(ACTUAL_TRIP, session.getAttribute(ACTUAL_TRIP));
        model.addAttribute("vehicle", new Vehicle());
        return TRIP_PICK_VEHICLE;
    }

    @PostMapping("/pickVehicle")
    public String postPickVehicle(Model model, HttpServletRequest request, HttpSession session) {

       Trip trip = (Trip) session.getAttribute(ACTUAL_TRIP);

       trip.setVehicle(getVehicleFromRequestAndID(request));

        return REDIRECT_TRIPS_PICK_DRIVER;
    }

    @GetMapping("/pickDriver")
    public String getPickDriver(Model model) {

        model.addAttribute("driver", new Driver());
        return TRIP_PICK_DRIVER;
    }


    @PostMapping("/pickDriver")
    public String postPickDriver(Model model, HttpServletRequest request, HttpSession session) {


        Trip trip = (Trip) session.getAttribute(ACTUAL_TRIP);

        trip.setDriver(getDriverFromRequestAndID(request));

        saveTrip(trip);

        return REDIRECT_TRIPS_LIST_TRIPS;
    }

    private Driver getDriverFromRequestAndID(HttpServletRequest request){
        Long idDriver = Long.valueOf(request.getParameter("comboDriver"));
        return driverService.findByID(idDriver).get();
    }

    private Vehicle getVehicleFromRequestAndID(HttpServletRequest request){
        Long idVehicle = Long.valueOf(request.getParameter("comboVehicle"));
        return vehicleService.findByID(idVehicle).get();
    }

    private void saveTrip(Trip trip){
        log.info("Creating TRIP {}", trip);
        tripService.save(trip);
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

/*    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.registerCustomEditor(       Date.class,
                new CustomDateEditor(new SimpleDateFormat("MM/dd/yyyy"), true, 10));
    }*/

}

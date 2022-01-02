package com.example.demo.User;

import com.example.demo.Ride.Ride;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class DriverController {
    private DriverFunctions driver;

    public DriverController(){
        driver=new DriverFunctions();
    }

    @PostMapping("/driver/signUp")
    public String signUp(@RequestBody String userName,@RequestBody String  password, @RequestBody String mobileNumber, @RequestBody String email,@RequestBody String license,@RequestBody String nationalID){
        return driver.signUp(userName,password,mobileNumber,email,license,nationalID);
    }

    @GetMapping("/driver/logIn/{userName}")
    public boolean logIn(@PathVariable String userName, @PathVariable String password){
        return driver.logIn(userName,password);
    }

    @PutMapping ("/driver/Add-Fav-Loc")
    public void addFavLocation(@RequestBody String area){
        driver.addFavLocation(area);
    }

    @GetMapping("/driver/List-Rate")
    public void listRatings(){
        driver.listRatings();
    }

    @PutMapping("/driver/Update")
    public void update (@RequestBody Ride r) {
        driver.update(r);
    }

    @GetMapping("/driver/list-Req-Rides")
    public void listRequestedRides() {
        driver.listRequestedRides();
    }

    @PutMapping("/driver/choose-Ride")
    public void chooseRide(@RequestBody int rideChoice){
        driver.chooseRide( rideChoice);
    }

    @PutMapping("/driver/offer-Ride")
    public void offerPrice(@RequestBody int id,@RequestBody double offer){
        driver.offerPrice(id,offer);
    }

    @PutMapping("/driver/arrived-Source")
    public void arriveToLocation(@RequestBody int id){
        driver.arriveToLocation(id);
    }

    @PutMapping("/driver/arrived-Destination")
    public void arriveToDestination( @RequestBody int id){
        driver.arriveToDestination(id);
    }

    @PutMapping("/driver/logOut")
    public void logOut(){
        driver.logOut();
    }
}






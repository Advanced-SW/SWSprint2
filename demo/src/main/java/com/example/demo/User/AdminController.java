package com.example.demo.User;

import java.net.http.HttpResponse;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
public class AdminController {

    private Admin admin;
    public AdminController(){
         admin = new Admin();
    }


    @PostMapping("/admin/signup")
    public String signUp( @RequestBody String userName,@RequestBody String password,@RequestBody String mobileNumber,@RequestBody String email){
        return admin.signUp(userName,password,mobileNumber,email);
    }

    @GetMapping("/admin/login/{userName}")
    public boolean logIn(@PathVariable String userName, @PathVariable String password){
        return admin.logIn(userName,password);
    }

    @PutMapping("/admin/Verify")
    public void verify(){
        admin.verify();
    }

    @PutMapping("/admin/suspend")
    public void suspend(@RequestBody String name){
        admin.suspend(name);
    }

    @GetMapping("/admin/check-Ride-Events")
    public void checkRideEvents(){
        admin.checkRideEvents();
    }

    @PutMapping("/admin/Add-Discount")
    public void addDiscountToArea(@RequestBody String location){
        admin.addDiscountToArea(location);
    }


    @PostMapping("/admin/Add-Holidays")
    public void addHolidays(@RequestBody String date){
        admin.addHolidays(date);
    }

    @PutMapping("/admin/log-out")
    public void logOut(){
        admin.logOut();
    }

}

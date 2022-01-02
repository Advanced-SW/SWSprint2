
package com.example.demo.User;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
@RestController
public class UserController {
    private UserFunctions user;
    public UserController(){
        user=new UserFunctions();
    }

    @GetMapping("/Client/logIn/{userName}")
    public boolean logIn(@PathVariable String userName, @PathVariable String password ) {
        user.logIn(userName,password);
        return user.logIn(userName,password);
    }

    @PostMapping("/Client/signUp")
    public String signUp(@RequestBody String userName,@RequestBody String password,@RequestBody String mobileNumber,@RequestBody String email,@RequestBody int day,@RequestBody int month){
       return user.signUp(userName,password,mobileNumber,email,day,month);

    }

    @PostMapping("/client/req-Ride")
    public void requestRide(@RequestBody String source,@RequestBody String destination,@RequestBody int passengerNum ){
        user.requestRide(source,destination,passengerNum);
    }

    @PutMapping("/client/rate-driver")
    public void rateDriver(@RequestBody int id,@RequestBody double urRating){
        user.rateDriver(id, urRating);
    }

    @GetMapping("/client/check-driver-rate")
    public String checkDriverRating(@PathVariable int id){
        return  user.checkDriverRating(id);
    }

    @GetMapping("/client/check-ride-price")
    public String checkPrice(@PathVariable int id){
        return user.checkPrice(id);
    }

    @PutMapping("/client/accept-offer")
    public void acceptOffer(@RequestBody String offerChoice,@RequestBody int id){
        user.acceptOffer(offerChoice,id);
    }

    @PostMapping("/client/logOut")
    public void logOut(){
        user.logOut();
    }

}

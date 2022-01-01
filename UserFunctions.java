/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Users_System;

import Database_System.*;
import Ride_System.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


/**
 *
 * @author Zainab
 */
public class UserFunctions extends User  {

    //private User client;
    public controlData data = new controlData();


    public UserFunctions() {

    }

    public void requestRide(String source,String destination,int passengerNum ) {

        ArrayList<Area> tmp=data.database.getSystemAreas();
        Area sourceArea=new Area(source);
        Area destinationArea=new Area(destination);
        Ride ride = new Ride(sourceArea, destinationArea, passengerNum);
        ride.setClient(this);
        for(int i=0; i<tmp.size();i++){
            if((tmp.get(i).getLocation()).equals(sourceArea.getLocation())){
                tmp.get(i).Notify(ride);
                break;
            }
        }
        System.out.println("Your ride Id: " + ride.getRideId());
        int nOfRides = this.getNumOfRides();
        nOfRides++;
        this.setNumOfRides(nOfRides);
        data.addNewRide(ride);
        System.out.println("You requested a ride successfully! Please wait.......");

    }

    public void rateDriver(int id,double urRating) {
        ArrayList<Ride> tmp = data.database.getRides();
        Ride ride = new Ride();
        CalculateAvgRate rateCal=new CalculateAvgRate();
        for (int i = 0; i < tmp.size(); i++) {
            if (id == tmp.get(id).getRideId()) {
                ride = tmp.get(id);
                break;
            }
        }
        rateCal.calculateNewRate(ride.getDriver(), urRating);
        ride.setRate(urRating);

    }

    public String checkDriverRating(int id) {
        ArrayList<Ride> tmp = data.database.getRides();
        Ride ride = new Ride();
        for (int i = 0; i < tmp.size(); i++) {
            if (id == tmp.get(id).getRideId()) {
                ride = tmp.get(id);
                break;
            }
        }
        String  output="The driver rating is: " + ride.getDriver().getAvgRate();
        return output;
    }

    public String checkPrice(int id) {
        ArrayList<Ride> tmp = data.database.getRides();
        Ride ride = new Ride();
        for (int i = 0; i < tmp.size(); i++) {
            if (id == tmp.get(id).getRideId()) {
                ride = tmp.get(id);
                break;
            }
        }
           String output = "Price is: "+ride.getDiscountPrice();
        return output;
    }

    public void acceptOffer(String offerChoice, int id){
        ArrayList<Ride> tmp = data.database.getRides();
        Ride ride = new Ride();
        for (int i = 0; i < tmp.size(); i++) {
            if (id == tmp.get(id).getRideId()) {
                ride = tmp.get(id);
                break;
            }
        }
        if ((offerChoice.equalsIgnoreCase("yes"))) {
            ride.setAcceptedDriverOffer(true);
            Event event = new Event();
            Map acceptOffer = new HashMap();
            LocalDateTime time = LocalDateTime.now();
            acceptOffer.put("Event_Name", "Accept_Offer");
            acceptOffer.put("Event_Time", time);
            acceptOffer.put("User_Name", this.getName());
            event.setMap(acceptOffer);
            ride.addEvent(event);
        } else if ((offerChoice.equalsIgnoreCase("no"))) {
            ride.setAcceptedDriverOffer(false);
        }
    }

    public void logOut() {
        this.setLoggedIn(false);
    }

}



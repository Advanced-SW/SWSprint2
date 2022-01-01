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
public class DriverFunctions extends Driver implements  Observer {

    public controlData data = new controlData();
   

    public DriverFunctions() {

    }


    public void addFavLoction(String area) {
        boolean found = false;
        ArrayList<Area> tmp = data.database.getSystemAreas();
        for (int i = 0; i < tmp.size(); i++) {
            if (area.equals(tmp.get(i).getLocation())) {
                found = true;
                this.getFavArea().add(tmp.get(i));
                tmp.get(i).registerObserver(this);
                break;
            }
        }
        if (!found) {
            Area favArea = new Area(area);
            data.addSystemAreas(favArea);
            this.getFavArea().add(favArea);
            favArea.registerObserver(this);
        }

    }

    public void listRatings() {
        ArrayList<Ride> tmp;
        tmp = this.getRides();
        for (int i = 0; i < tmp.size(); i++) {
            System.out.println(tmp.get(i).getRate());
        }

    }

    public void update(Ride r) {
        addReqRide(r);

    }

    public void listRequestedRides() {

        ArrayList<Ride> tmp = getReqRides();
        for (int i = 0; i < tmp.size(); i++) {
            if (!(tmp.get(i).getInAction())) {
                System.out.println("The ride " + i + 1 + " :");
                tmp.get(i).toString();
            }

        }
    }
    public void chooseRide(int rideChoice){
        ArrayList<Ride> tmp = getReqRides();
        tmp.get(rideChoice - 1).setInAction(true);
        tmp.get(rideChoice - 1).setDriver(this);
        this.setAvailable(false);
    }

    public void offerPrice(int id,double offer) {

       
        ArrayList<Ride> tmp = data.database.getRides();
        Ride ride = new Ride();
        for (int i = 0; i < tmp.size(); i++) {
            if (id == tmp.get(id).getRideId()) {
                ride = tmp.get(id);
                break;
            }
        }
        ride.setPrice(offer);
        ApplyDiscount discount=new ApplyDiscount();
        discount.discountProcessing(ride);
        LocalDateTime time = LocalDateTime.now();
        Event event = new Event();
        Map offerPrice = new HashMap();
        offerPrice.put("Event_Name", "Offering_Price");
        offerPrice.put("Event_Time", time);
        offerPrice.put("Captain_Name", this.getName());
        offerPrice.put("offered_Price", offer);
        event.setMap(offerPrice);
        ride.addEvent(event);

    }

    public void arriveToLocation(int id) {

        ArrayList<Ride> tmp = data.database.getRides();
        Ride ride = new Ride();
        for (int i = 0; i < tmp.size(); i++) {
            if (id == tmp.get(id).getRideId()) {
                ride = tmp.get(id);
                break;
            }
        }
        if (ride.getAcceptedDriverOffer()) {
            System.out.println("Arrived to source");
            LocalDateTime time = LocalDateTime.now();
            Event event = new Event();
            Map arrivedSource = new HashMap();
            arrivedSource.put("Event_Name", "Arrived_To_Source");
            arrivedSource.put("Event_Time", time);
            arrivedSource.put("Captain_Name", this.getName());
            arrivedSource.put("Client_Name", ride.getClient().getName());
            event.setMap(arrivedSource);
            ride.addEvent(event);
        }

    }

    public void arriveToDestination(int id) {

        ArrayList<Ride> tmp = data.database.getRides();
        Ride ride = new Ride();
        for (int i = 0; i < tmp.size(); i++) {
            if (id == tmp.get(id).getRideId()) {
                ride = tmp.get(id);
                break;
            }
        }
        System.out.println("Arrived to destination");
        LocalDateTime time = LocalDateTime.now();
        Event event = new Event();
        Map arrivedDestination = new HashMap();
        arrivedDestination.put("Event_Name", "Arrived_To_Destination");
        arrivedDestination.put("Event_Time", time);
        arrivedDestination.put("Captain_Name", this.getName());
        arrivedDestination.put("Client_Name", ride.getClient().getName());
        event.setMap(arrivedDestination);
        ride.addEvent(event);
        this.addRide(ride);

    }

    public void logOut() {
        this.setLoggedIn(false);
    }
}

package Ride_System;

import Users_System.*;
import java.util.ArrayList;

public class Ride {

    private Area source;
    private Area destination;
    private UserFunctions client;
    private DriverFunctions driver;
    private double rate;
    private double price;
    private double discountPrice;
    private boolean acceptedDriverOffer;
    private int passengersNumber;
    private static int rideId = 0;
    private boolean inAction = false;
    private boolean hasDiscount=false;
    private ArrayList<Event> rideEvents = new ArrayList();

    public Ride() {
    }

    public Ride(Area source, Area destination, int passengersNumber) {
        this.source = source;
        this.destination = destination;
        this.passengersNumber = passengersNumber;
        rideId++;
    }

    public void setClient(UserFunctions client) {
        this.client = client;
    }

    public void setDriver(DriverFunctions driver) {
        this.driver = driver;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }


    public void setPrice(double price) {
        this.price = price;
    }

    public void setInAction(boolean inAction) {
        this.inAction = inAction;
    }

    public void setDiscountPrice(double discountPrice) {
        this.discountPrice = discountPrice;
    }

    public double getDiscountPrice() {
        return discountPrice;
    }

    public boolean getInAction() {
        return inAction;
    }

    public static int getRideId() {
        return rideId;
    }

    public Area getSource() {
        return source;
    }

    public void setAcceptedDriverOffer(boolean acceptedDriverOffer) {
        this.acceptedDriverOffer = acceptedDriverOffer;
    }

    public int getPassengersNumber() {
        return passengersNumber;
    }

    public boolean getAcceptedDriverOffer() {
        return acceptedDriverOffer;
    }

    public Area getDestination() {
        return destination;
    }

    public UserFunctions getClient() {
        return client;
    }

    public DriverFunctions getDriver() {
        return driver;
    }

    public double getRate() {
        return rate;
    }

    public double getPrice() {
        return price;
    }

    public String toString() {
        return "The requested ride source: " + getSource() + "/n The requested ride destination :" + getDestination() + "/n The client name is: " + getClient().getName();
    }

    public void addEvent(Event e) {
        rideEvents.add(e);
    }

    public ArrayList<Event> getRideEvents() {
        return rideEvents;
    }

    public boolean getHasDiscount() {
        return hasDiscount;
    }

    public void setHasDiscount(boolean hasDiscount) {
        this.hasDiscount = hasDiscount;
    }

}

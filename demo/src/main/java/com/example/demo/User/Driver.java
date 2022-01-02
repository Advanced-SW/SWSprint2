package com.example.demo.User;


import com.example.demo.Ride.*;
import com.example.demo.Database.*;

import java.util.ArrayList;


public class Driver extends Person {

    private String license;
    private String NationalID;
    private ArrayList<Area> favArea = new ArrayList();
    private ArrayList<Ride> rides = new ArrayList();
    private ArrayList<Ride> reqRides = new ArrayList();
    protected double avgRate;
    boolean verify;
    boolean suspend;
    boolean available=true;
    public ControlData data = new ControlData();


    public void setData(String name, String password, String mobile, String email, String license, String NationalID) {
        this.name = name;
        this.password = password;
        this.mobile = mobile;
        this.email = email;
        this.license = license;
        this.NationalID = NationalID;
        verify = false;
        suspend = false;
        available = true;
    }

    public String getLicense() {
        return license;
    }

    public String getNationalID() {
        return NationalID;
    }

    public ArrayList<Area> getFavArea() {
        return favArea;
    }

    public ArrayList<Ride> getRides() {
        return rides;
    }

    public double getAvgRate() {
        return avgRate;
    }

    public boolean getVerify() {
        return verify;
    }

    public boolean getSuspend() {
        return suspend;
    }

    public boolean getAvailable() {
        return available;
    }

    public ArrayList<Ride> getReqRides() {
        return reqRides;
    }

    public void addReqRide(Ride ride) {
        reqRides.add(ride);
    }

    public void addRide(Ride ride) {
        rides.add(ride);
    }

    public void setAvgRate(double avgRate) {
        this.avgRate = avgRate;
    }


    public void setVerify(boolean verify) {
        this.verify = verify;
    }

    public void setSuspend(boolean suspend) {
        this.suspend = suspend;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String signUp(String userName,String  password,String mobileNumber,String email,String license,String nationalID) {
        this.setData(userName, password, mobileNumber, email, license, nationalID);
        data.addPendedDriver(this);
        return "pending...";
    }

    @Override
    public boolean logIn(String userName, String password) {

        boolean found = false;
        ArrayList<Person> tmp = data.database.getUsers();
        for (int i = 0; i < tmp.size(); i++) {
            if (tmp.get(i) instanceof Driver) {
                if (userName.equals(tmp.get(i).getName()) && password.equals(tmp.get(i).getPassword()) && !(((Driver)tmp.get(i)).getSuspend())) {
                    if (((Driver) tmp.get(i)).getVerify()) {
                        tmp.get(i).setLoggedIn(true);
                        System.out.println("Logged in successfully");
                        found = true;
                        break;
                    } else {
                        System.out.println("Please wait to be verified");
                        found = true;
                        break;
                    }
                }
                else if(userName.equals(tmp.get(i).getName()) && password.equals(tmp.get(i).getPassword()) && (((Driver)tmp.get(i)).getSuspend())){
                    System.out.println("You are suspended");
                    return false;
                }

            }
        }
        if (!found) {
            System.out.println("Please sign up first");
        }
        return true;
    }

    public String signUp(String userName, String password, String mobileNumber, String email ){
        return " ";
    }

}


package com.example.demo.Ride;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.example.demo.User.*;
import java.util.ArrayList;

/**
 *
 * @author Zainab
 */
public class Area implements Subject {

    private String location;
    private boolean haveDiscount;
    public ArrayList<Observer> observers =new ArrayList();

    public Area() {
    }


    public Area(String location) {
        this.location = location;
        this.haveDiscount=false;
    }

    public String getLocation() {
        return location;
    }


    public void setHaveDiscount(boolean haveDiscount) {
        this.haveDiscount = haveDiscount;
    }

    public boolean getHaveDiscount() {
        return haveDiscount;
    }

    public void registerObserver(Observer o) {
        observers.add(o);
    }

    public void unRegisterObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void Notify(Ride r) {
        for (int i = 0; i < observers.size(); i++) {
            if (((DriverFunctions) observers.get(i)).getAvailable()) {
                observers.get(i).update(r);
            }

        }
    }
}


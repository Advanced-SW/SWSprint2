package com.example.demo.Database;




import com.example.demo.User.*;
import com.example.demo.Ride.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Logger;

public class Database {
    private static Database uniqueInstance;
    private  ArrayList<Person>users=new ArrayList();
    private ArrayList<Driver>pendedDrivers=new ArrayList();
    private ArrayList<Ride> rides=new ArrayList();
    private ArrayList<Area> systemAreas=new ArrayList();
    private ArrayList<LocalDate> holidaysDates=new ArrayList();
    private Database(){}

    public static Database getInstance(){
        if(uniqueInstance==null){
            uniqueInstance= new Database();
        }
        return uniqueInstance;
    }
    public  ArrayList<Person> getUsers() {
        return users;
    }

    public  ArrayList<Driver> getPendedDrivers() {
        return pendedDrivers;
    }

    public ArrayList<Ride> getRides() {
        return rides;
    }

    public ArrayList<Area> getSystemAreas() {
        return systemAreas;
    }

    public ArrayList<LocalDate> getHolidaysDates() {
        return holidaysDates;
    }
}


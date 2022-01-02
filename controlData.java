package Database_System;

import Ride_System.*;
import Users_System.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.*;
public class controlData  {
    
    public Database database=Database.getInstance();
    
    
    public void addUser(Person user){
        database.getUsers().add(user);
    }
    
    public void addNewRide(Ride ride){
        database.getRides().add(ride);
    }
    
    public void addPendedDriver(Driver driver){
        database.getPendedDrivers().add(driver);
    }
    
    public void addSystemAreas(Area area){
        database.getSystemAreas().add(area);
    }
     public void addHolidaysDates(LocalDate date){
        database.getHolidaysDates().add(date);
    }
    
}
package Users_System;

import Database_System.*;
import Ride_System.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class Admin extends Person  {

    public controlData data = new controlData();
  

    public void setData(String name, String password, String mobile, String email) {
        this.name = name;
        this.password = password;
        this.mobile = mobile;
        this.email = email;
    }


    public void signUp(String userName, String password, String mobileNumber, String email ) {
        this.setData(userName, password, mobileNumber, email);
        data.database.getUsers().add(this);
    }


    public boolean logIn(String userName,String password) {
        boolean found = false;
        ArrayList<Person> tmp = data.database.getUsers();
        for (int i = 0; i < tmp.size(); i++) {
            if (tmp.get(i) instanceof Admin) {
                if (userName.equals(tmp.get(i).getName()) && password.equals(tmp.get(i).getPassword())) {
                    tmp.get(i).setLoggedIn(true);
                    found = true;
                    break;
                }
            }
        }
        if (!found) {
            System.out.println("Please sign up first!!");
        }
        return true;
    }

    public void verify() {
            ArrayList<Driver> tmp = data.database.getPendedDrivers();
            int j=0;
            if (tmp.isEmpty()) {
                System.out.println("No pending drivers");
            } else {
                for (int i = 0; i < tmp.size(); i++) {
                    tmp.get(i).setVerify(true);
                    j++;
                    data.addUser(tmp.get(i));
                }
                System.out.println(j+" Driver verified");
            }
        }


    public void suspend(String name) {
            ArrayList<Person> temp = new ArrayList();
            temp = data.database.getUsers();
            for (int i = 0; i < temp.size(); i++) {
                if ((temp.get(i).getName()).equals(name)) {
                    if (temp.get(i) instanceof Driver) {
                        ((Driver) temp.get(i)).setSuspend(true);
                    } else if (temp.get(i) instanceof User) {
                        ((User) temp.get(i)).setSuspend(true);
                        
                    }
                }
            }
        }

   

    public void checkRideEvents() {

            ArrayList<Ride> rideList = new ArrayList();
            rideList = data.database.getRides();
            ArrayList<Event> event = new ArrayList();
            for (int i = 0; i < rideList.size(); i++) {
                event = rideList.get(i).getRideEvents();
                for (int j = 0; j < event.size(); j++) {
                    System.out.println("Event " + j + 1 + " : ");
                    event.get(j).displayEvent();
                }
            }
        
    }

    public void addDiscountToArea(String location) {

            ArrayList<Area> tmp = data.database.getSystemAreas();
            for (int i = 0; i < tmp.size(); i++) {
                if ((tmp.get(i).getLocation()).equals(location)) {
                    tmp.get(i).setHaveDiscount(true);
                    break;
                }
            }
        
    }
    public void addHolidays(String date){
        ArrayList<LocalDate> dateL=new ArrayList();
        LocalDate localDate = LocalDate.parse(date);
        dateL.add(localDate);
       data.addHolidaysDates(localDate);
       System.out.println("Holiday date added");
    }


    public void logOut() {
        this.setLoggedIn(false);
    }
}
package com.example.demo.User;

import com.example.demo.Database.*;
import java.util.ArrayList;


public class User extends Person {

    private boolean suspend ;
    private int dayOfBirth;
    private int monthOfBirth;
    private int numOfRides;
    public ControlData data = new ControlData();


    public void setData(String name, String password, String mobile, String email, int dayOfBirth ,int monthOfBirth) {
        this.name = name;
        this.password = password;
        this.mobile = mobile;
        this.email = email;
        this.dayOfBirth=dayOfBirth;
        this.monthOfBirth=monthOfBirth;
        suspend = false;

    }
    public int getDayOfBirth() {
        return dayOfBirth;
    }
    public int getMonthOfBirth() {
        return monthOfBirth;
    }

    public void setDayOfBirth(int dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }
    public void setMonthOfBirth(int monthOfBirth) {
        this.monthOfBirth = monthOfBirth;
    }
    public boolean getSuspend() {
        return suspend;
    }

    public void setSuspend(boolean suspend) {
        this.suspend = suspend;
    }

    public int getNumOfRides() {
        return numOfRides;
    }

    public void setNumOfRides(int numOfRides) {
        this.numOfRides = numOfRides;
    }

    public String signUp(String userName,String password,String mobileNumber,String email,int day,int month) {
        this.setData(userName, password, mobileNumber, email,day,month);
        data.database.getUsers().add(this);
        return "Registered successfully";
    }
    public boolean logIn(String userName,String password ) {
        boolean found = false;

        ArrayList<Person> tmp = data.database.getUsers();
        for (int i = 0; i < tmp.size(); i++) {
            if (tmp.get(i) instanceof User) {
                if (userName.equals(tmp.get(i).getName())  && password .equals(tmp.get(i).getPassword()) && !((User) tmp.get(i)).getSuspend()) {
                    tmp.get(i).setLoggedIn(true);
                    System.out.println("Logged in successfully");
                    found = true;
                    break;
                }
                else if(userName.equals(tmp.get(i).getName())  && password .equals(tmp.get(i).getPassword()) && ((User) tmp.get(i)).getSuspend()){
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

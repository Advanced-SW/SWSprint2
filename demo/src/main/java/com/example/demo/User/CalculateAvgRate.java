package com.example.demo.User;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.example.demo.User.*;


/**
 *
 * @author Zainab
 */
public class CalculateAvgRate {

    public void calculateNewRate(Driver driver, double rate){
        double sum=driver.getAvgRate()+rate;
        double result =sum/driver.getRides().size();
        driver.setAvgRate(result);
    }
}



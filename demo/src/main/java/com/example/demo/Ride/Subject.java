package com.example.demo.Ride;

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
public interface Subject {
    public void registerObserver(Observer o);
    public void unRegisterObserver(Observer o);
    public void Notify(Ride r);
}

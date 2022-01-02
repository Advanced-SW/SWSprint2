package com.example.demo.Ride;

public class Discount_10 implements Discount {
    @Override
    public double discountProcess(double price) {
        return price * 0.1;
    }
}
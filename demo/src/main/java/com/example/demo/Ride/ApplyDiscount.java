package com.example.demo.Ride;


import com.example.demo.Database.*;
import java.time.LocalDate;
import java.util.ArrayList;



public class ApplyDiscount {

    public ControlData data=new ControlData();
    public void discountProcessing(Ride ride) {
        Discount discountTen=new Discount_10();
        Discount discountFive=new Discount_5();
        ride.setDiscountPrice(ride.getPrice());
        double price=ride.getDiscountPrice();
        if (ride.getClient().getNumOfRides() == 1) {
            price=discountTen.discountProcess(price);
            ride.setDiscountPrice(price);
        }
        if (ride.getSource().getHaveDiscount()) {
            price=discountTen.discountProcess(price);
            ride.setDiscountPrice(price);
        }
        if (ride.getPassengersNumber() == 2) {
            price=discountFive.discountProcess(price);
            ride.setDiscountPrice(price);
        }
        LocalDate currDate = LocalDate.now();
        int month=currDate.getMonthValue();
        int day=currDate.getDayOfMonth();
        if (day==ride.getClient().getDayOfBirth() && month==ride.getClient().getMonthOfBirth()) {
            price=discountTen.discountProcess(price);
            ride.setDiscountPrice(price);
        }
        ArrayList<LocalDate> tmp=data.database.getHolidaysDates();
        for(int i=0;i<tmp.size();i++){
            if((tmp).get(i)==currDate){
                price=discountFive.discountProcess(price);
                ride.setDiscountPrice(price);
            }
        }
    }

}

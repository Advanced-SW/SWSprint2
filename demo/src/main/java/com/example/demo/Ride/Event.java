package com.example.demo.Ride;



import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author Zainab
 */
public class Event {
    /* private String eventName;
     private Ride ride;
     private LocalDateTime time;*/
    private Map types;
    public void setMap(Map types){
        this.types=types;
    }
    public Map getMap(){
        return types;
    }
    public void displayEvent(){
        Iterator <String> keySetIterator = types.keySet().iterator();
        while(keySetIterator.hasNext()) {
            String key = keySetIterator.next();
            System.out.println(key +" : " +     types.get(key));
        }
    }
}

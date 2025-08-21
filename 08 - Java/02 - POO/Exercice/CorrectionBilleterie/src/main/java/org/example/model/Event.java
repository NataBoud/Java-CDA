package org.example.model;

import org.example.Exception.IncorectNumberOfPlaceException;
import org.example.Exception.ToMuchBilletException;

import javax.swing.text.Position;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Event {
    private String eventName;
    private Place place;
    private LocalDateTime dateTime;
    private int numberOfPlace;
    private final List<Billet> billets;

    public Event(String eventName, Place place, LocalDateTime dateTime, int numberOfPlace) {
        this.eventName = eventName;
        this.place = place;
        this.dateTime = dateTime;
        if(numberOfPlace<= place.getCapacity()){
            this.numberOfPlace = numberOfPlace;
        }else{
            throw new IncorectNumberOfPlaceException("to mutch place fort this place");
        }

        billets = new ArrayList<Billet>();
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public int getNumberOfPlace() {
        return numberOfPlace;
    }

    public void setNumberOfPlace(int numberOfPlace) {
        if(numberOfPlace<= place.getCapacity()){
            this.numberOfPlace = numberOfPlace;
        }else{
            throw new IncorectNumberOfPlaceException("to mutch place fort this place");
        }
    }

    public void addBillet(Billet billet) {
        if(billets.size()<numberOfPlace){
            billets.add(billet);
        }else
        {
            throw new ToMuchBilletException("No more place available fort this event");
        }

    }

    public List<Billet> getBillets() {
        return billets;
    }

    @Override
    public String toString() {
        return "Event{" +
                "eventName='" + eventName + '\'' +
                ", place=" + place +
                ", dateTime=" + dateTime +
                ", numberOfPlace=" + numberOfPlace +
                '}';
    }
}

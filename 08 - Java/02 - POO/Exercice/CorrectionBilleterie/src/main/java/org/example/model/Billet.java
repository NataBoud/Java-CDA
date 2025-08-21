package org.example.model;

import org.example.Util.PlaceTYpe;

public class Billet {
    private int placeNumber;
    private Customer customer;
    private Event event;
    private PlaceTYpe placeType;

    public Billet(int placeNumber, Customer customer, Event event, PlaceTYpe placeType) {
        this.placeNumber = placeNumber;
        this.customer = customer;
        this.event = event;
        this.placeType = placeType;
    }

    public int getPlaceNumber() {
        return placeNumber;
    }

    public void setPlaceNumber(int placeNumber) {
        this.placeNumber = placeNumber;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public PlaceTYpe getPlaceType() {
        return placeType;
    }

    public void setPlaceType(PlaceTYpe placeType) {
        this.placeType = placeType;
    }

    @Override
    public String toString() {
        return "Billet{" +
                "placeNumber=" + placeNumber +
                ", customer=" + customer +
                ", event=" + event +
                ", placeType=" + placeType +
                '}';
    }
}

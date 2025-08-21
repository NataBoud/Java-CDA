package org.example.model;

public class Place extends Address{
    private int capacity;

    public Place(String street, String city, int capacity) {
        super(street, city);
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Place{" +
                "capacity=" + capacity +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}

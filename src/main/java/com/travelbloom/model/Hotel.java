package com.travelbloom.model;

public class Hotel {

    private int id;
    private int tripId;
    private String name;
    private String location;
    private String checkIn;
    private String checkOut;
    private double cost;

    // Empty constructor
    public Hotel() {
    }

    // Constructor without ID
    public Hotel(int tripId, String name,
                 String location, String checkIn,
                 String checkOut, double cost) {

        this.tripId = tripId;
        this.name = name;
        this.location = location;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.cost = cost;
    }

    // Constructor with ID
    public Hotel(int id, int tripId,
                 String name, String location,
                 String checkIn, String checkOut,
                 double cost) {

        this.id = id;
        this.tripId = tripId;
        this.name = name;
        this.location = location;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.cost = cost;
    }

    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTripId() {
        return tripId;
    }

    public void setTripId(int tripId) {
        this.tripId = tripId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(String checkIn) {
        this.checkIn = checkIn;
    }

    public String getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(String checkOut) {
        this.checkOut = checkOut;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}
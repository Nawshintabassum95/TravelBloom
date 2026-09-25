package com.travelbloom.model;

public class Transport {

    private int id;
    private int tripId;
    private String type;
    private String fromPlace;
    private String toPlace;
    private String departure;
    private String arrival;
    private double cost;

    // Empty constructor
    public Transport() {
    }

    // Constructor without ID
    public Transport(int tripId, String type,
                     String fromPlace, String toPlace,
                     String departure, String arrival,
                     double cost) {

        this.tripId = tripId;
        this.type = type;
        this.fromPlace = fromPlace;
        this.toPlace = toPlace;
        this.departure = departure;
        this.arrival = arrival;
        this.cost = cost;
    }

    // Constructor with ID
    public Transport(int id, int tripId,
                     String type, String fromPlace,
                     String toPlace, String departure,
                     String arrival, double cost) {

        this.id = id;
        this.tripId = tripId;
        this.type = type;
        this.fromPlace = fromPlace;
        this.toPlace = toPlace;
        this.departure = departure;
        this.arrival = arrival;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFromPlace() {
        return fromPlace;
    }

    public void setFromPlace(String fromPlace) {
        this.fromPlace = fromPlace;
    }

    public String getToPlace() {
        return toPlace;
    }

    public void setToPlace(String toPlace) {
        this.toPlace = toPlace;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getArrival() {
        return arrival;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}
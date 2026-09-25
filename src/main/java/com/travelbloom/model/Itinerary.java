package com.travelbloom.model;

public class Itinerary {

    private int id;
    private int tripId;
    private int dayNumber;
    private String activity;
    private String location;
    private String time;
    private String notes;

    // Empty constructor
    public Itinerary() {
    }

    // Constructor without ID
    public Itinerary(int tripId, int dayNumber,
                     String activity, String location,
                     String time, String notes) {

        this.tripId = tripId;
        this.dayNumber = dayNumber;
        this.activity = activity;
        this.location = location;
        this.time = time;
        this.notes = notes;
    }

    // Constructor with ID
    public Itinerary(int id, int tripId, int dayNumber,
                     String activity, String location,
                     String time, String notes) {

        this.id = id;
        this.tripId = tripId;
        this.dayNumber = dayNumber;
        this.activity = activity;
        this.location = location;
        this.time = time;
        this.notes = notes;
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

    public int getDayNumber() {
        return dayNumber;
    }

    public void setDayNumber(int dayNumber) {
        this.dayNumber = dayNumber;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
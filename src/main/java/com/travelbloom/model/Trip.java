package com.travelbloom.model;

public class Trip {

    private int id;
    private String name;
    private String destination;
    private String startDate;
    private String endDate;
    private double budget;

    // Empty constructor
    public Trip() {
    }

    // Constructor without ID
    public Trip(String name, String destination,
                String startDate, String endDate,
                double budget) {

        this.name = name;
        this.destination = destination;
        this.startDate = startDate;
        this.endDate = endDate;
        this.budget = budget;
    }

    // Constructor with ID
    public Trip(int id, String name, String destination,
                String startDate, String endDate,
                double budget) {

        this.id = id;
        this.name = name;
        this.destination = destination;
        this.startDate = startDate;
        this.endDate = endDate;
        this.budget = budget;
    }

    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    @Override
    public String toString() {
        return name + " - " + destination;
    }
}
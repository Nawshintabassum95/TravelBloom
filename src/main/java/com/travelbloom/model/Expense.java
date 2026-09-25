package com.travelbloom.model;

public class Expense {

    private int id;
    private int tripId;
    private String category;
    private String description;
    private double amount;
    private String paidBy;

    // Empty constructor
    public Expense() {
    }

    // Constructor without ID
    public Expense(int tripId, String category,
                   String description, double amount,
                   String paidBy) {

        this.tripId = tripId;
        this.category = category;
        this.description = description;
        this.amount = amount;
        this.paidBy = paidBy;
    }

    // Constructor with ID
    public Expense(int id, int tripId,
                   String category, String description,
                   double amount, String paidBy) {

        this.id = id;
        this.tripId = tripId;
        this.category = category;
        this.description = description;
        this.amount = amount;
        this.paidBy = paidBy;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getPaidBy() {
        return paidBy;
    }

    public void setPaidBy(String paidBy) {
        this.paidBy = paidBy;
    }
}
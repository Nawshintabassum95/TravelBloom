package com.travelbloom.model;

public class PackingItem {

    private int id;
    private int tripId;
    private String item;
    private boolean packed;

    // Empty constructor
    public PackingItem() {
    }

    // Constructor without ID
    public PackingItem(int tripId, String item, boolean packed) {

        this.tripId = tripId;
        this.item = item;
        this.packed = packed;
    }

    // Constructor with ID
    public PackingItem(int id, int tripId,
                       String item, boolean packed) {

        this.id = id;
        this.tripId = tripId;
        this.item = item;
        this.packed = packed;
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

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public boolean isPacked() {
        return packed;
    }

    public void setPacked(boolean packed) {
        this.packed = packed;
    }
}

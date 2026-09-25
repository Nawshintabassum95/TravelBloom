package com.travelbloom.service;

import com.travelbloom.dao.TripDAO;
import com.travelbloom.model.Trip;

import java.util.List;

public class TripService {

    private final TripDAO tripDAO;

    public TripService() {
        tripDAO = new TripDAO();
    }

    // Add a new trip after validating the data
    public boolean addTrip(Trip trip) {

        if (trip == null) {
            return false;
        }

        if (trip.getName() == null || trip.getName().trim().isEmpty()) {
            return false;
        }

        if (trip.getDestination() == null ||
                trip.getDestination().trim().isEmpty()) {
            return false;
        }

        if (trip.getBudget() < 0) {
            return false;
        }

        return tripDAO.addTrip(trip);
    }

    // Get all trips
    public List<Trip> getAllTrips() {
        return tripDAO.getAllTrips();
    }

    // Get one trip
    public Trip getTripById(int id) {

        if (id <= 0) {
            return null;
        }

        return tripDAO.getTripById(id);
    }

    // Update trip
    public boolean updateTrip(Trip trip) {

        if (trip == null || trip.getId() <= 0) {
            return false;
        }

        if (trip.getName() == null ||
                trip.getName().trim().isEmpty()) {
            return false;
        }

        if (trip.getDestination() == null ||
                trip.getDestination().trim().isEmpty()) {
            return false;
        }

        if (trip.getBudget() < 0) {
            return false;
        }

        return tripDAO.updateTrip(trip);
    }

    // Delete trip
    public boolean deleteTrip(int id) {

        if (id <= 0) {
            return false;
        }

        return tripDAO.deleteTrip(id);
    }
}
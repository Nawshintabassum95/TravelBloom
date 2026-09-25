package com.travelbloom.dao;

import com.travelbloom.model.Itinerary;
import com.travelbloom.util.Database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ItineraryDAO {

    // Add itinerary item
    public boolean addItinerary(Itinerary itinerary) {

        String sql = """
                INSERT INTO itinerary
                (trip_id, day_number, activity, location, time, notes)
                VALUES (?, ?, ?, ?, ?, ?)
                """;

        try (Connection connection = Database.connect();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, itinerary.getTripId());
            statement.setInt(2, itinerary.getDayNumber());
            statement.setString(3, itinerary.getActivity());
            statement.setString(4, itinerary.getLocation());
            statement.setString(5, itinerary.getTime());
            statement.setString(6, itinerary.getNotes());

            statement.executeUpdate();

            return true;

        } catch (SQLException e) {
            System.out.println("Error adding itinerary: " + e.getMessage());
            return false;
        }
    }

    // Get itinerary items of a trip
    public List<Itinerary> getItineraryByTripId(int tripId) {

        List<Itinerary> list = new ArrayList<>();

        String sql = """
                SELECT * FROM itinerary
                WHERE trip_id = ?
                ORDER BY day_number
                """;

        try (Connection connection = Database.connect();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, tripId);

            ResultSet result = statement.executeQuery();

            while (result.next()) {

                Itinerary itinerary = new Itinerary(
                        result.getInt("id"),
                        result.getInt("trip_id"),
                        result.getInt("day_number"),
                        result.getString("activity"),
                        result.getString("location"),
                        result.getString("time"),
                        result.getString("notes")
                );

                list.add(itinerary);
            }

        } catch (SQLException e) {
            System.out.println("Error loading itinerary: " + e.getMessage());
        }

        return list;
    }

    // Update itinerary
    public boolean updateItinerary(Itinerary itinerary) {

        String sql = """
                UPDATE itinerary
                SET day_number = ?,
                    activity = ?,
                    location = ?,
                    time = ?,
                    notes = ?
                WHERE id = ?
                """;

        try (Connection connection = Database.connect();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, itinerary.getDayNumber());
            statement.setString(2, itinerary.getActivity());
            statement.setString(3, itinerary.getLocation());
            statement.setString(4, itinerary.getTime());
            statement.setString(5, itinerary.getNotes());
            statement.setInt(6, itinerary.getId());

            statement.executeUpdate();

            return true;

        } catch (SQLException e) {
            System.out.println("Error updating itinerary: " + e.getMessage());
            return false;
        }
    }

    // Delete itinerary item
    public boolean deleteItinerary(int id) {

        String sql = "DELETE FROM itinerary WHERE id = ?";

        try (Connection connection = Database.connect();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, id);
            statement.executeUpdate();

            return true;

        } catch (SQLException e) {
            System.out.println("Error deleting itinerary: " + e.getMessage());
            return false;
        }
    }
}
package com.travelbloom.dao;

import com.travelbloom.model.Hotel;
import com.travelbloom.util.Database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HotelDAO {

    // Add hotel
    public boolean addHotel(Hotel hotel) {

        String sql = """
                INSERT INTO hotels
                (trip_id, name, location, check_in, check_out, cost)
                VALUES (?, ?, ?, ?, ?, ?)
                """;

        try (Connection connection = Database.connect();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, hotel.getTripId());
            statement.setString(2, hotel.getName());
            statement.setString(3, hotel.getLocation());
            statement.setString(4, hotel.getCheckIn());
            statement.setString(5, hotel.getCheckOut());
            statement.setDouble(6, hotel.getCost());

            statement.executeUpdate();

            return true;

        } catch (SQLException e) {
            System.out.println("Error adding hotel: " + e.getMessage());
            return false;
        }
    }

    // Get hotels of a trip
    public List<Hotel> getHotelsByTripId(int tripId) {

        List<Hotel> hotels = new ArrayList<>();

        String sql = """
                SELECT * FROM hotels
                WHERE trip_id = ?
                ORDER BY id DESC
                """;

        try (Connection connection = Database.connect();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, tripId);

            ResultSet result = statement.executeQuery();

            while (result.next()) {

                Hotel hotel = new Hotel(
                        result.getInt("id"),
                        result.getInt("trip_id"),
                        result.getString("name"),
                        result.getString("location"),
                        result.getString("check_in"),
                        result.getString("check_out"),
                        result.getDouble("cost")
                );

                hotels.add(hotel);
            }

        } catch (SQLException e) {
            System.out.println("Error loading hotels: " + e.getMessage());
        }

        return hotels;
    }

    // Update hotel
    public boolean updateHotel(Hotel hotel) {

        String sql = """
                UPDATE hotels
                SET name = ?,
                    location = ?,
                    check_in = ?,
                    check_out = ?,
                    cost = ?
                WHERE id = ?
                """;

        try (Connection connection = Database.connect();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, hotel.getName());
            statement.setString(2, hotel.getLocation());
            statement.setString(3, hotel.getCheckIn());
            statement.setString(4, hotel.getCheckOut());
            statement.setDouble(5, hotel.getCost());
            statement.setInt(6, hotel.getId());

            statement.executeUpdate();

            return true;

        } catch (SQLException e) {
            System.out.println("Error updating hotel: " + e.getMessage());
            return false;
        }
    }

    // Delete hotel
    public boolean deleteHotel(int id) {

        String sql = "DELETE FROM hotels WHERE id = ?";

        try (Connection connection = Database.connect();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, id);
            statement.executeUpdate();

            return true;

        } catch (SQLException e) {
            System.out.println("Error deleting hotel: " + e.getMessage());
            return false;
        }
    }
}
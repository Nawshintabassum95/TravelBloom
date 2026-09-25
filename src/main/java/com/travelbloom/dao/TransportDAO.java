package com.travelbloom.dao;

import com.travelbloom.model.Transport;
import com.travelbloom.util.Database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TransportDAO {

    // Add transport
    public boolean addTransport(Transport transport) {

        String sql = """
                INSERT INTO transport
                (trip_id, type, from_place, to_place,
                 departure, arrival, cost)
                VALUES (?, ?, ?, ?, ?, ?, ?)
                """;

        try (Connection connection = Database.connect();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, transport.getTripId());
            statement.setString(2, transport.getType());
            statement.setString(3, transport.getFromPlace());
            statement.setString(4, transport.getToPlace());
            statement.setString(5, transport.getDeparture());
            statement.setString(6, transport.getArrival());
            statement.setDouble(7, transport.getCost());

            statement.executeUpdate();

            return true;

        } catch (SQLException e) {
            System.out.println("Error adding transport: " + e.getMessage());
            return false;
        }
    }

    // Get transport of a trip
    public List<Transport> getTransportByTripId(int tripId) {

        List<Transport> list = new ArrayList<>();

        String sql = """
                SELECT * FROM transport
                WHERE trip_id = ?
                ORDER BY id DESC
                """;

        try (Connection connection = Database.connect();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, tripId);

            ResultSet result = statement.executeQuery();

            while (result.next()) {

                Transport transport = new Transport(
                        result.getInt("id"),
                        result.getInt("trip_id"),
                        result.getString("type"),
                        result.getString("from_place"),
                        result.getString("to_place"),
                        result.getString("departure"),
                        result.getString("arrival"),
                        result.getDouble("cost")
                );

                list.add(transport);
            }

        } catch (SQLException e) {
            System.out.println("Error loading transport: " + e.getMessage());
        }

        return list;
    }

    // Update transport
    public boolean updateTransport(Transport transport) {

        String sql = """
                UPDATE transport
                SET type = ?,
                    from_place = ?,
                    to_place = ?,
                    departure = ?,
                    arrival = ?,
                    cost = ?
                WHERE id = ?
                """;

        try (Connection connection = Database.connect();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, transport.getType());
            statement.setString(2, transport.getFromPlace());
            statement.setString(3, transport.getToPlace());
            statement.setString(4, transport.getDeparture());
            statement.setString(5, transport.getArrival());
            statement.setDouble(6, transport.getCost());
            statement.setInt(7, transport.getId());

            statement.executeUpdate();

            return true;

        } catch (SQLException e) {
            System.out.println("Error updating transport: " + e.getMessage());
            return false;
        }
    }

    // Delete transport
    public boolean deleteTransport(int id) {

        String sql = "DELETE FROM transport WHERE id = ?";

        try (Connection connection = Database.connect();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, id);
            statement.executeUpdate();

            return true;

        } catch (SQLException e) {
            System.out.println("Error deleting transport: " + e.getMessage());
            return false;
        }
    }
}
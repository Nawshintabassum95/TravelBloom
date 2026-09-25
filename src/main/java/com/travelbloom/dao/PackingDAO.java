package com.travelbloom.dao;

import com.travelbloom.model.PackingItem;
import com.travelbloom.util.Database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PackingDAO {

    // Add packing item
    public boolean addPackingItem(PackingItem item) {

        String sql = """
                INSERT INTO packing_items
                (trip_id, item, packed)
                VALUES (?, ?, ?)
                """;

        try (Connection connection = Database.connect();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, item.getTripId());
            statement.setString(2, item.getItem());
            statement.setInt(3, item.isPacked() ? 1 : 0);

            statement.executeUpdate();

            return true;

        } catch (SQLException e) {
            System.out.println("Error adding packing item: " + e.getMessage());
            return false;
        }
    }

    // Get packing items of a trip
    public List<PackingItem> getPackingItemsByTripId(int tripId) {

        List<PackingItem> items = new ArrayList<>();

        String sql = """
                SELECT * FROM packing_items
                WHERE trip_id = ?
                ORDER BY id
                """;

        try (Connection connection = Database.connect();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, tripId);

            ResultSet result = statement.executeQuery();

            while (result.next()) {

                PackingItem item = new PackingItem(
                        result.getInt("id"),
                        result.getInt("trip_id"),
                        result.getString("item"),
                        result.getInt("packed") == 1
                );

                items.add(item);
            }

        } catch (SQLException e) {
            System.out.println("Error loading packing items: " + e.getMessage());
        }

        return items;
    }

    // Update packing item
    public boolean updatePackingItem(PackingItem item) {

        String sql = """
                UPDATE packing_items
                SET item = ?,
                    packed = ?
                WHERE id = ?
                """;

        try (Connection connection = Database.connect();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, item.getItem());
            statement.setInt(2, item.isPacked() ? 1 : 0);
            statement.setInt(3, item.getId());

            statement.executeUpdate();

            return true;

        } catch (SQLException e) {
            System.out.println("Error updating packing item: " + e.getMessage());
            return false;
        }
    }

    // Delete packing item
    public boolean deletePackingItem(int id) {

        String sql = "DELETE FROM packing_items WHERE id = ?";

        try (Connection connection = Database.connect();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, id);
            statement.executeUpdate();

            return true;

        } catch (SQLException e) {
            System.out.println("Error deleting packing item: " + e.getMessage());
            return false;
        }
    }
}
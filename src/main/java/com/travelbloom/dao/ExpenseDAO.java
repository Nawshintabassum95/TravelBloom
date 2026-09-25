package com.travelbloom.dao;

import com.travelbloom.model.Expense;
import com.travelbloom.util.Database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ExpenseDAO {

    // Add expense
    public boolean addExpense(Expense expense) {

        String sql = """
                INSERT INTO expenses
                (trip_id, category, description, amount, paid_by)
                VALUES (?, ?, ?, ?, ?)
                """;

        try (Connection connection = Database.connect();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, expense.getTripId());
            statement.setString(2, expense.getCategory());
            statement.setString(3, expense.getDescription());
            statement.setDouble(4, expense.getAmount());
            statement.setString(5, expense.getPaidBy());

            statement.executeUpdate();

            return true;

        } catch (SQLException e) {
            System.out.println("Error adding expense: " + e.getMessage());
            return false;
        }
    }

    // Get expenses of a trip
    public List<Expense> getExpensesByTripId(int tripId) {

        List<Expense> expenses = new ArrayList<>();

        String sql = """
                SELECT * FROM expenses
                WHERE trip_id = ?
                ORDER BY id DESC
                """;

        try (Connection connection = Database.connect();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, tripId);

            ResultSet result = statement.executeQuery();

            while (result.next()) {

                Expense expense = new Expense(
                        result.getInt("id"),
                        result.getInt("trip_id"),
                        result.getString("category"),
                        result.getString("description"),
                        result.getDouble("amount"),
                        result.getString("paid_by")
                );

                expenses.add(expense);
            }

        } catch (SQLException e) {
            System.out.println("Error loading expenses: " + e.getMessage());
        }

        return expenses;
    }

    // Update expense
    public boolean updateExpense(Expense expense) {

        String sql = """
                UPDATE expenses
                SET category = ?,
                    description = ?,
                    amount = ?,
                    paid_by = ?
                WHERE id = ?
                """;

        try (Connection connection = Database.connect();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, expense.getCategory());
            statement.setString(2, expense.getDescription());
            statement.setDouble(3, expense.getAmount());
            statement.setString(4, expense.getPaidBy());
            statement.setInt(5, expense.getId());

            statement.executeUpdate();

            return true;

        } catch (SQLException e) {
            System.out.println("Error updating expense: " + e.getMessage());
            return false;
        }
    }

    // Delete expense
    public boolean deleteExpense(int id) {

        String sql = "DELETE FROM expenses WHERE id = ?";

        try (Connection connection = Database.connect();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, id);
            statement.executeUpdate();

            return true;

        } catch (SQLException e) {
            System.out.println("Error deleting expense: " + e.getMessage());
            return false;
        }
    }

    // Calculate total expense of a trip
    public double getTotalExpense(int tripId) {

        String sql = """
                SELECT COALESCE(SUM(amount), 0)
                FROM expenses
                WHERE trip_id = ?
                """;

        try (Connection connection = Database.connect();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, tripId);

            ResultSet result = statement.executeQuery();

            if (result.next()) {
                return result.getDouble(1);
            }

        } catch (SQLException e) {
            System.out.println("Error calculating expense: " + e.getMessage());
        }

        return 0;
    }
}
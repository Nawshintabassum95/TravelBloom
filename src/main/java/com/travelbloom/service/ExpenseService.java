package com.travelbloom.service;

import com.travelbloom.dao.ExpenseDAO;
import com.travelbloom.model.Expense;

import java.util.List;

public class ExpenseService {

    private final ExpenseDAO expenseDAO;

    public ExpenseService() {
        expenseDAO = new ExpenseDAO();
    }

    // Add expense
    public boolean addExpense(Expense expense) {

        if (expense == null) {
            return false;
        }

        if (expense.getTripId() <= 0) {
            return false;
        }

        if (expense.getCategory() == null ||
                expense.getCategory().trim().isEmpty()) {
            return false;
        }

        if (expense.getAmount() <= 0) {
            return false;
        }

        return expenseDAO.addExpense(expense);
    }

    // Get all expenses for a trip
    public List<Expense> getExpensesByTripId(int tripId) {

        if (tripId <= 0) {
            return List.of();
        }

        return expenseDAO.getExpensesByTripId(tripId);
    }

    // Update expense
    public boolean updateExpense(Expense expense) {

        if (expense == null || expense.getId() <= 0) {
            return false;
        }

        if (expense.getAmount() <= 0) {
            return false;
        }

        return expenseDAO.updateExpense(expense);
    }

    // Delete expense
    public boolean deleteExpense(int id) {

        if (id <= 0) {
            return false;
        }

        return expenseDAO.deleteExpense(id);
    }

    // Calculate total expense
    public double getTotalExpense(int tripId) {

        if (tripId <= 0) {
            return 0;
        }

        return expenseDAO.getTotalExpense(tripId);
    }

    // Calculate remaining budget
    public double getRemainingBudget(double budget, int tripId) {

        double totalExpense = getTotalExpense(tripId);

        return budget - totalExpense;
    }

    // Check whether budget has been exceeded
    public boolean isBudgetExceeded(double budget, int tripId) {

        double totalExpense = getTotalExpense(tripId);

        return totalExpense > budget;
    }
}
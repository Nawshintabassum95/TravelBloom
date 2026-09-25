package com.travelbloom.service;

import com.travelbloom.model.Trip;

import java.util.ArrayList;
import java.util.List;

public class SuggestionService {

    // Generate travel suggestions
    public List<String> generateSuggestions(Trip trip) {

        List<String> suggestions = new ArrayList<>();

        if (trip == null) {
            return suggestions;
        }

        String destination = trip.getDestination();

        if (destination != null &&
                !destination.trim().isEmpty()) {

            suggestions.add(
                    "Explore popular attractions in " +
                            destination + "."
            );

            suggestions.add(
                    "Keep a copy of your important travel documents."
            );

            suggestions.add(
                    "Check the local weather before starting your journey."
            );
        }

        // Budget-based suggestion
        if (trip.getBudget() > 0 &&
                trip.getBudget() < 5000) {

            suggestions.add(
                    "Your budget is limited. Consider low-cost transport and accommodation."
            );
        }

        if (trip.getBudget() >= 5000 &&
                trip.getBudget() < 15000) {

            suggestions.add(
                    "Compare hotel and transport prices before booking."
            );
        }

        if (trip.getBudget() >= 15000) {

            suggestions.add(
                    "You have a moderate travel budget. Consider adding one special activity."
            );
        }

        // General packing suggestion
        suggestions.add(
                "Carry basic medicine, charger, power bank and necessary documents."
        );

        return suggestions;
    }
}
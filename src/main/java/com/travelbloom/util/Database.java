package com.travelbloom.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {

    // SQLite database file
    private static final String URL = "jdbc:sqlite:travelbloom.db";

    // Private constructor
    // This class only contains static database methods
    private Database() {
    }

    // Create a database connection
    public static Connection connect() throws SQLException {

        Connection connection = DriverManager.getConnection(URL);

        // Enable foreign key support in SQLite
        try (Statement statement = connection.createStatement()) {
            statement.execute("PRAGMA foreign_keys = ON");
        }

        return connection;
    }

    // Create all database tables
    public static void initializeDatabase() {

        String tripTable = """
                CREATE TABLE IF NOT EXISTS trips (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    name TEXT NOT NULL,
                    destination TEXT NOT NULL,
                    start_date TEXT,
                    end_date TEXT,
                    budget REAL DEFAULT 0
                )
                """;

        String itineraryTable = """
                CREATE TABLE IF NOT EXISTS itinerary (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    trip_id INTEGER NOT NULL,
                    day_number INTEGER NOT NULL,
                    activity TEXT NOT NULL,
                    location TEXT,
                    time TEXT,
                    notes TEXT,
                    FOREIGN KEY (trip_id)
                        REFERENCES trips(id)
                        ON DELETE CASCADE
                )
                """;

        String expenseTable = """
                CREATE TABLE IF NOT EXISTS expenses (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    trip_id INTEGER NOT NULL,
                    category TEXT NOT NULL,
                    description TEXT,
                    amount REAL NOT NULL,
                    paid_by TEXT,
                    FOREIGN KEY (trip_id)
                        REFERENCES trips(id)
                        ON DELETE CASCADE
                )
                """;

        String transportTable = """
                CREATE TABLE IF NOT EXISTS transport (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    trip_id INTEGER NOT NULL,
                    type TEXT,
                    from_place TEXT,
                    to_place TEXT,
                    departure TEXT,
                    arrival TEXT,
                    cost REAL DEFAULT 0,
                    FOREIGN KEY (trip_id)
                        REFERENCES trips(id)
                        ON DELETE CASCADE
                )
                """;

        String hotelTable = """
                CREATE TABLE IF NOT EXISTS hotels (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    trip_id INTEGER NOT NULL,
                    name TEXT NOT NULL,
                    location TEXT,
                    check_in TEXT,
                    check_out TEXT,
                    cost REAL DEFAULT 0,
                    FOREIGN KEY (trip_id)
                        REFERENCES trips(id)
                        ON DELETE CASCADE
                )
                """;

        String packingTable = """
                CREATE TABLE IF NOT EXISTS packing_items (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    trip_id INTEGER NOT NULL,
                    item TEXT NOT NULL,
                    packed INTEGER DEFAULT 0,
                    FOREIGN KEY (trip_id)
                        REFERENCES trips(id)
                        ON DELETE CASCADE
                )
                """;

        try (Connection connection = connect();
             Statement statement = connection.createStatement()) {

            statement.execute(tripTable);
            statement.execute(itineraryTable);
            statement.execute(expenseTable);
            statement.execute(transportTable);
            statement.execute(hotelTable);
            statement.execute(packingTable);

            System.out.println(
                    "TravelBloom database initialized successfully."
            );

        } catch (SQLException e) {

            System.out.println(
                    "Database initialization error: " +
                            e.getMessage()
            );
        }
    }
}
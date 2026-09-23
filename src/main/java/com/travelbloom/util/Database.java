package com.travelbloom.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {

    private static final String URL =
            "jdbc:sqlite:data/travelbloom.db";

    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(URL);
    }

    public static void initializeDatabase() {

        String tripTable = """
                CREATE TABLE IF NOT EXISTS trips (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    name TEXT NOT NULL,
                    destination TEXT NOT NULL,
                    start_date TEXT,
                    end_date TEXT,
                    budget REAL
                )
                """;

        String itineraryTable = """
                CREATE TABLE IF NOT EXISTS itineraries (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    trip_id INTEGER NOT NULL,
                    day_number INTEGER,
                    activity TEXT,
                    location TEXT,
                    start_time TEXT,
                    end_time TEXT,
                    FOREIGN KEY (trip_id) REFERENCES trips(id)
                )
                """;

        String expenseTable = """
                CREATE TABLE IF NOT EXISTS expenses (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    trip_id INTEGER NOT NULL,
                    category TEXT,
                    description TEXT,
                    amount REAL,
                    paid_by TEXT,
                    FOREIGN KEY (trip_id) REFERENCES trips(id)
                )
                """;

        String transportTable = """
                CREATE TABLE IF NOT EXISTS transport (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    trip_id INTEGER NOT NULL,
                    type TEXT,
                    from_location TEXT,
                    to_location TEXT,
                    departure_time TEXT,
                    cost REAL,
                    FOREIGN KEY (trip_id) REFERENCES trips(id)
                )
                """;

        String hotelTable = """
                CREATE TABLE IF NOT EXISTS hotels (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    trip_id INTEGER NOT NULL,
                    hotel_name TEXT,
                    location TEXT,
                    check_in TEXT,
                    check_out TEXT,
                    cost REAL,
                    FOREIGN KEY (trip_id) REFERENCES trips(id)
                )
                """;

        String packingTable = """
                CREATE TABLE IF NOT EXISTS packing_items (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    trip_id INTEGER NOT NULL,
                    item_name TEXT,
                    packed INTEGER DEFAULT 0,
                    FOREIGN KEY (trip_id) REFERENCES trips(id)
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

            System.out.println("Database initialized successfully.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

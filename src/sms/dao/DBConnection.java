package sms.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
    // The database file will be created automatically in your project folder
    private static final String URL = "jdbc:sqlite:sms.db";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL);
    }

    // Call this once at startup to create the table if it doesn't exist
    public static void initDatabase() {
        String sql = """
            CREATE TABLE IF NOT EXISTS students (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                name TEXT NOT NULL,
                email TEXT NOT NULL,
                course TEXT NOT NULL,
                marks INTEGER NOT NULL
            );
        """;

        try (Connection con = getConnection();
             Statement st = con.createStatement()) {
            st.execute(sql);
        } catch (SQLException e) {
            throw new RuntimeException("Database init failed: " + e.getMessage(), e);
        }
    }
}
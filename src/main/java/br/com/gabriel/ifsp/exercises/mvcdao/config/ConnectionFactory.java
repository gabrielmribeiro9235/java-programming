package br.com.gabriel.ifsp.exercises.mvcdao.config;

import org.sqlite.SQLiteConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConnectionFactory {
    private static final String URL = "jdbc:sqlite:src/main/resources/soccer.db";
    private static Connection connection;

    private ConnectionFactory() {}

    public static Connection getConnection() throws SQLException {
        if (connection == null) {
            SQLiteConfig config = new SQLiteConfig();
            config.enforceForeignKeys(true);
            connection = DriverManager.getConnection(URL, config.toProperties());
        }

        return connection;
    }

    public static PreparedStatement getPrepareStatement(String sql) throws SQLException {
        return getConnection().prepareStatement(sql);
    }
}

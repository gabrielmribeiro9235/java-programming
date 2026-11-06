package br.com.gabriel.ifsp.exercises.jdbc.infrastructure.persistence;

import org.sqlite.SQLiteConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SqliteConnectionFactory {
    private static final String URL = "jdbc:sqlite:src/main/resources/company.db";

    private SqliteConnectionFactory() {}

    public static Connection open() throws SQLException {
        SQLiteConfig config = new SQLiteConfig();
        config.enforceForeignKeys(true);
        return DriverManager.getConnection(URL, config.toProperties());
    }
}

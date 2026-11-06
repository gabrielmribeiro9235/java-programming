package br.com.gabriel.ifsp.exercises.jdbc.infrastructure.persistence;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseInitializer {
    private DatabaseInitializer() {}

    public static void init() {
        try (Connection connection = SqliteConnectionFactory.open()) {
            System.out.println("DROPPING THE EXISTING paycheck AND employee tables...");
            dropTablesIfExist(connection);
            System.out.println("RECREATING THE employee TABLE...");
            createEmployeeTable(connection);
            System.out.println("RECREATING THE paycheck TABLE...");
            createPaycheckTable(connection);
        } catch (SQLException e) {
            throw new RuntimeException("Failed to initalize database", e);
        }
    }

    private static void createEmployeeTable(Connection connection) throws SQLException {
        String sql = """
                CREATE TABLE employee (
                    id                  TEXT NOT NULL,
                    name                TEXT NOT NULL,
                    job_title           TEXT NOT NULL,
                    salary              NUMERIC(10, 2) NOT NULL CHECK ( salary > 0 ),
                    date_of_employment  DATE NOT NULL,
                    PRIMARY KEY(id)
                );
                """;

        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(sql);
            System.out.println("> employee TABLE CREATED SUCCESSFULLY");
        }
    }

    private static void createPaycheckTable(Connection connection) throws SQLException {
        String sql = """
                CREATE TABLE paycheck (
                    payday          DATE NOT NULL,
                    salary          NUMERIC(10,2) NOT NULL CHECK ( salary > 0 ),
                    employee_id     TEXT NOT NULL,
                    PRIMARY KEY(payday, salary, employee_id),
                    FOREIGN KEY(employee_id) REFERENCES employee(id)
                );
                """;

        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(sql);
            System.out.println("> paycheck TABLE CREATED SUCCESSFULLY");
        }
    }

    private static void dropTablesIfExist(Connection connection) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate("DROP TABLE IF EXISTS paycheck");
            System.out.println("> paycheck TABLE DROPPED SUCCESSFULLY");
            statement.executeUpdate("DROP TABLE IF EXISTS employee");
            System.out.println("> employee TABLE DROPPED SUCCESSFULLY");
        }
    }
}

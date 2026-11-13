package br.com.gabriel.ifsp.exercises.jdbc.infrastructure.persistence;

import br.com.gabriel.ifsp.exercises.jdbc.domain.repository.AverageSalaryCalculator;

import java.sql.*;
import java.time.LocalDate;
import java.util.Objects;

//TODO maravilha, aqui eu vi que você mandou direto no SQL. Melhor do ponto de vista de desempenho.
//Eu só atualizaria o nome para repo. Por exemplo. AverageSalaryReport. Outra possibilidade, já apontada, é jogar em EmployeeRepository
public class SqliteAverageSalaryCalculator implements AverageSalaryCalculator {
    @Override
    public double averageSalary() {
        String sql = "SELECT AVG(salary) FROM paycheck";

        try (Connection connection = SqliteConnectionFactory.open();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(sql)) {
            return rs.next() ? rs.getDouble(1) : 0.0;
        } catch (SQLException e) {
            throw new RuntimeException("Failed to caculate the average salary", e);
        }
    }

    @Override
    public double averageSalary(String jobTitle) {
        if (jobTitle == null || jobTitle.isBlank()) {
            throw new IllegalArgumentException("jobTitle can not be null");
        }

        String sql = """
                SELECT AVG(p.salary)
                FROM paycheck p
                JOIN employee e ON e.id = p.employee_id
                WHERE job_title = ?
                """;

        try (Connection connection = SqliteConnectionFactory.open();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, jobTitle);

            ResultSet rs = statement.executeQuery();
            return rs.next()? rs.getDouble(1) : 0.0;
        } catch (SQLException e) {
            throw new RuntimeException("Failed to caculate the average salary", e);
        }
    }

    @Override
    public double averageSalary(LocalDate start, LocalDate end) {
        Objects.requireNonNull(start, "The start date can not be null");
        Objects.requireNonNull(end, "The end date can not be null");

        String sql = """
                SELECT AVG(salary)
                FROM paycheck
                WHERE payday BETWEEN ? AND ?
                """;

        try (Connection connection = SqliteConnectionFactory.open();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, start.toString());
            statement.setString(2, end.toString());

            ResultSet rs = statement.executeQuery();
            return rs.next() ? rs.getDouble(1) : 0.0;
        } catch (SQLException e) {
            throw new RuntimeException("Failed to caculate the average salary", e);
        }
    }
}

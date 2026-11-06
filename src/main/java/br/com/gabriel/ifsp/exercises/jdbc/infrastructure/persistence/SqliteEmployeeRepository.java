package br.com.gabriel.ifsp.exercises.jdbc.infrastructure.persistence;

import br.com.gabriel.ifsp.exercises.jdbc.domain.model.Employee;
import br.com.gabriel.ifsp.exercises.jdbc.domain.repository.EmployeeRepository;

import java.sql.*;
import java.time.LocalDate;
import java.util.*;

public class SqliteEmployeeRepository implements EmployeeRepository {
    @Override
    public void save(Employee employee) {
        Objects.requireNonNull(employee, "employee can not be null");

        String sql = "INSERT INTO employee(id, name, job_title, salary, date_of_employment) VALUES(?, ?, ?, ?, ?)";

        try (Connection connection = SqliteConnectionFactory.open();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, employee.getId());
            statement.setString(2, employee.getName());
            statement.setString(3, employee.getJobTitle());
            statement.setDouble(4, employee.getSalary());
            statement.setString(5, employee.getDateOfEmployment().toString());

            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Failed to save the employee", e);
        }
    }

    @Override
    public Optional<Employee> getEmployeeById(String id) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("id can not be null or blank");
        }

        String sql = "SELECT id, name, job_title, salary, date_of_employment FROM employee WHERE id = ?";

        try (Connection connection = SqliteConnectionFactory.open();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, id);

            final ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                return Optional.of(mapEmployee(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Failed to retrieve the employee", e);
        }

        return Optional.empty();
    }

    @Override
    public Employee[] getEmployees() {
        String sql = "SELECT id, name, job_title, salary, date_of_employment FROM employee";

        try (Connection connection = SqliteConnectionFactory.open();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(sql)) {

            List<Employee> employeesList = new ArrayList<>();
            while (rs.next()) {
                employeesList.add(mapEmployee(rs));
            }

            return employeesList.toArray(Employee[]::new);
        } catch (SQLException e) {
            throw new RuntimeException("Failed to retrieve employees", e);
        }
    }

    @Override
    public Employee[] getEmployees(String jobTitle) {
        if (jobTitle == null || jobTitle.isBlank()) {
            throw new IllegalArgumentException("jobTitle can not be null or blank");
        }

        String sql = "SELECT id, name, job_title, salary, date_of_employment FROM employee WHERE job_title = ?";

        try (Connection connection = SqliteConnectionFactory.open();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, jobTitle);

            final ResultSet rs = statement.executeQuery();

            List<Employee> employeesList = new ArrayList<>();
            while (rs.next()) {
                employeesList.add(mapEmployee(rs));
            }

            return employeesList.toArray(Employee[]::new);
        } catch (SQLException e) {
            throw new RuntimeException("Failed to retrieve employees", e);
        }
    }

    private Employee mapEmployee(ResultSet rs) throws SQLException {
        return new Employee(
                rs.getString("id"),
                rs.getString("name"),
                rs.getString("job_title"),
                rs.getDouble("salary"),
                LocalDate.parse(rs.getString("date_of_employment")),
                new SqlitePaycheckRepository(rs.getString("id"))
        );
    }

    @Override
    public void updateSalary(String id, double newSalary) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("id can not be null or blank");
        }

        if (newSalary <= 0) {
            throw new IllegalArgumentException("New Salary must be positive.");
        }

        String sql = "UPDATE employee SET salary = ? WHERE id = ?";

        try (Connection connection = SqliteConnectionFactory.open();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setDouble(1, newSalary);
            statement.setString(2, id);

            if (statement.executeUpdate() == 0) {
                throw new NoSuchElementException("Employee doesn't exist. id: " + id);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Failed to update salary", e);
        }
    }

    @Override
    public void delete(String id) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("Id can not be null or blank");
        }

        String sql = "DELETE FROM employee WHERE id = ?";

        try (Connection connection = SqliteConnectionFactory.open();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, id);

            if (statement.executeUpdate() == 0) {
                throw new NoSuchElementException("Employee doesn't exist. id: " + id);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Failed to delete employee", e);
        }
    }
}

package br.com.gabriel.ifsp.exercises.jdbc.infrastructure.persistence;

import br.com.gabriel.ifsp.exercises.jdbc.domain.model.Paycheck;
import br.com.gabriel.ifsp.exercises.jdbc.domain.repository.PaycheckRepository;

import java.sql.*;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Stream;

public class SqlitePaycheckRepository implements PaycheckRepository {
    private final String employeeId;

    public SqlitePaycheckRepository(String employeeId) {
        if (employeeId == null || employeeId.isBlank()) {
            throw new IllegalArgumentException("employeeId can not be null or blank");
        }

        this.employeeId = employeeId;
    }

    @Override
    public void add(Paycheck paycheck) {
        Objects.requireNonNull(paycheck, "paycheck can not be null");

        String sql = "INSERT INTO paycheck(payday, salary, employee_id) VALUES(?, ?, ?)";

        try (final Connection connection = SqliteConnectionFactory.open();
             final PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, paycheck.getPayday().toString());
            statement.setDouble(2, paycheck.getSalary());
            statement.setString(3, employeeId);

            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Failed to add paycheck", e);
        }
    }

    @Override
    public void remove(Paycheck paycheck) {
        Objects.requireNonNull(paycheck, "paycheck can not be null");

        String sql = "DELETE FROM paycheck WHERE employee_id = ? AND payday = ? AND salary = ?";

        try (final Connection connection = SqliteConnectionFactory.open();
             final PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, employeeId);
            statement.setString(2, paycheck.getPayday().toString());
            statement.setDouble(3, paycheck.getSalary());

            if (statement.executeUpdate() == 0) {
                throw new NoSuchElementException("Paycheck doesn't exist. employeeId: " + employeeId + " payday: " + paycheck.getPayday() + " salary: " + paycheck.getSalary());
            }
        } catch (SQLException e) {
            throw new RuntimeException("Failed to remove paycheck", e);
        }
    }

    private Set<Paycheck> getPaychecks() {
        String sql = "SELECT * FROM paycheck WHERE employee_id = ?";

        try (final Connection connection = SqliteConnectionFactory.open();
             final PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, employeeId);

            final ResultSet rs = statement.executeQuery();

            Set<Paycheck> paychecks = new LinkedHashSet<>();
            while (rs.next()) {
                paychecks.add(new Paycheck(LocalDate.parse(rs.getString("payday")), rs.getDouble("salary")));
            }

            return paychecks;
        } catch (SQLException e) {
            throw new RuntimeException("Failed to retrieve paychecks", e);
        }
    }

    @Override
    public Iterator<Paycheck> iterator() {
        return getPaychecks().iterator();
    }

    @Override
    public Stream<Paycheck> stream() {
        return getPaychecks().stream();
    }
}

package br.com.gabriel.ifsp.exercises.mvcdao.dao.impl;

import br.com.gabriel.ifsp.exercises.mvcdao.config.ConnectionFactory;
import br.com.gabriel.ifsp.exercises.mvcdao.dao.interfaces.TeamDAO;
import br.com.gabriel.ifsp.exercises.mvcdao.dto.TeamDTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class SqliteTeamDAO implements TeamDAO {
    @Override
    public void insert(TeamDTO teamDto) {
        Objects.requireNonNull(teamDto, "teamDto cannot be null");

        String sql = "INSERT INTO team (name, coach_name, base_location, captain_number) VALUES (?, ?, ?, ?)";

        try (PreparedStatement statement = ConnectionFactory.getPrepareStatement(sql)) {
            statement.setString(1, teamDto.name());
            statement.setString(2, teamDto.coachName());
            statement.setString(3, teamDto.baseLocation());
            statement.setObject(4, (teamDto.captainNumber() == -1 ? null : teamDto.captainNumber()));

            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Failed to insert the team", e);
        }
    }

    @Override
    public void update(TeamDTO teamDto) {
        Objects.requireNonNull(teamDto, "teamDto cannot be null");

        String sql = "UPDATE team SET coach_name = ?, base_location = ?, captain_number = ? WHERE name = ?";

        try (PreparedStatement statement = ConnectionFactory.getPrepareStatement(sql)) {
            statement.setString(1, teamDto.coachName());
            statement.setString(2, teamDto.baseLocation());
            statement.setObject(3, (teamDto.captainNumber() == -1 ? null : teamDto.captainNumber()));
            statement.setString(4, teamDto.name());

            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Failed to update the team", e);
        }
    }

    @Override
    public void delete(TeamDTO teamDto) {
        Objects.requireNonNull(teamDto, "teamDto cannot be null");

        delete(teamDto.name());
    }

    @Override
    public void delete(String teamName) {
        String sql = "DELETE FROM team WHERE name = ?";

        try (PreparedStatement statement = ConnectionFactory.getPrepareStatement(sql)) {
            statement.setString(1, teamName);

            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Failed to delete the team " + teamName, e);
        }
    }

    @Override
    public Set<TeamDTO> findAll() {
        String sql = "SELECT * FROM team";

        try (Statement statement = ConnectionFactory.getConnection().createStatement();
             ResultSet rs = statement.executeQuery(sql)) {
            Set<TeamDTO> teams = new LinkedHashSet<>();

            while (rs.next()) {
                teams.add(new TeamDTO(
                        rs.getString("name"),
                        rs.getString("base_location"),
                        rs.getString("coach_name"),
                        rs.getInt("captain_number")
                ));
            }
            return teams;
        } catch (SQLException e) {
            throw new RuntimeException("Failed to find all the teams", e);
        }
    }

    @Override
    public Optional<TeamDTO> findOne(String teamName) {
        String sql = "SELECT * FROM team WHERE name = ?";

        try (PreparedStatement statement = ConnectionFactory.getPrepareStatement(sql)) {
            statement.setString(1, teamName);

            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return Optional.of(new TeamDTO(
                        rs.getString("name"),
                        rs.getString("base_location"),
                        rs.getString("coach_name"),
                        rs.getInt("captain_number")
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Failed to find the team " + teamName, e);
        }

        return Optional.empty();
    }
}

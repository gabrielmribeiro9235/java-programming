package br.com.gabriel.ifsp.exercises.mvcdao.dao.impl;

import br.com.gabriel.ifsp.exercises.mvcdao.config.ConnectionFactory;
import br.com.gabriel.ifsp.exercises.mvcdao.dao.interfaces.PlayerDAO;
import br.com.gabriel.ifsp.exercises.mvcdao.dto.PlayerDTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class SqlitePlayerDAO implements PlayerDAO {
    @Override
    public void insert(PlayerDTO playerDto) {
        Objects.requireNonNull(playerDto, "playerDto cannot be null");

        String sql = "INSERT INTO player (team_name, number, name, position, is_fielded) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement statement = ConnectionFactory.getPrepareStatement(sql)) {
            statement.setString(1, playerDto.teamName());
            statement.setInt(2, playerDto.number());
            statement.setString(3, playerDto.name());
            statement.setString(4, playerDto.postion());
            statement.setInt(5, playerDto.isFielded() ? 1 : 0);

            statement.executeUpdate();
        }  catch (SQLException e) {
            throw new RuntimeException("Failed to insert the player", e);
        }
    }

    @Override
    public void update(PlayerDTO playerDto) {
        Objects.requireNonNull(playerDto, "playerDto cannot be null");

        String sql = """
                UPDATE player SET team_name = ? number = ?, name = ?, position = ?, is_fielded = ?
                    WHERE team_name = ? AND number = ?
                """;

        try (PreparedStatement statement = ConnectionFactory.getPrepareStatement(sql)) {
            statement.setString(1, playerDto.teamName());
            statement.setInt(2, playerDto.number());
            statement.setString(3, playerDto.name());
            statement.setString(4, playerDto.postion());
            statement.setInt(5, playerDto.isFielded() ? 1 : 0);
            statement.setString(6, playerDto.teamName());
            statement.setInt(7, playerDto.number());

            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Failed to update the player", e);
        }
    }

    @Override
    public void delete(PlayerDTO playerDto) {
        Objects.requireNonNull(playerDto, "playerDto cannot be null");

        delete(playerDto.number(),  playerDto.teamName());
    }

    @Override
    public void delete(int playerNumber, String teamName) {
        String sql = "DELETE FROM player WHERE team_name = ? AND number = ?";

        try (PreparedStatement statement = ConnectionFactory.getPrepareStatement(sql)) {
            statement.setString(1, teamName);
            statement.setInt(2, playerNumber);

            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Failed to delete the player", e);
        }
    }

    @Override
    public Set<PlayerDTO> findAll() {
        String sql = "SELECT * FROM player";

        try (Statement statement = ConnectionFactory.getConnection().createStatement();
             ResultSet rs = statement.executeQuery(sql)) {
            Set<PlayerDTO> players = new LinkedHashSet<>();

            while (rs.next()) {
                players.add(new PlayerDTO(
                        rs.getString("team_name"),
                        rs.getInt("number"),
                        rs.getString("name"),
                        rs.getString("position"),
                        rs.getInt("is_fielded") == 1)
                );
            }
            return players;
        } catch (SQLException e) {
            throw new RuntimeException("Failed to find all the players", e);
        }
    }

    @Override
    public Set<PlayerDTO> findAllByTeam(String teamName) {
        String sql = "SELECT * FROM player  WHERE team_name = ?";

        try (PreparedStatement statement = ConnectionFactory.getPrepareStatement(sql)) {
            statement.setString(1, teamName);

            ResultSet rs = statement.executeQuery();
            Set<PlayerDTO> players = new LinkedHashSet<>();

            while (rs.next()) {
                players.add(new PlayerDTO(
                        rs.getString("team_name"),
                        rs.getInt("number"),
                        rs.getString("name"),
                        rs.getString("position"),
                        rs.getInt("is_fielded") == 1
                ));
            }
            return players;
        } catch (SQLException e) {
            throw new RuntimeException("Failed to find all the players of the team " + teamName, e);
        }
    }

    @Override
    public Optional<PlayerDTO> findOne(int playerNumber, String teamName) {
        String sql = "SELECT * FROM player WHERE team_name = ? AND number = ?";

        try (PreparedStatement statement = ConnectionFactory.getPrepareStatement(sql)) {
            statement.setString(1, teamName);
            statement.setInt(2, playerNumber);

            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                return Optional.of(new PlayerDTO(
                        rs.getString("team_name"),
                        rs.getInt("number"),
                        rs.getString("name"),
                        rs.getString("position"),
                        rs.getInt("is_fielded") == 1
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Failed to find player " + playerNumber + " of the team " + teamName, e);
        }

        return Optional.empty();
    }
}

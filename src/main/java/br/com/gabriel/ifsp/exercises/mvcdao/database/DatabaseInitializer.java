package br.com.gabriel.ifsp.exercises.mvcdao.database;

import br.com.gabriel.ifsp.exercises.mvcdao.config.ConnectionFactory;

import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseInitializer {
    private DatabaseInitializer() {}

    public static void init() throws SQLException {
        createTeamTable();
        createPlayerTable();
    }

    private static void createTeamTable() throws SQLException {
        String sql = """
                CREATE TABLE IF NOT EXISTS team (
                    name            TEXT NOT NULL PRIMARY KEY,
                    coach_name      TEXT NOT NULL,
                    base_location   TEXT NOT NULL,
                    captain_number  INTEGER,
                    FOREIGN KEY (name, captain_number) REFERENCES player (team_name, number)
                );
                """;

        try (Statement statement = ConnectionFactory.getConnection().createStatement()) {
            statement.executeUpdate(sql);
        }
    }

    private static void createPlayerTable() throws SQLException {
        String sql = """
                CREATE TABLE IF NOT EXISTS player (
                    team_name   TEXT NOT NULL,
                    number      TEXT NOT NULL,
                    name        TEXT NOT NULL,
                    is_fielded  INTEGER NOT NULL DEFAULT 0,
                    position    TEXT NOT NULL,
                    PRIMARY KEY (team_name, number),
                    FOREIGN KEY (team_name) REFERENCES team (name)
                        ON UPDATE CASCADE ON DELETE CASCADE
                );
                """;

        try (Statement statement = ConnectionFactory.getConnection().createStatement()) {
            statement.executeUpdate(sql);
        }
    }
}

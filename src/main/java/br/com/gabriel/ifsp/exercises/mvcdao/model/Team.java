package br.com.gabriel.ifsp.exercises.mvcdao.model;

import java.util.Objects;
import static java.util.function.Predicate.not;

public class Team {
    private final String name;
    private final String baseLocation;
    private final String coachName;
    private Player captain;
    private final PlayerRepository players;

    public Team(String name, String baseLocation, String coachName) {
        Objects.requireNonNull(name, "Name cannot be null");
        Objects.requireNonNull(baseLocation, "Base location cannot be null");
        Objects.requireNonNull(coachName, "Coach name cannot be null");
        this.name = name;
        this.baseLocation = baseLocation;
        this.coachName = coachName;
        players = new PlayerRepository(name);
    }

    public void addPlayer(Player player) {
        Objects.requireNonNull(player, "Player cannot be null");
        players.add(player);
    }

    public void removePlayer(Player player) {
        Objects.requireNonNull(player, "Player cannot be null");
        players.remove(player);
    }

    public void substitute(Player substitute, Player starter) {
        Objects.requireNonNull(substitute, "Substitute cannot be null");
        Objects.requireNonNull(starter, "Starter cannot be null");

        if (!starter.isFielded() || substitute.isFielded()) return;

        starter.setFielded(false);
        substitute.setFielded(true);
    }

    public Player[] getFieldedPlayers() {
        return players.findAll()
                .filter(Player::isFielded)
                .toList()
                .toArray(Player[]::new);
    }

    public Player[] getOutfieldedPlayers() {
        return players.findAll()
                .filter(not(Player::isFielded))
                .toList()
                .toArray(Player[]::new);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team) o;
        return Objects.equals(name, team.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    @Override
    public String toString() {
        return "Team{" +
                "name='" + name + '\'' +
                ", baseLocation='" + baseLocation + '\'' +
                ", coachName='" + coachName + '\'' +
                ", captain=" + captain.getName() +
                '}';
    }

    public String getName() {
        return name;
    }

    public String getBaseLocation() {
        return baseLocation;
    }

    public String getCoachName() {
        return coachName;
    }

    public Player getCaptain() {
        return captain;
    }

    public void setCaptain(Player captain) {
        this.captain = captain;
    }
}

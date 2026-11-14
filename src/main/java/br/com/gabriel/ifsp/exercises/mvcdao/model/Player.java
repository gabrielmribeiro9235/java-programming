package br.com.gabriel.ifsp.exercises.mvcdao.model;

import java.util.Objects;

public class Player {
    private final String name;
    private final int number;
    private final String position;
    private Team team;
    private boolean isFielded;

    public Player(String name, int number, String position, Team team) {
        this.name = name;
        this.number = number;
        this.position = position;
        this.team = team;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return number == player.number && Objects.equals(team, player.team);
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", number=" + number +
                ", position='" + position + '\'' +
                ", team=" + team.getName() +
                ", isFielded=" + isFielded +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, team);
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public String getPosition() {
        return position;
    }

    public boolean isFielded() {
        return isFielded;
    }

    public void setFielded(boolean fielded) {
        isFielded = fielded;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}

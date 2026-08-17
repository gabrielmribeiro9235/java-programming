package br.com.gabriel.ifsp.exercises.teamofplayers;

public class Player {
    private final String name;
    private final int number;
    private final String position;
    private boolean isFielded;
    private final Team team;

    public Player(String name, int number, String position, boolean isFielded, Team team) {
        this.name = name;
        this.number = number;
        this.position = position;
        this.isFielded = isFielded;
        this.team = team;
    }

    public void setFielded(boolean fielded) {
        isFielded = fielded;
    }

    public boolean isFielded() {
        return isFielded;
    }

    public String getStateAsString() {
        return "[Name: " + name + ", Number: " + number + ", Position: " + position + ", Team: " + team.getName() + ", Fielded: " + (isFielded ? "yes" : "no") + "]";
    }
}

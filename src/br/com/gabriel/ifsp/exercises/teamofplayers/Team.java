package br.com.gabriel.ifsp.exercises.teamofplayers;

public class Team {
    private final String name;
    private final String baseLocation;
    private String coachName;
    private final Player[] players = new Player[18];
    private int numberOfPlayers = 0;
    private Player captain;

    public Team(String name, String baseLocation, String coachName) {
        this.name = name;
        this.baseLocation = baseLocation;
        this.coachName = coachName;
    }

    public void addPlayer(Player player) {
        if (numberOfPlayers == 18) return;

        players[numberOfPlayers++] = player;
    }

    public void removePlayer(Player player) {
        int index = -1;

        for (int i = 0; i < numberOfPlayers; i++) {
            if (players[i].equals(player)) {
                index = i;
                break;
            }
        }

        if (index == -1) return;

        for (int i = index; i < numberOfPlayers - 1; i++) {
            players[i] = players[i+1];
        }

        players[--numberOfPlayers] = null;
    }

    public void substitute(Player substitute, Player starter) {
        for (int i = 0; i < numberOfPlayers; i++) {
            if (players[i].equals(substitute)) players[i].setFielded(true);

            if (players[i].equals(starter)) players[i].setFielded(false);
        }
    }

    public void setCaptain(Player captain) {
        this.captain = captain;
    }

    public Player[] getFieldedPlayers() {
        int numberOfFieldedPlayers = 0;
        for (int i = 0; i < numberOfPlayers; i++) {
            if (players[i].isFielded()) numberOfFieldedPlayers++;
        }

        Player[] fieldedPlayers = new Player[numberOfFieldedPlayers];
        int i = 0;
        for (int j = 0; j < numberOfPlayers; j++) {
            if (players[j].isFielded()) fieldedPlayers[i++] = players[j];
        }

        return fieldedPlayers;
    }

    public Player[] getOutfieldedPlayers() {
        int numberOfOutfieldedPlayers = 0;
        for (int i = 0; i < numberOfPlayers; i++) {
            if (!players[i].isFielded()) numberOfOutfieldedPlayers++;
        }

        Player[] outfieldedPlayers = new Player[numberOfOutfieldedPlayers];
        int i = 0;
        for (int j = 0; j < numberOfPlayers; j++) {
            if (!players[j].isFielded()) outfieldedPlayers[i++] = players[j];
        }

        return outfieldedPlayers;
    }

    public void setCoachName(String coachName) {
        this.coachName = coachName;
    }

    public String getTeamInformation() {
        return "[Name: " + name + ", Base Location: " + baseLocation + ", Coach: " + coachName + "]";
    }

    public String getName() {
        return name;
    }

    public String getPlayersAsString() {
        String string = "";
        for (int i = 0; i < numberOfPlayers; i++) {
            Player player = players[i];

            string += player.getStateAsString() + "\n";
        }
        return string;
    }

    public Player getCaptain() {
        return captain;
    }
}

package br.com.gabriel.ifsp.exercises.teamofplayers;

public class Main {
    public static void main(String[] args) {
        Team team = new Team("São Paulo", "SP", "Dorival");

        for (int i = 0; i < 18; i++) {
            Player player = new Player("Player" + (i < 9 ? "0" : "") + (i+1), 10 + i, "position" + (i < 9 ? "0" : "") + (i+1), (i < 11), team);
            team.addPlayer(player);
            if (i == 4) team.setCaptain(player);
        }

        Player[] fieldedPlayers = team.getFieldedPlayers();
        for (Player player : fieldedPlayers) {
            System.out.println(player.getStateAsString());
        }

        Player[] outfieldedPlayers = team.getOutfieldedPlayers();
        for (Player player : outfieldedPlayers) {
            System.out.println(player.getStateAsString());
        }

        team.substitute(outfieldedPlayers[0], fieldedPlayers[0]);

        System.out.println("----------------------------------------");

        System.out.println(team.getPlayersAsString());

        System.out.println("----------------------------------------");

        team.removePlayer(outfieldedPlayers[outfieldedPlayers.length - 1]);
        System.out.println(team.getPlayersAsString());

        System.out.println("----------------------------------------");

        System.out.println(team.getTeamInformation());

        System.out.println("----------------------------------------");

        team.setCoachName("Diniz");
        System.out.println(team.getTeamInformation());

        System.out.println("----------------------------------------");

        System.out.println(team.getCaptain().getStateAsString());
    }
}

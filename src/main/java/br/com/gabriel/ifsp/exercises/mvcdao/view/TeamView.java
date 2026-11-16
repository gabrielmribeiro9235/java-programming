package br.com.gabriel.ifsp.exercises.mvcdao.view;

import br.com.gabriel.ifsp.exercises.mvcdao.controller.TeamController;
import br.com.gabriel.ifsp.exercises.mvcdao.dao.impl.SqlitePlayerDAO;
import br.com.gabriel.ifsp.exercises.mvcdao.dao.impl.SqliteTeamDAO;
import br.com.gabriel.ifsp.exercises.mvcdao.model.Player;
import br.com.gabriel.ifsp.exercises.mvcdao.model.Team;

import java.util.Scanner;
import java.util.Set;

public class TeamView {
    private final TeamController teamController = new TeamController(new SqlitePlayerDAO(), new SqliteTeamDAO());

    public void addTeam() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Insert the new team information");
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Base location: ");
        String baseLocation = scanner.nextLine();
        System.out.print("Coach name: ");
        String coachName = scanner.nextLine();

        teamController.addTeam(new Team(name, baseLocation, coachName));
    }

    public void deleteTeam() {
        Set<Team> teams = teamController.findAllTeams();
        System.out.println("Select the team you want to delete");
        showTeams(teams);

        int choice = choiceItem(teams.size());

        teamController.deleteTeam(teams.stream().toList().get(choice - 1));
    }

    public void updateTeam() {
        Set<Team> teams = teamController.findAllTeams();
        System.out.println("Select the team you want to update");
        showTeams(teams);

        int choice = choiceItem(teams.size());
        Team team = teams.stream().toList().get(choice - 1);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Insert the new information of the team (let it empty if you don't want to change the field)");

        System.out.print("Base location: ");
        String baseLocation = scanner.nextLine();
        baseLocation = !baseLocation.isBlank() ? baseLocation : team.getBaseLocation();

        System.out.print("Coach name: ");
        String coachName = scanner.nextLine();
        coachName = !coachName.isBlank() ? coachName : team.getCoachName();

        teamController.updateTeam(new Team(team.getName(), baseLocation, coachName));
    }

    private int choiceItem(int numberOfItems) {
        Scanner scanner = new Scanner(System.in);

        int choice;
        while (true) {
            try {
                System.out.print("Your choice: ");
                choice = Integer.parseInt(scanner.nextLine());
                if (choice <= 0 || choice > numberOfItems) {
                    throw new RuntimeException();
                }
                break;
            } catch (RuntimeException e) {
                System.err.println("Invalid choice. Try again");
            }
        }

        return choice;
    }

    public void deleteTeamByName() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Insert the name of the team you want to delete");
        System.out.print("Name: ");
        String name = scanner.nextLine();

        teamController.deleteTeam(name);
    }

    public void showTeam() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Insert the name of the team you are looking for:");
        String name = scanner.nextLine();

        System.out.println(teamController.findTeamByName(name));
    }

    public void showTeams() {
        Set<Team> teams = teamController.findAllTeams();

        showTeams(teams);
    }

    private void showTeams(Set<Team> teams) {
        int i = 1;
        for (Team team : teams) {
            System.out.println(i + " - " + team);
            i++;
        }
    }

    public void addPlayer() {
        Set<Team> teams = teamController.findAllTeams();
        System.out.println("Select the team you want to add a player");
        showTeams(teams);

        int choice = choiceItem(teams.size());
        Team team = teams.stream().toList().get(choice - 1);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Insert the new player information");

        System.out.print("Name: ");
        String name = scanner.nextLine();

        int number;
        while (true) {
            try {
                System.out.print("Number: ");
                number =  Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.err.println("Invalid number. Try again");
            }
        }

        System.out.print("Position: ");
        String position = scanner.nextLine();

        Player newPlayer = new Player(name, number, position, team);
        if (teamController.getAllPlayersFrom(team).length < 11) {
            newPlayer.setFielded(true);
        }

        teamController.addPlayer(team, newPlayer);
    }

    public void deletePlayer() {
        Set<Team> teams = teamController.findAllTeams();
        System.out.println("Select the team you want to remove a player");
        showTeams(teams);

        int choice = choiceItem(teams.size());
        Team team = teams.stream().toList().get(choice - 1);

        System.out.println("Select the player you want to remove");
        Player[] players = teamController.getAllPlayersFrom(team);
        showPlayers(players);

        choice = choiceItem(players.length);
        Player player = players[choice - 1];

        teamController.removePlayer(team, player);
    }

    public void setCaptain() {
        Set<Team> teams = teamController.findAllTeams();
        System.out.println("Select the team you want to set the captain");
        showTeams(teams);

        int choice = choiceItem(teams.size());
        Team team = teams.stream().toList().get(choice - 1);

        System.out.println("Select the player you want to be captain of the team");
        Player[] players = teamController.getAllPlayersFrom(team);
        showPlayers(players);

        choice = choiceItem(players.length);
        Player player = players[choice - 1];

        teamController.setCaptain(team, player);
    }

    public void substitutePlayer() {
        Set<Team> teams = teamController.findAllTeams();
        System.out.println("Select the team you want to substitute");
        showTeams(teams);

        int choice = choiceItem(teams.size());
        Team team = teams.stream().toList().get(choice - 1);

        System.out.println("List of players");
        Player[] players = teamController.getAllPlayersFrom(team);
        showPlayers(players);

        System.out.println("Select the starter you want to substitute");
        choice = choiceItem(players.length);
        Player starter = players[choice - 1];

        System.out.println("Select the substitute");
        choice = choiceItem(players.length);
        Player substitute = players[choice - 1];


        teamController.substitutePlayer(team, substitute, starter);
    }

    public void showFieldedPlayers() {
        Set<Team> teams = teamController.findAllTeams();
        System.out.println("Select the team you want to see the fielded players");
        showTeams(teams);

        int choice = choiceItem(teams.size());
        Team team = teams.stream().toList().get(choice - 1);

        Player[] fieldedPlayers = teamController.getFieldedPlayers(team);
        showPlayers(fieldedPlayers);
    }

    public void showOutfieldedPlayers() {
        Set<Team> teams = teamController.findAllTeams();
        System.out.println("Select the team you want to see the outfielded players");
        showTeams(teams);

        int choice = choiceItem(teams.size());
        Team team = teams.stream().toList().get(choice - 1);

        Player[] outfieldedPlayers = teamController.getOutfieldedPlayers(team);
        showPlayers(outfieldedPlayers);
    }

    public void showAllPlayers() {
        showPlayers(teamController.getAllPlayers());
    }

    private void showPlayers(Player[] players) {
        for (int i = 0; i < players.length; i++) {
            Player player = players[i];
            System.out.println(i + 1 + " - " + player);
        }
    }
}

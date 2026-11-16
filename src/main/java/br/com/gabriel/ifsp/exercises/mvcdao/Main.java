
package br.com.gabriel.ifsp.exercises.mvcdao;

import br.com.gabriel.ifsp.exercises.mvcdao.database.DatabaseInitializer;
import br.com.gabriel.ifsp.exercises.mvcdao.view.TeamView;

import java.util.Scanner;

public class Main {

    static void main() {
        TeamView view = new TeamView();
        Scanner scanner = new Scanner(System.in);

        try {
            DatabaseInitializer.init();

            boolean running = true;

            while (running) {
                try {
                    System.out.println("\n========== TEAM MANAGEMENT ==========");
                    System.out.println("1 - Register team");
                    System.out.println("2 - List all teams");
                    System.out.println("3 - Find team");
                    System.out.println("4 - Update team");
                    System.out.println("5 - Delete team");
                    System.out.println("6 - Delete team by name");
                    System.out.println("7 - Add player");
                    System.out.println("8 - Delete player");
                    System.out.println("9 - Set captain");
                    System.out.println("10 - Substitute player");
                    System.out.println("11 - List all players");
                    System.out.println("12 - List fielded players");
                    System.out.println("13 - List outfielded players");
                    System.out.println("0 - Exit");
                    System.out.print("Your choice: ");

                    int choice;
                    try {
                        choice = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        choice = -1;
                    }

                    switch (choice) {
                        case 1 -> view.addTeam();
                        case 2 -> view.showTeams();
                        case 3 -> view.showTeam();
                        case 4 -> view.updateTeam();
                        case 5 -> view.deleteTeam();
                        case 6 -> view.deleteTeamByName();
                        case 7 -> view.addPlayer();
                        case 8 -> view.deletePlayer();
                        case 9 -> view.setCaptain();
                        case 10 -> view.substitutePlayer();
                        case 11 -> view.showAllPlayers();
                        case 12 -> view.showFieldedPlayers();
                        case 13 -> view.showOutfieldedPlayers();
                        case 0 -> running = false;
                        default -> System.err.println("Invalid choice. Try again.");
                    }

                } catch (Exception e) {
                    System.err.println("\nOperation failed: " + e.getMessage()
                            + (e.getCause() == null
                            ? ""
                            : "\nCause: " + e.getCause().getMessage()));

                    System.out.println("Returning to the main menu...");
                }
            }

            System.out.println("Application closed.");

        } catch (Exception e) {
            System.err.println("Database initialization failed: " + e.getMessage()
                    + (e.getCause() == null
                    ? ""
                    : "\nCause: " + e.getCause().getMessage()));
        }
    }
}

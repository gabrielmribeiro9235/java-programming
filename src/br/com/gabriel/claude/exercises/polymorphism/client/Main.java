package br.com.gabriel.claude.exercises.polymorphism.client;

import java.time.LocalDate;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        FakeClientRepository repository = new FakeClientRepository();

        RegisterClientService registerClientService = new RegisterClientService(repository);
        FindClientService findClientService = new FindClientService(repository);

        registerClientService.register(new Client("01", "Joseph Edwards", "joseph@gmail.com", LocalDate.of(2023, 6, 20), 10));
        registerClientService.register(new Client("02", "Caroline Harrison", "caroline@gmail.com", LocalDate.of(2022, 6, 20), 5));
        registerClientService.register(new Client("03", "Mary Jane", "mary@gmail.com", LocalDate.of(2021, 6, 20), 7));
        registerClientService.register(new Client("04", "John Stevenson", "john@gmail.com", LocalDate.of(2025, 6, 20), 25));
        // trying to save another employee with id 01
        registerClientService.register(new Client("01", "Anthony Joshua", "ADS", LocalDate.of(2026, 6, 20), 0));

        System.out.println("Client with id 04:");
        Client client = findClientService.findById("04");

        if (client != null) {
            System.out.println(client);

            System.out.printf("\nDiscount for %s: %.2f%%\n", client.getName(), client.calculateDiscount());

            client.setLoyaltyPoints(client.getLoyaltyPoints() + 5);

            System.out.printf(Locale.US, "\n%s received an additional 5 loyalty points and now has: %d\n", client.getName(), client.getLoyaltyPoints());
            System.out.printf("Now, the discount for %s is: %.2f%%\n", client.getName(), client.calculateDiscount());
        } else {
            System.out.println("There's no employee with id 04");
        }

        System.out.println("\n------------------------------------------------------------------------------------------------");
        System.out.println("All clients saved:\n");
        System.out.println(repository.showAllClients());
    }
}

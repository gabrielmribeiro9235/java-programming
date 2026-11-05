package br.com.gabriel.claude.exercises.polymorphism.vehicle;

import java.time.LocalDate;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        FakeVehicleRepository repository = new FakeVehicleRepository();

        RegisterVehicleService registerVehicleService = new RegisterVehicleService(repository);
        FindVehicleService findVehicleService = new FindVehicleService(repository);

        registerVehicleService.register(new Vehicle("01", "ABA9967", "Fusca", LocalDate.of(2023, 6, 20), 1_000_000));
        registerVehicleService.register(new Vehicle("02", "BBT7862", "Versa", LocalDate.of(2022, 6, 20), 500_000));
        registerVehicleService.register(new Vehicle("03", "JET8923", "SW4", LocalDate.of(2021, 6, 20), 135_000));
        registerVehicleService.register(new Vehicle("04", "KJR7639", "Corolla", LocalDate.of(2025, 6, 20), 320_000));
        // trying to save another employee with id 01
        registerVehicleService.register(new Vehicle("01", "FCR7843", "March", LocalDate.of(2026, 6, 20), 450_000));

        System.out.println("Vehicle with id 01:");
        Vehicle vehicle = findVehicleService.findById("01");

        if (vehicle != null) {
            System.out.println(vehicle);

            System.out.printf(Locale.US, "\nMaintenance cost of the %s: %.2f\n", vehicle.getModel(), vehicle.calculateMaintenanceCost());

            vehicle.setMileage(vehicle.getMileage() + 100_000);

            System.out.printf("\n%s traveled another 100,000 kilometers\n", vehicle.getModel());
            System.out.printf(Locale.US, "Now, his mileage is: %.1f\n", vehicle.getMileage());
        } else {
            System.out.println("There's no vehicle with id 01");
        }

        System.out.println("\n------------------------------------------------------------------------------------------------");
        System.out.println("All vehicles saved:\n");
        System.out.println(repository.showAllVehicles());
    }
}

package br.com.gabriel.claude.exercises.polymorphism.vehicle;

import java.util.StringJoiner;

public class FakeVehicleRepository implements Repository<String, Vehicle> {
    private Vehicle[] vehicles;
    private int numberOfVehicles;

    public FakeVehicleRepository() {
        vehicles = new Vehicle[10];
    }

    private void increaseArraySize() {
        Vehicle[] copy = vehicles.clone();

        vehicles = new Vehicle[numberOfVehicles * 2];

        for (int i = 0; i < numberOfVehicles; i++) {
            vehicles[i] = copy[i];
        }
    }

    @Override
    public void saveEntity(Vehicle entity) {
        if (entity == null) return;

        if (numberOfVehicles == vehicles.length) increaseArraySize();

        vehicles[numberOfVehicles++] = entity;
    }

    @Override
    public Vehicle findById(String id) {
        if (id == null) return null;

        for (int i = 0; i < numberOfVehicles; i++) {
            if (vehicles[i].getId().equals(id)) return vehicles[i];
        }

        return null;
    }

    @Override
    public boolean existsById(String id) {
        if (id == null) return false;

        for (int i = 0; i < numberOfVehicles; i++) {
            if (vehicles[i].getId().equals(id)) return true;
        }

        return false;
    }

    public String showAllVehicles() {
        StringJoiner joiner = new StringJoiner("\n------------------------------------------------------------------------------------------------\n");

        for (int i = 0; i < numberOfVehicles; i++) {
            joiner.add("Vehicle " + (i + 1) + "\n" + vehicles[i].toString());
        }

        return joiner.toString();
    }
}

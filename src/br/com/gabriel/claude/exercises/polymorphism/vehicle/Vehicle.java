package br.com.gabriel.claude.exercises.polymorphism.vehicle;

import java.time.LocalDate;
import java.time.Period;

public class Vehicle {
    private final String id;
    private final String plate;
    private final String model;
    private double mileage;
    private final LocalDate purchaseDate;

    public Vehicle(String id, String plate, String model, LocalDate purchaseDate, double mileage) {
        this.id = id;
        this.plate = plate;
        this.model = model;
        this.purchaseDate = purchaseDate;
        this.mileage = mileage;
    }

    public String getId() {
        return id;
    }

    public String getPlate() {
        return plate;
    }

    public String getModel() {
        return model;
    }

    public double getMileage() {
        return mileage;
    }

    public void setMileage(double mileage) {
        this.mileage = mileage;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public int getAge() {
        return Period.between(purchaseDate, LocalDate.now()).getYears();
    }

    public double calculateMaintenanceCost() {
        return 150 * getAge() + 0.05 * getMileage();
    }
}

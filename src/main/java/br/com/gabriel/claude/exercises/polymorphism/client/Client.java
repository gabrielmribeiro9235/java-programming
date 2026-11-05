package br.com.gabriel.claude.exercises.polymorphism.client;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

public class Client {
    private final String id;
    private final String name;
    private final String email;
    private int loyaltyPoints;
    private final LocalDate registrationDate;

    public Client(String id, String name, String email, LocalDate registrationDate, int loyaltyPoints) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.registrationDate = registrationDate;
        this.loyaltyPoints = loyaltyPoints;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }

    public void setLoyaltyPoints(int loyaltyPoints) {
        this.loyaltyPoints = loyaltyPoints;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public int getMembershipDuration() {
        return Period.between(registrationDate, LocalDate.now()).getYears();
    }

    public double calculateDiscount() {
        return getMembershipDuration() + 0.01 * loyaltyPoints;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(id, client.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Client{" +
                "id='" + getId() + '\'' +
                ", name='" + getName() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", loyaltyPoints=" + getLoyaltyPoints() +
                ", registrationDate=" + getRegistrationDate() +
                '}';
    }
}

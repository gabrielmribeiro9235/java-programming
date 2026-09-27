package br.com.gabriel.claude.exercises.polymorphism.product;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

public class Product {
    private final int id;
    private final String name;
    private double price;
    private int stockQuantity;
    private final LocalDate manufactureDate;

    public Product(int id, LocalDate manufactureDate, String name, double price, int stockQuantity) {
        this.id = id;
        this.manufactureDate = manufactureDate;
        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public LocalDate getManufactureDate() {
        return manufactureDate;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", price=" + getPrice() +
                ", stockQuantity=" + getStockQuantity() +
                ", manufactureDate=" + getManufactureDate() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    public long getShelfLifeInDays() {
        return ChronoUnit.DAYS.between(manufactureDate, LocalDate.now());
    }

    public void applyPriceAdjustment(double percentage) {
        setPrice(price * (1 + percentage));
    }
}

package br.com.gabriel.claude.exercises.polymorphism.product;

import java.util.StringJoiner;

public class FakeProductRepository implements Repository<Integer, Product> {
    private Product[] products;
    private int numberOfProducts;

    public FakeProductRepository() {
        products = new Product[10];
    }

    private void increaseArraySize() {
        Product[] copy = products.clone();

        products = new Product[numberOfProducts * 2];

        for (int i = 0; i < numberOfProducts; i++) {
            products[i] = copy[i];
        }
    }

    @Override
    public void saveEntity(Product entity) {
        if (entity == null) return;

        if (numberOfProducts == products.length) increaseArraySize();

        products[numberOfProducts++] = entity;
    }

    @Override
    public Product findById(Integer id) {
        if (id == null) return null;

        for (int i = 0; i < numberOfProducts; i++) {
            if (products[i].getId() == id) return products[i];
        }

        return null;
    }

    public String showAllProducts() {
        StringJoiner joiner = new StringJoiner("\n------------------------------------------------------------------------------------------------\n");

        for (int i = 0; i < numberOfProducts; i++) {
            joiner.add("Products " + (i + 1) + "\n" + products[i].toString());
        }

        return joiner.toString();
    }
}

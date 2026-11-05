package br.com.gabriel.claude.exercises.polymorphism.product;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        FakeProductRepository repository = new FakeProductRepository();

        RegisterProductService registerProductService = new RegisterProductService(repository);
        FindProductService findProductService = new FindProductService(repository);

        registerProductService.register(new Product(1, LocalDate.of(2023, 6, 20), "Monitor", 100.0, 10));
        registerProductService.register(new Product(2, LocalDate.of(2022, 6, 20), "Mouse", 5.0, 250));
        registerProductService.register(new Product(3, LocalDate.of(2021, 6, 20), "Keyboard", 20, 150));
        registerProductService.register(new Product(4, LocalDate.of(2025, 6, 20), "FAN", 5, 500));
        // trying to save another employee with id 01
        registerProductService.register(new Product(1, LocalDate.of(2026, 6, 20), "HDMI cable", 10, 80));

        System.out.println("Product with id 4:");
        Product product = findProductService.findById(4);

        if (product != null) {
            System.out.println(product);

            System.out.printf("\nShelf life of the %s: %d days\n", product.getName(), product.getShelfLifeInDays());

            product.applyPriceAdjustment(-0.1);
            product.setStockQuantity(300);

            System.out.println("\n" + product.getName() + " is 10% off and the stock has been updated");
            System.out.println(product);
        } else {
            System.out.println("There's no employee with id 4");
        }

        System.out.println("------------------------------------------------------------------------------------------------");
        System.out.println("All products saved:\n");
        System.out.println(repository.showAllProducts());
    }
}

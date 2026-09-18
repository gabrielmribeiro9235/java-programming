package br.com.gabriel.ifsp.exercises.polymorphism.zoo;

public class Wolf extends Animal {
    public Wolf(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println("Auuuuuu!");
    }

    public void run() {
        System.out.println("Wolf is running!");
    }
}

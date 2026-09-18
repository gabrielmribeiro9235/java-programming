package br.com.gabriel.ifsp.exercises.polymorphism.zoo;

abstract class Animal {
    private final String name;

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void makeSound();
}

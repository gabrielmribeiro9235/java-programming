package br.com.gabriel.ifsp.exercises.polymorphism.zoo;

public class Lion extends Animal {
    public Lion(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println("Rrrrrwaarrr!");
    }

    public void run() {
        System.out.println("Lion is running!");
    }
}

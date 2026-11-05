package br.com.gabriel.ifsp.exercises.polymorphism.zoo;

public class Zoo {
    private final Animal[] animals;

    private Zoo() {
        animals = new Animal[10];

        for (int i = 0; i < animals.length; i++) {
            if (i < 4) {
                animals[i] = new Owl("Owl " + (i + 1));
            } else if (i < 7) {
                animals[i] = new Lion("Lion " + (i + 1));
            } else {
                animals[i] = new Wolf("Wolf " + (i + 1));
            }
        }
    }

    public static Zoo createZoo() {
        return new Zoo();
    }

    public void makeTheAnimalsMakeSound() {
        for (Animal animal : animals) {
            animal.makeSound();
            if (animal instanceof Lion lion) {
                lion.run();
            } else if (animal instanceof Wolf wolf) {
                wolf.run();
            }
            System.out.println();
        }
    }
}

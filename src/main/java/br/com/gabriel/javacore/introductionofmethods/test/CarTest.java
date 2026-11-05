package br.com.gabriel.javacore.introductionofmethods.test;

import br.com.gabriel.javacore.introductionofmethods.domain.Car;

public class CarTest {
    public static void main(String[] args) {
        Car car = new Car();

        car.ride();

        double speed = car.accelerate(20, 80);

        System.out.println("\nCar speed: " + speed + " km/h");

        double kiloPerHorsePower = car.weightPerPower(400, 1200);

        if(kiloPerHorsePower == -1) {
            System.out.println("\nInvalid car weight");
        } else if(kiloPerHorsePower == -2) {
            System.out.println("\nInvalid car power");
        } else {
            System.out.println("\nPWR = " + kiloPerHorsePower + " Kg/Hp");
        }
    }
}

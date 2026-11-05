package br.com.gabriel.javacore.introductionofmethods.domain;

public class Car {
    public void ride() {
        System.out.println("Car is riding");
    }

    public double accelerate(double initialSpeed, double speedIncrementation) {
        return initialSpeed + speedIncrementation;
    }

    public double weightPerPower(double power, double weight) {
        if(weight <= 0) {
            return -1;
        }

        if(power <= 0) {
            return -2;
        }

        return weight / power;
    }
}

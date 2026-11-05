package br.com.gabriel.javacore.introductionofclasses.test;

import br.com.gabriel.javacore.introductionofclasses.domain.Person;

public class PersonTest {
    public static void main(String[] args) {
        Person person = new Person();

        person.name = "Gabriel";
        person.age = 19;
        person.gender = 'M';

        System.out.println("Name: " + person.name);
        System.out.println("Age: " + person.age);
        System.out.println("Gender: " + person.gender);
    }
}

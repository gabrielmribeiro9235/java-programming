package br.com.gabriel.ifsp.exercises.staticmembers;

public class Main {
    public static void main(String[] args) {
        String email = "exemplo@gmail.com";

        System.out.println(EmailValidator.isValid(email) ? "Valid" : "Invalid");
    }
}

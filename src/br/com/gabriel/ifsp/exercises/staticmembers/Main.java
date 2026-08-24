package br.com.gabriel.ifsp.exercises.staticmembers;

public class Main {
    public static void main(String[] args) {
        String email = "exemplo@gmail.com";

        System.out.println(EmailValidator.isValid(email) ? "Valid" : "Invalid");

        String sentence = "What do you want to do when she arrives?";

        System.out.println("The word \"do\" appears " + WordCounter.count(sentence, "do") + " times in the sentence " + "\"" + sentence + "\"");
    }
}

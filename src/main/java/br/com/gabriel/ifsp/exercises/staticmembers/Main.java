package br.com.gabriel.ifsp.exercises.staticmembers;

public class Main {
    public static void main(String[] args) {
        String email = "exemplo@gmail.com";

        System.out.println(EmailValidator.isValid(email) ? "Valid" : "Invalid");

        String sentence = "What do you want to do when she arrives?";

        System.out.println("The word \"do\" appears " + WordCounter.count(sentence, "do") + " times in the sentence " + "\"" + sentence + "\"");

        String variable = "variable";

        System.out.println(
            NamingConventions.isFollowingConvention(variable, NamingConventions.Conventions.VARIABLE) ?
            "\"" + variable + "\" is a valid name" :
            "\"" + variable + "\" is not a valide name"
        );

        System.out.println(NamingConventions.fromConstToVariable("AGE_TO_DRINK_BEER_IN_BRASIL"));
        System.out.println(NamingConventions.fromVariableToConst("ageToDrinkBeerInBrasil"));

        String identifier = "public";

        System.out.println(
            "\"" + identifier + "\" is " + (NamingConventions.isValidJavaIdentifier(identifier) ? "a valid" : "an invalid") + " identifier in Java"
        );
    }
}

package br.com.gabriel.ifsp.exercises.staticmembers;

public class WordCounter {
    public static int count(String sentence, String word) {
        String[] words = sentence.split(" ");

        int occurences = 0;

        for (String s : words) {
            if (s.equalsIgnoreCase(word)) {
                occurences++;
            }
        }

        return occurences;
    }
}

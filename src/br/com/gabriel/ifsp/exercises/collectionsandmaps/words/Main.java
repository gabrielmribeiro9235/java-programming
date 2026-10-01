package br.com.gabriel.ifsp.exercises.collectionsandmaps.words;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Type the words below (to stop, simply insert a blank line):");

        List<String> list = new ArrayList<>();
        Set<String> set = new TreeSet<>();
        Map<String, Integer> map = new HashMap<>();

        String reader = scanner.nextLine();

        while (!reader.isBlank()) {
            list.add(reader);

            set.add(reader);

            if (map.containsKey(reader)) {
                map.replace(reader, map.get(reader) + 1);
            } else {
                map.put(reader, 1);
            }

            reader = scanner.nextLine();
        }

        System.out.println("\nAll words typed (there may be repetitions):");
        System.out.println(String.join(", ", list));

        System.out.println("\nWords typed in alphabetical order (without repetition):");
        System.out.println(String.join(", ", set));

        StringJoiner occurrences = new StringJoiner(", ");

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            occurrences.add(entry.getKey() + ": " + entry.getValue());
        }

        System.out.println("\nNumber of occurrences of each word:");
        System.out.println(occurrences);
    }
}

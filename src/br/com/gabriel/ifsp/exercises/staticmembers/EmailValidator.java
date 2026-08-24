package br.com.gabriel.ifsp.exercises.staticmembers;

public class EmailValidator {
    public static boolean isValid(String email) {
        if (email == null) return false;

        email = email.trim();

        if (email.isEmpty()) return false;

        char[] characters = email.toCharArray();

        if (characters[0] == '@' || characters[characters.length - 1] == '@' || characters[0] == '.') {
            return false;
        }

        int numberOfAts = 0;
        int indexOfAt = -1;
        for (int i = 0; i < characters.length; i++) {
            if (characters[i] == '@') {
                numberOfAts++;
                indexOfAt = i;
            }
        }

        if (numberOfAts != 1) {
            return false;
        }

        for (int i = 1; i < characters.length; i++) {
            if (characters[i-1] == '.' && characters[i] == '.') {
                return false;
            }
        }

        if (email.substring(indexOfAt + 1).startsWith(".com")) {
            return false;
        }

        boolean endsWithDotComDotTwoLetters = false;
        if (characters.length >= 7) {
            endsWithDotComDotTwoLetters = true;
            char[] dotComDot = {'.', 'c', 'o', 'm', '.'};
            for (int i = 0; i < dotComDot.length; i++) {
                if (characters[characters.length - 7 + i] != dotComDot[i]) {
                    endsWithDotComDotTwoLetters = false;
                    break;
                }
            }
        }

        if (
            endsWithDotComDotTwoLetters &&
            (
                !Character.isLetter(characters[characters.length - 1]) ||
                !Character.isLetter(characters[characters.length - 2])
            )
        ) {
            return false;
        }

        return email.endsWith(".com") || endsWithDotComDotTwoLetters;
    }
}

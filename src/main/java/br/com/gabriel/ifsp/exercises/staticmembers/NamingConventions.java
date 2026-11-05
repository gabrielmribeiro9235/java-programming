package br.com.gabriel.ifsp.exercises.staticmembers;

public class NamingConventions {
    public enum Conventions { VARIABLE, CONSTANT, CLASS, METHOD }

    public static boolean isFollowingConvention(String name, Conventions convention) {
        if (name == null || !name.trim().equals(name)) return false;

        final boolean isLastLetterUpperCase = Character.isUpperCase(name.charAt(name.length() - 1));
        return switch (convention) {
            case VARIABLE, METHOD -> {
                if (Character.isUpperCase(name.charAt(0)) || isLastLetterUpperCase) yield false;

                char[] charArray = name.toCharArray();

                for (char c : charArray) {
                    if (!Character.isLetterOrDigit(c)) yield false;
                }

                for (int i = 0; i < charArray.length - 1; i++) {
                    if (Character.isUpperCase(charArray[i]) && Character.isUpperCase(charArray[i+1])) {
                        yield false;
                    }
                }

                yield true;
            }
            case CONSTANT -> name.toUpperCase().equals(name);
            case CLASS -> {
                if (Character.isLowerCase(name.charAt(0)) || isLastLetterUpperCase) yield false;

                char[] charArray = name.toCharArray();

                for (char c : charArray) {
                    if (!Character.isLetterOrDigit(c)) yield false;
                }

                for (int i = 0; i < charArray.length - 1; i++) {
                    if (Character.isUpperCase(charArray[i]) && Character.isUpperCase(charArray[i+1])) {
                        yield false;
                    }
                }

                yield true;
            }
        };
    }

    public static String fromConstToVariable(String name) {
        if (name == null || name.trim().isEmpty() || !isFollowingConvention(name, Conventions.CONSTANT)) return null;

        String[] words = name.split("_");

        words[0] = words[0].toLowerCase();
        for (int i = 1; i < words.length; i++) {
            words[i] = words[i].substring(0, 1).toUpperCase() + words[i].substring(1).toLowerCase();
        }

        return String.join("", words);
    }

    public static String fromVariableToConst(String name) {
        if (name == null || name.trim().isEmpty() || !isFollowingConvention(name, Conventions.VARIABLE)) return null;

        StringBuilder string = new StringBuilder();

        for (int i = 0; i < name.length(); i++) {
            if (Character.isUpperCase(name.charAt(i))) {
                string.append("_");
                string.append(name.toUpperCase().charAt(i));
            } else {
                string.append(name.toUpperCase().charAt(i));
            }
        }

        return string.toString();
    }

    public static boolean isValidJavaIdentifier(String name) {
        return (
            isFollowingConvention(name, Conventions.VARIABLE) ||
            isFollowingConvention(name, Conventions.CLASS) ||
            isFollowingConvention(name, Conventions.CONSTANT) ||
            isFollowingConvention(name, Conventions.METHOD)
        );
    }
}

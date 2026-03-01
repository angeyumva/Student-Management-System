import java.util.StringJoiner;
import java.util.regex.Pattern;

public class StringManipulation {

    // Convert a string to title case
    public static String toTitleCase(String input) {
        String[] words = input.split(" ");
        StringBuilder titleCase = new StringBuilder();
        for (String word : words) {
            if (word.length() > 0) {
                titleCase.append(Character.toUpperCase(word.charAt(0)));
                titleCase.append(word.substring(1).toLowerCase());
                titleCase.append(" ");
            }
        }
        return titleCase.toString().trim();
    }

    // Case-insensitive search
    public static boolean containsIgnoreCase(String str, String searchStr) {
        return Pattern.compile(Pattern.quote(searchStr), Pattern.CASE_INSENSITIVE)
            .matcher(str)
            .find();
    }

    // Split a string into an array
    public static String[] splitString(String str, String delimiter) {
        return str.split(delimiter);
    }

    // Get a substring
    public static String getSubstring(String str, int start, int end) {
        if (start < 0 || end > str.length() || start > end) {
            throw new IllegalArgumentException("Invalid start or end index.");
        }
        return str.substring(start, end);
    }

    // Concatenate two strings
    public static String concatenate(String str1, String str2) {
        return str1 + str2;
    }
}
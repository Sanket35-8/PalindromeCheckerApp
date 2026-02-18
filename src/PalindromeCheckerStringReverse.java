// File: PalindromeCheckerStringReverse.java
public class PalindromeCheckerStringReverse {

    public static void main(String[] args) {

        // Example string to check
        String word = "madam";

        // Reverse the string using a loop
        String reversed = "";
        for (int i = word.length() - 1; i >= 0; i--) {
            reversed = reversed + word.charAt(i);
        }

        // Check if original string and reversed string are equal
        if (word.equals(reversed)) {
            System.out.println(word + " is a Palindrome.");
        } else {
            System.out.println(word + " is NOT a Palindrome.");
        }

        // Program exits
    }
}

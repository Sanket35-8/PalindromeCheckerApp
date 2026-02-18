// File: PalindromeCheckerCharArray.java
public class PalindromeCheckerCharArray {

    public static void main(String[] args) {

        // Example string to check
        String word = "racecar";

        // Convert the string to a character array
        char[] chars = word.toCharArray();

        // Two-pointer approach
        int start = 0;
        int end = chars.length - 1;
        boolean isPalindrome = true;

        while (start < end) {
            if (chars[start] != chars[end]) {
                isPalindrome = false;
                break;
            }
            start++;
            end--;
        }

        // Display the result
        if (isPalindrome) {
            System.out.println(word + " is a Palindrome.");
        } else {
            System.out.println(word + " is NOT a Palindrome.");
        }

        // Program exits
    }
}

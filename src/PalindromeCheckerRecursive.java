public class PalindromeCheckerRecursive {

    // Method to check palindrome using recursion
    public static boolean isPalindrome(String str) {
        // Base condition: if string length is 0 or 1, it's a palindrome
        if (str.length() <= 1) {
            return true;
        }

        // Compare first and last characters
        if (str.charAt(0) != str.charAt(str.length() - 1)) {
            return false;
        }

        // Recursive call for substring excluding first and last characters
        return isPalindrome(str.substring(1, str.length() - 1));
    }

    // Main method to test
    public static void main(String[] args) {
        String[] testStrings = {"racecar", "hello", "level", "world"};

        for (String s : testStrings) {
            if (isPalindrome(s)) {
                System.out.println(s + " is a palindrome");
            } else {
                System.out.println(s + " is NOT a palindrome");
            }
        }
    }
}
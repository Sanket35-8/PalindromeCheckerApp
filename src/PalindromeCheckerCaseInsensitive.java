public class PalindromeCheckerCaseInsensitive {

    // Method to check palindrome ignoring case and spaces
    public static boolean isPalindrome(String str) {
        // Normalize: remove spaces and convert to lowercase
        String normalized = str.replaceAll("\\s+", "").toLowerCase();

        // Use standard palindrome check
        int start = 0;
        int end = normalized.length() - 1;

        while (start < end) {
            if (normalized.charAt(start) != normalized.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    // Main method to test
    public static void main(String[] args) {
        String[] testStrings = {
                "Racecar",
                "A man a plan a canal Panama",
                "Hello World",
                "Level"
        };

        for (String s : testStrings) {
            if (isPalindrome(s)) {
                System.out.println("\"" + s + "\" is a palindrome");
            } else {
                System.out.println("\"" + s + "\" is NOT a palindrome");
            }
        }
    }
}
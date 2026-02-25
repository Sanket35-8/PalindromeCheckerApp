public class PalindromeCheckerService {

    // Internal data structure for palindrome checking
    private String text;

    // Constructor
    public PalindromeCheckerService(String text) {
        this.text = text;
    }

    // Encapsulated method to check palindrome
    public boolean checkPalindrome() {
        // Normalize the string (optional: remove spaces and lowercase)
        String normalized = text.replaceAll("\\s+", "").toLowerCase();

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

    // Optional: Setter for new text
    public void setText(String text) {
        this.text = text;
    }

    // Optional: Getter for current text
    public String getText() {
        return text;
    }

    // Main method for quick testing
    public static void main(String[] args) {
        PalindromeCheckerService checker1 = new PalindromeCheckerService("Racecar");
        PalindromeCheckerService checker2 = new PalindromeCheckerService("Hello World");

        System.out.println(checker1.getText() + " -> " + checker1.checkPalindrome()); // true
        System.out.println(checker2.getText() + " -> " + checker2.checkPalindrome()); // false
    }
}
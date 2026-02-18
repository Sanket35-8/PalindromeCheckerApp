// File: PalindromeCheckerStack.java
import java.util.Stack;

public class PalindromeCheckerStack {

    public static void main(String[] args) {

        // Example string to check
        String word = "level";

        // Create a stack to store characters
        Stack<Character> stack = new Stack<>();

        // Push all characters into the stack
        for (int i = 0; i < word.length(); i++) {
            stack.push(word.charAt(i));
        }

        // Pop characters and build reversed string
        String reversed = "";
        while (!stack.isEmpty()) {
            reversed += stack.pop();
        }

        // Check if original string equals reversed string
        if (word.equals(reversed)) {
            System.out.println(word + " is a Palindrome.");
        } else {
            System.out.println(word + " is NOT a Palindrome.");
        }

        // Program exits
    }
}

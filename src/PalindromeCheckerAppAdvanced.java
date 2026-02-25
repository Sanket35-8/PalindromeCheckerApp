import java.util.Stack;
import java.util.ArrayDeque;
import java.util.Deque;

// Strategy interface
interface PalindromeStrategy {
    boolean isPalindrome(String text);
}

// Stack-based strategy
class StackStrategy implements PalindromeStrategy {
    @Override
    public boolean isPalindrome(String text) {
        String normalized = text.replaceAll("\\s+", "").toLowerCase();
        Stack<Character> stack = new Stack<>();

        for (char c : normalized.toCharArray()) {
            stack.push(c);
        }

        for (char c : normalized.toCharArray()) {
            if (c != stack.pop()) {
                return false;
            }
        }
        return true;
    }
}

// Deque-based strategy
class DequeStrategy implements PalindromeStrategy {
    @Override
    public boolean isPalindrome(String text) {
        String normalized = text.replaceAll("\\s+", "").toLowerCase();
        Deque<Character> deque = new ArrayDeque<>();

        for (char c : normalized.toCharArray()) {
            deque.addLast(c);
        }

        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) {
                return false;
            }
        }
        return true;
    }
}

// Context class for Strategy Pattern
class PalindromeContext {
    private PalindromeStrategy strategy;

    public PalindromeContext(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean checkPalindrome(String text) {
        return strategy.isPalindrome(text);
    }
}

// Main application
public class PalindromeCheckerAppAdvanced {
    public static void main(String[] args) {
        String[] testStrings = {
                "racecar",
                "A man a plan a canal Panama",
                "hello world",
                "level"
        };

        PalindromeContext context = new PalindromeContext(new StackStrategy());

        System.out.println("Using StackStrategy:");
        for (String s : testStrings) {
            System.out.println("\"" + s + "\" -> " + context.checkPalindrome(s));
        }

        // Switch strategy at runtime
        context.setStrategy(new DequeStrategy());
        System.out.println("\nUsing DequeStrategy:");
        for (String s : testStrings) {
            System.out.println("\"" + s + "\" -> " + context.checkPalindrome(s));
        }
    }
}
// UC13: Performance comparison using existing UC12 strategies

// Only define new strategy if needed
class StringReverseStrategy implements PalindromeStrategy {
    @Override
    public boolean isPalindrome(String text) {
        // Normalize string: remove spaces, lowercase
        String normalized = text.replaceAll("\\s+", "").toLowerCase();
        String reversed = new StringBuilder(normalized).reverse().toString();
        return normalized.equals(reversed);
    }
}

// Main class for performance comparison
public class PalindromePerformanceTest {

    public static void main(String[] args) {
        String testString = "A man a plan a canal Panama";

        // Reuse existing UC12 strategies
        PalindromeStrategy[] strategies = {
                new StackStrategy(),         // already defined in UC12
                new DequeStrategy(),         // already defined in UC12
                new StringReverseStrategy()  // new strategy for comparison
        };

        String[] strategyNames = {
                "StackStrategy",
                "DequeStrategy",
                "StringReverseStrategy"
        };

        // Reuse existing context class from UC12
        PalindromeContext context = new PalindromeContext(strategies[0]);

        System.out.println("Performance Comparison:");
        for (int i = 0; i < strategies.length; i++) {
            context.setStrategy(strategies[i]);

            long start = System.nanoTime();
            boolean result = context.checkPalindrome(testString);
            long end = System.nanoTime();
            long duration = end - start;

            System.out.println(strategyNames[i] + ": Result = " + result + ", Time = " + duration + " ns");
        }
    }
}git checkout palindrome-feature
git add src/PalindromePerformanceTest.java
git commit -m "Added UC13: Performance comparison using existing UC12 strategies"
git push origin palindrome-feature
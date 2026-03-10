import java.util.Scanner;
import java.util.Stack;
import java.util.ArrayDeque;

public class UseCase13PalindromeCheckerApp {

    // Algorithm 1: Simple reverse string
    public static boolean reverseStringCheck(String input) {
        String reversed = "";
        for (int i = input.length() - 1; i >= 0; i--) {
            reversed += input.charAt(i);
        }
        return input.equalsIgnoreCase(reversed);
    }

    // Algorithm 2: Stack-based check
    public static boolean stackCheck(String input) {
        Stack<Character> stack = new Stack<>();
        for (char c : input.toCharArray()) {
            stack.push(c);
        }
        for (char c : input.toCharArray()) {
            if (c != stack.pop()) {
                return false;
            }
        }
        return true;
    }

    // Algorithm 3: Deque-based check
    public static boolean dequeCheck(String input) {
        ArrayDeque<Character> deque = new ArrayDeque<>();
        for (char c : input.toCharArray()) {
            deque.addLast(c);
        }
        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a string to check palindrome:");
        String input = scanner.nextLine();

        // Algorithm 1 Timing
        long start1 = System.nanoTime();
        boolean result1 = reverseStringCheck(input);
        long end1 = System.nanoTime();
        long duration1 = end1 - start1;

        // Algorithm 2 Timing
        long start2 = System.nanoTime();
        boolean result2 = stackCheck(input);
        long end2 = System.nanoTime();
        long duration2 = end2 - start2;

        // Algorithm 3 Timing
        long start3 = System.nanoTime();
        boolean result3 = dequeCheck(input);
        long end3 = System.nanoTime();
        long duration3 = end3 - start3;

        // Display results
        System.out.println("\n=== Palindrome Results ===");
        System.out.println("Reverse String Check: " + result1 + " | Time: " + duration1 + " ns");
        System.out.println("Stack-based Check: " + result2 + " | Time: " + duration2 + " ns");
        System.out.println("Deque-based Check: " + result3 + " | Time: " + duration3 + " ns");

        scanner.close();
    }
}
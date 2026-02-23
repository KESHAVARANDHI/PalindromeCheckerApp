import java.util.Scanner;

public class UseCase10PalindromeCheckerApp {

    // Method to check palindrome (case-insensitive & space ignored)
    public static boolean isPalindrome(String input) {

        // Step 1: Normalize the string
        String normalized = input.replaceAll("\\s+", "").toLowerCase();

        // Step 2: Use two-pointer technique
        int left = 0;
        int right = normalized.length() - 1;

        while (left < right) {
            if (normalized.charAt(left) != normalized.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=== UC10: Case-Insensitive & Space-Ignored Palindrome Checker ===");
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        if (isPalindrome(input)) {
            System.out.println("Result: It is a Palindrome.");
        } else {
            System.out.println("Result: It is NOT a Palindrome.");
        }

        scanner.close();
    }
}

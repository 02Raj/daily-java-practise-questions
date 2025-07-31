package string;

public class PalindromeChecker {

    //  1. Two Pointer Approach (Using for loop)
    public static boolean isPalindromeTwoPointer(String str) {
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }

    // 2. Using StringBuilder reverse() method
    public static boolean isPalindromeStringBuilder(String str) {
        StringBuilder sb = new StringBuilder(str);
        String reversed = sb.reverse().toString();
        return str.equals(reversed);
    }

    // 3. Using toCharArray() and manual reverse
    public static boolean isPalindromeToCharArray(String str) {
        char[] chars = str.toCharArray();
        int left = 0;
        int right = chars.length - 1;

        while (left < right) {
            if (chars[left] != chars[right]) return false;
            left++;
            right--;
        }
        return true;
    }

    // 🔍 Main method to test all approaches
    public static void main(String[] args) {
        String input = "madam";

        System.out.println("Using Two Pointer: " + isPalindromeTwoPointer(input));          // true
        System.out.println("Using StringBuilder: " + isPalindromeStringBuilder(input));      // true
        System.out.println("Using toCharArray: " + isPalindromeToCharArray(input));          // true
    }
}

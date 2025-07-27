package string;

public class ReverseString {

    // ✅ Approach 1: Using StringBuilder
    // Interview Notes:
    // - StringBuilder is mutable, faster, and not thread-safe.
    // - Preferred in single-threaded environments.
    // - reverse() is an in-built efficient method.
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public static String reverseWithStringBuilder(String str) {
        return new StringBuilder(str).reverse().toString(); // toString() converts mutable StringBuilder to immutable String
    }

    // ✅ Approach 2: Using StringBuffer
    // Interview Notes:
    // - StringBuffer is similar to StringBuilder but thread-safe (synchronized).
    // - Slightly slower due to synchronization overhead.
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public static String reverseWithStringBuffer(String str) {
        return new StringBuffer(str).reverse().toString(); // toString() for final string output
    }

    // ✅ Approach 3: Using Two Pointer Technique on char array
    // Interview Notes:
    // - Convert string to char array using toCharArray() → gives mutable array of characters.
    // - Reverse using two pointers (left and right).
    // Time Complexity: O(n)
    // Space Complexity: O(n) for char array
    public static String reverseWithTwoPointer(String str) {
        char[] arr = str.toCharArray(); // Converts immutable string to mutable char array
        int left = 0, right = arr.length - 1;
        while (left < right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
        return new String(arr); // Convert char[] back to String
    }

    // ✅ Approach 4: Manual String Concatenation (Not Recommended for Large Strings)
    // Interview Notes:
    // - Strings are immutable, so each concatenation creates a new string → very inefficient.
    // - Use StringBuilder instead for large or repeated operations.
    // Time Complexity: O(n^2)
    // Space Complexity: O(n)
    public static String reverseManual(String str) {
        String reversed = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            reversed += str.charAt(i); // costly due to immutable string creation
        }
        return reversed;
    }

    // ✅ Approach 5: Using Recursion
    // Interview Notes:
    // - Elegant but not memory-efficient due to recursive stack.
    // - Can cause StackOverflowError for very large strings.
    // Time Complexity: O(n)
    // Space Complexity: O(n) due to recursion stack
    public static String reverseRecursive(String str) {
        if (str.isEmpty()) return str;
        return reverseRecursive(str.substring(1)) + str.charAt(0);
    }
    public static void main(String[] args) {
        String input = "hello";

        System.out.println("Original: " + input);
        System.out.println("Using StringBuilder: " + reverseWithStringBuilder(input));
        System.out.println("Using StringBuffer: " + reverseWithStringBuffer(input));
        System.out.println("Using Two Pointer: " + reverseWithTwoPointer(input));
        System.out.println("Using Manual Concatenation: " + reverseManual(input));
        System.out.println("Using Recursion: " + reverseRecursive(input));
    }
}

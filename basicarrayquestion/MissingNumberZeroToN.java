package basicarrayquestion;

public class MissingNumberZeroToN {

    public static int findMissing(int[] nums) {

        // Question:
        // Numbers are from 0 to n.
        // Array size = n.
        // One number is missing.

        // Example:
        // Input : {3,0,1}
        // Numbers should be: 0,1,2,3
        // Missing = 2

        // Since array contains n elements,
        // n = nums.length
        int n = nums.length;

        // Sum of numbers from 0 to n
        int expectedSum = n * (n + 1) / 2;

        // Find actual array sum
        int actualSum = 0;
        for (int num : nums) {
            actualSum += num;
        }

        // Missing number = Expected Sum - Actual Sum
        return expectedSum - actualSum;
    }

    public static void main(String[] args) {

        int[] arr = {3,0,1};

        System.out.println(findMissing(arr));
    }
}
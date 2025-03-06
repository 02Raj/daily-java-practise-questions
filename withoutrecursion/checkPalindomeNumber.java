package withoutrecursion;

public class checkPalindomeNumber {

    static boolean palindrome(int n) {
        // Step 1: Initialize a variable to store the reverse of the number
        int revNum = 0;

        // Step 2: Create a duplicate variable to store the original number
        int dup = n;

        // Step 3: For loop to reverse the number
        for (; n > 0; n /= 10) {
            // Step 4: Extract the last digit of the number
            int ld = n % 10;

            // Step 5: Build the reverse number by appending the last digit
            revNum = (revNum * 10) + ld;
        }

        // Step 6: Check if the original number is equal to its reverse
        return dup == revNum;
    }
    public static void main(String[] args) {
        int number = 4554;

        if(palindrome(number)){
            System.out.println(number + " is palindrome");
        }else{
            System.out.println(number +  " is not palindrome");
        }

    }
}

package Recursion;
public class ArmstrongNumber {
    public static boolean isArmstrong(int number) {
        int originalNumber = number;
        int numberOfDigits = String.valueOf(number).length();
        int sum = 0;

        for (int temp = number; temp != 0; temp /= 10) {
            int digit = temp % 10;
            sum += Math.pow(digit, numberOfDigits);
        }

        return sum == originalNumber;
    }

    public static void main(String[] args) {
        int num = 153;
        if (isArmstrong(num)) {
            System.out.println(num + " is an Armstrong number.");
        } else {
            System.out.println(num + " is not an Armstrong number.");
        }
    }
}


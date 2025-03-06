package withoutrecursion;

public class checkPalindrome {
    public static void main(String[] args) {
        String str = "121";


        boolean isPalindrome = checkPalindrome(str);

        if (isPalindrome) {
            System.out.println("The string \"" + str + "\" is a palindrome.");
        } else {
            System.out.println("The string \"" + str + "\" is not a palindrome.");
        }
    }

    public static boolean checkPalindrome(String str) {

        str = str.toLowerCase();


        boolean isPalindrome = true;


        for (int i = 0; i < str.length() / 2; i++) {

            if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {

                isPalindrome = false;
                break;
            }
        }

        return isPalindrome;
}
}
package Recursion;

public class ReverseWords {

    public static void main(String[] args) {
        String str = "DIVYANSH";
        String result = reverse(str);
        System.out.println("Reversed string: " + result);
    }

    public static String reverse(String str) {

        if (str == null || str.length() <= 1) {
            return str;
        }

        return reverse(str.substring(1)) + str.charAt(0);
    }

}

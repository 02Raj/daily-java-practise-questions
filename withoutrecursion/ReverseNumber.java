package withoutrecursion;

public class ReverseNumber {

    public static String reverseNumber(int n) {
     String numStr = Integer.toString(n);
     String reverseStr = "";

     for(int i = numStr.length() - 1; i>=0; i--){
         reverseStr+=numStr.charAt(i);
     }
            return reverseStr;
    }

    public static void main(String[] args) {
        int number = 12345;
        String result = reverseNumber(number);
        System.out.println("Reversed Number: " + result);
    }
}

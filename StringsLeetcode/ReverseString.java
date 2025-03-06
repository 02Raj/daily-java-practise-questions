package StringsLeetcode;

public class ReverseString {

    public static void main(String[] args) {
     String original = "DIVYANSH";
     char[] charArray = original.toCharArray();
     String revered = "";
     for(int i = charArray.length - 1; i > 0; i--){
         revered += charArray[i];
     }

        System.out.println("Reversed String:" + revered);
    }
}

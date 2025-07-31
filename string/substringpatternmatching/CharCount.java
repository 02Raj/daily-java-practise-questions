package string.substringpatternmatching;

public class CharCount {

    public static int countChar(String str,char target){
       int count = 0;

        for (char ch : str.toCharArray()) {
            if (ch == target) {
                count++;
            }
        }

        return count;

    }

    public static void main(String[] args) {
        String input = "hello world";
        char target = 'l';

        System.out.println("Count of '" + target + "': " + countChar(input, target));
    }
}

package string;

public class ReverseWords {

    public static String reverseWords(String s){
            s = s.trim();

            String[] words =  s.split("\\s+");

            StringBuilder result = new StringBuilder();
            for (int i = words.length - 1 ; i > 0; i--){
                result.append(words[i]);

                if (i != 0) result.append(" ");
            }

            return result.toString();
    }

    public static void main(String[] args) {
        String s = " the sky is blue ";

        System.out.println("Reversed: \"" + reverseWords(s) + "\"");
    }
}

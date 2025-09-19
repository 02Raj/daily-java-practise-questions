package string;

public class SubstringValueSum {

    public static void main(String[] args) {


        String s = "ABA";
        int total = 0;


        for (int i = 0 ; i < s.length(); i++){
            for (int j = i ; j < s.length(); j++){
                char lastChar  = s.charAt(j);
                int value = lastChar - 'A' + 1;
                total += value;
            }
            System.out.println("Total: " + total); // Output: 8
        }
    }
}

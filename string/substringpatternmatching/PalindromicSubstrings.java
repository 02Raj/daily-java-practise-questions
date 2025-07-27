package string.substringpatternmatching;

import java.util.HashSet;

public class PalindromicSubstrings {

    public static boolean isPalindrome(String s){
        int left = 0, right = s.length() - 1;

        while(left < right){
            if(s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }

        return true;
    }

    public static void findAllPalindromicSubstrings(String str){
        int n = str.length();
        HashSet<String> palindromes = new HashSet<>();

        for(int i = 0; i < n; i++){
            for(int j = i + 1; j <= n; j++){ // FIXED: changed j < n to j <= n
                String sub = str.substring(i, j);
                if(isPalindrome(sub)){
                    palindromes.add(sub);
                }
            }
        }

        System.out.println("All Palindromes:");
        for (String p : palindromes){
            System.out.println(p);
        }
    }

    public static void main(String[] args) {
        String input = "ababa";
        findAllPalindromicSubstrings(input);
    }
}

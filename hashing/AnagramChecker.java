package hashing;

import java.util.HashMap;

public class AnagramChecker {

    public static boolean areAnagrams(String str1, String str2){

        if(str1.length() != str2.length()){
            return false;
        }

        HashMap<Character,Integer> frequencyMap1 = new HashMap<>();
        HashMap<Character,Integer> frequencyMap2 = new HashMap<>();

        for(int i  = 0; i < str1.length(); i++){
            char ch = str1.charAt(i);
            frequencyMap1.put(ch, frequencyMap1.getOrDefault(ch,0) + 1);
        }

        for(int i = 0; i <  str2.length(); i++){
            char ch = str2.charAt(i);
            frequencyMap2.put(ch, frequencyMap2.getOrDefault(ch,0) + 1);
        }

         return frequencyMap1.equals(frequencyMap2);
    }

    public static void main(String[] args) {
        String str1 = "listen";
        String str2 = "silent";

        if (areAnagrams(str1, str2)) {
            System.out.println(str1 + " and " + str2 + " are anagrams.");
        } else {
            System.out.println(str1 + " and " + str2 + " are not anagrams.");
        }
    }
}

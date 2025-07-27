package string;

import java.util.HashSet;

public class RemoveDuplicatesFromString {

    public static String  removeDuplicate(String str){
        StringBuilder result = new StringBuilder();
        HashSet<Character> seen = new HashSet<>();

        for(char ch : str.toCharArray()){
            if(!seen.contains(ch)){
                seen.add(ch);
                result.append(ch);
            }
        }

        return result.toString();

    }
    public static void main(String[] args) {
        String input = "Programming";
        String output = removeDuplicate(input);

        System.out.println("original:" + input);
        System.out.println("output: " + output);
    }
}

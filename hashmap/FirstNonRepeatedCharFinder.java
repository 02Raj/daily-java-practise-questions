package hashmap;

import java.util.HashMap;
import java.util.Map;

public class FirstNonRepeatedCharFinder {


    public static char firstNonRepeatedChar(String str){

        Map<Character,Integer> charCounts = new HashMap<>();

        for (int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            charCounts.put(c, charCounts.getOrDefault(c,0) + 1);
        }


        for (int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            if (charCounts.get(c) == 1){
                return c ;
            }
        }

        return '\0';
    }

    public static void main(String[] args) {
        String str = "Divyansh Raj!";
        char firstNonRepeated = firstNonRepeatedChar(str);
        if (firstNonRepeated != '\0') {
            System.out.println("First non-repeated character: " + firstNonRepeated);
        } else {
            System.out.println("No non-repeated character found.");
        }
    }
}

package string;

import java.util.HashMap;
import java.util.Map;

public class FirstNonRepeatingChar {

    public static Character findFirstNonRepeatingWithArray(String str){
        int[] freq  = new int[256];

        for (char ch: str.toCharArray()){
            freq[ch]++;
        }
        for (char ch: str.toCharArray()){
            if(freq[ch] == 1) return ch;
        }

        return null;
    }
    public static Character findFirstNonRepeatingWithMap(String str){
        if (str == null || str.isEmpty()) return null;

        Map<Character,Integer> freqMap = new HashMap<>();

        for (char ch : str.toCharArray()){
            freqMap.put(ch,freqMap.getOrDefault(ch,0) + 1);
        }

        for (char ch : str.toCharArray()){
            if (freqMap.get(ch) == 1) {
                return ch;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        String input = "aabbcde";
        System.out.println("Using Array: " + findFirstNonRepeatingWithArray(input));
        System.out.println("Using HashMap: " + findFirstNonRepeatingWithMap(input));
    }
}

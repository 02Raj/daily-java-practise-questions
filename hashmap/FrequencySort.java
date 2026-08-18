package hashmap;

import java.util.*;

public class FrequencySort {

    public static String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        List<Character> chars = new ArrayList<>(map.keySet());


        chars.sort((a, b) -> map.get(b) - map.get(a));


        StringBuilder ans = new StringBuilder();

        for (char ch : chars) {

            int frequency = map.get(ch);

            for (int i = 0; i < frequency; i++) {
                ans.append(ch);
            }
        }

        return ans.toString();
    }

    public static void main(String[] args) {

        String s = "tree";

        System.out.println(frequencySort(s));
    }
}
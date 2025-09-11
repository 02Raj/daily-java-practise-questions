package string;

import java.util.HashMap;
import java.util.Map;

public class CharCount {
    public static void main(String[] args) {
//        String text = "Java is powerful";
        String text = "Divyansh raj";

        // Convert string to lowercase aur spaces ignore kar do
        text = text.toLowerCase().replaceAll("\\s+", "");

        Map<Character, Integer> charCountMap = new HashMap<>();

        for (char ch : text.toCharArray()) {
            charCountMap.put(ch, charCountMap.getOrDefault(ch, 0) + 1);
        }

        // Print results
        for (Map.Entry<Character, Integer> entry : charCountMap.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}

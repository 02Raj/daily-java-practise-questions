package string;

import java.util.HashMap;
import java.util.Map;

public class WordCount {
    public static void main(String[] args) {
        String text = "Java is easy and Java is powerful";

        // Convert string to lowercase and split by spaces
        String[] words = text.toLowerCase().split("\\s+");

        // Use a HashMap to store word counts
        Map<String, Integer> wordCountMap = new HashMap<>();

        for (String word : words) {
            // Remove punctuation if needed
            word = word.replaceAll("[^a-zA-Z]", "");

            if (!word.isEmpty()) {
                wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
            }
        }

        // Print results
        for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
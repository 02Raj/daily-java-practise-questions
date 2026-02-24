package string;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class FrequencySort {

    /*
        ------------------------------------------------------------
        PROBLEM STATEMENT:
        Given a string, sort its characters in decreasing order
        based on their frequency. Characters with higher frequency
        should appear earlier. Same characters must stay together.

        Example:
        Input: "tree"
        Output: "eert"  (because 'e' appears 2 times)

        ------------------------------------------------------------
        INTUITION:
        1. First count how many times each character appears.
        2. Characters with higher frequency should come first.
        3. A Max-Heap (PriorityQueue in descending order) can give
           the highest-frequency character each time we poll().
        4. For each character, append it to output as many times
           as its frequency.

        ------------------------------------------------------------
        APPROACH:
        Step 1: Build a frequency map.
        Step 2: Push each (char, frequency) pair into a max-heap.
        Step 3: Continuously remove the highest-frequency pair and
                append its character 'count' times to result.
        Step 4: Return the final built string.

        ------------------------------------------------------------
        KEY TO REMEMBER:
        - Frequency calculation is O(n).
        - Heap sorting gives O(k log k), where k = unique chars.
        - Appending characters happens exactly n times.
        - Total time = O(n log n) in worst case.

        ------------------------------------------------------------
        TIME COMPLEXITY CALCULATION:
        1) Build freq map              → O(n)
        2) Insert k elements in heap   → O(k log k)
        3) Poll k times from heap      → O(k log k)
        4) Append characters n times   → O(n)
        Final TC = O(n + k log k + n) = O(n log n)

        ------------------------------------------------------------
        SPACE COMPLEXITY:
        - freq map   → O(n)
        - max heap   → O(n)
        - output     → O(n)
        Total SC = O(n)

        ------------------------------------------------------------
        SMALL DRY RUN (Input = "tree"):

        freq = { t=1, r=1, e=2 }

        maxHeap contains:
            ('e',2), ('t',1), ('r',1)

        Iteration 1:
            entry = ('e',2)
            append "ee"
            output = "ee"

        Iteration 2:
            entry = ('t',1)
            append "t"
            output = "eet"

        Iteration 3:
            entry = ('r',1)
            append "r"
            output = "eert"

        Final output = "eert"
        ------------------------------------------------------------
    */

    public static String frequencySort(String s) {

        // Step 1: Build frequency map
        HashMap<Character, Integer> freq = new HashMap<>();
        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        // Step 2: Max-Heap sorted by frequency (highest first)
        PriorityQueue<Map.Entry<Character, Integer>> maxHeap =
                new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());

        maxHeap.addAll(freq.entrySet());

        // Step 3: Build the result using StringBuilder
        StringBuilder sb = new StringBuilder();

        while (!maxHeap.isEmpty()) {

            // Remove the character with highest frequency
            Map.Entry<Character, Integer> entry = maxHeap.poll();
            char ch = entry.getKey();
            int count = entry.getValue();

            // Append this character 'count' times
            for (int i = 0; i < count; i++) {
                sb.append(ch);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "tree";
        String result = frequencySort(s);
        System.out.println(result);  // Output: "eert"
    }
}

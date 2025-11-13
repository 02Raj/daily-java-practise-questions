package basicarrayquestion;

import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveDuplicates {

    public static int[] removeDuplicates(int[] arr) {
        // LinkedHashSet -> removes duplicates and keeps order
        Set<Integer> unique = new LinkedHashSet<>();

        for (int num : arr) {
            unique.add(num); // duplicate automatically ignored
        }

        // Convert Set back to array
        int[] result = new int[unique.size()];
        int i = 0;
        for (int num : unique) {
            result[i++] = num;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 2, 4, 5, 1};

        int[] noDuplicates = removeDuplicates(arr);

        System.out.print("Array without duplicates: ");
        for (int n : noDuplicates) {
            System.out.print(n + " ");
        }
    }
}
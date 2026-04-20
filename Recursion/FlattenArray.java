package Recursion;

import java.util.*;

public class FlattenArray {

    public static void flatten(List<Object> input, List<Integer> result) {
        for (Object obj : input) {

            // agar number hai
            if (obj instanceof Integer) {
                result.add((Integer) obj);
            }
            // agar list hai
            else if (obj instanceof List<?>) {
                flatten((List<Object>) obj, result);
            }
        }
    }

    public static void main(String[] args) {

        List<Object> input = Arrays.asList(
                1, 2, 3,
                Arrays.asList(4, 5, 6,
                        Arrays.asList(7, 8,
                                Arrays.asList(10, 11)
                        )
                ),
                9
        );

        List<Integer> result = new ArrayList<>();

        flatten(input, result);

        System.out.println(result);
    }
}
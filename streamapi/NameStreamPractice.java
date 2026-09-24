package streamapi;

import java.util.Arrays;
import java.util.List;

public class NameStreamPractice {

    public static void main(String[] args) {

        List<String> names = Arrays.asList(
                "Rahul", "Amit", "Rohit", "Ankit", "Priya", "Ravi"
        );

        List<String> namesStartingWithR = names.stream()
                .filter(name -> name.startsWith("R")).map(String:: toUpperCase)
                .toList();

        System.out.println(
                "Names starting with R: " + namesStartingWithR
        );
    }
}
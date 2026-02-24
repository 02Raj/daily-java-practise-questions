package streamapi;

import java.util.Arrays;
import java.util.List;

public class AllUpperCase {

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("java", "spring", "boot");
        List<String> result = strings.stream().map(String :: toUpperCase).toList();
        System.out.println("result:" + result );
    }
}

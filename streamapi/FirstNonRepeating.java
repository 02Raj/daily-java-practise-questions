package streamapi;

import javax.swing.text.html.Option;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FirstNonRepeating {

    public static Optional<Character> firstNonRepeating(String str) {
        return str.chars()                          // 1) SOURCE: String -> IntStream (har char ka int code)
                .mapToObj(c -> (char) c)                // 2) M: int ko wapas Character bana do (boxing)
                .collect(Collectors.groupingBy(         // 3) G: char -> count ka map banao
                        Function.identity(),                //    key = khud char
                        LinkedHashMap::new,                 //    ⚠️ ORDER yaad rakhne ke liye (HashMap order bhool jata hai!)
                        Collectors.counting()               //    value = kitni baar aaya (Long)
                ))
                .entrySet().stream()                    // 4) Map ko wapas stream mein badlo
                .filter(e -> e.getValue() == 1)         // 5) F: sirf woh jo EK hi baar aaye
                .map(Map.Entry::getKey)                 // 6) entry se sirf char nikalo
                .findFirst();                           // 7) F: pehla mil gaya = jeet gaye (TERMINAL op)
    }

    public static void main(String[] args) {
        System.out.println(firstNonRepeating("swiss"));    // Optional[w]
        System.out.println(firstNonRepeating("aabbcc"));   // Optional.empty
    }
}
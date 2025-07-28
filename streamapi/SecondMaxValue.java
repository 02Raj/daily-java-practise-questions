package streamapi;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SecondMaxValue {
    public static void main(String[] args) {
        List<Integer> numbers =  Arrays.asList(10, 25, 5, 12, 5);

        int secondHighest = numbers.stream()
            .distinct() // duplicate hatao
            .sorted(Comparator.reverseOrder()) // descending sort
            .skip(1) // first (highest) ko skip karo
            .findFirst() // ab next highest milega
            .orElseThrow(() -> new RuntimeException("No second highest value"));

        System.out.println("Second Highest value: " + secondHighest);
}
}


/*stream() → list ko stream mein convert karta hai.

distinct() → duplicate values hataata hai.

sorted(Comparator.reverseOrder()) → list ko descending order mein sort karta hai.

skip(1) → pehla (sabse bada) element skip karta hai.

findFirst() → ab second highest milta hai.

orElseThrow() → agar list empty ho ya second highest na mile to exception throw karta hai.

Note:
Agar aap duplicates allow karte ho to distinct() hata sakte ho.

Agar aur bhi versions chahiye jaise:

3rd highest

Top N elements

Minimum / second minimum

To wo bhi sorted() + skip() ya limit() ke combination se nikal sakte hain.
Batao chahiye to!*/
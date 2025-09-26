package javainterview.java8.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
/*
📌 INTERVIEW STYLE NOTES (Easy Hinglish)

Q: What is Lambda Expression in Java 8?
👉 Lambda ek short form hai anonymous functions likhne ka.
   Matlab bina alag class banaye, ek chhoti function ko pass kar sakte ho.
   Ye mostly functional interfaces ke saath use hota hai.

Q: Use cases?
   ✅ Writing clean code in Threads (Runnable)
   ✅ Sorting (Comparator)
   ✅ Collections iteration (forEach)
   ✅ Streams (filter, map, reduce)
   ✅ Replacing boilerplate code

Q: Benefits?
   ✅ Less code, more readability
   ✅ Functional style programming in Java
   ✅ Easy to parallelize with Streams

Q: Drawbacks?
   ⚠️ Debugging stack traces tough ho jata hai
   ⚠️ Overuse → readability down ho sakti hai
   ⚠️ Newcomers ke liye confusing lagta hai
*/
public class LambdaDemo {

    public static void main(String[] args) {

        // 1️⃣ Runnable using Lambda
        Runnable task = () -> System.out.println("Running task in a thread using Lambda!");
        new Thread(task).start();

        // 2️⃣ Comparator using Lambda
        List<String> names = Arrays.asList("Divyansh", "Amit", "Raj", "Suman");
        names.sort((a, b) -> a.compareToIgnoreCase(b));
        System.out.println("Sorted Names: " + names);

        // 3️⃣ ForEach with Lambda
        names.forEach(n -> System.out.println("Hello, " + n));

        // 4️⃣ Filter + Map + Collect using Streams & Lambda
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> evenSquares = numbers.stream()
                .filter(n -> n % 2 == 0)     // filter even
                .map(n -> n * n)             // square
                .collect(Collectors.toList());
        System.out.println("Even Squares: " + evenSquares);

        // 5️⃣ Custom Functional Interface + Lambda
        MathOperation add = (a, b) -> a + b;
        MathOperation multiply = (a, b) -> a * b;

        System.out.println("Add: " + add.operate(5, 3));
        System.out.println("Multiply: " + multiply.operate(5, 3));
    }
}

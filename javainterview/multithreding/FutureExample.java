package javainterview.multithreding;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureExample {
    public static void main(String[] args) throws Exception {
        // Ek single thread executor bna rahe hain (sirf 1 thread chalega)
        ExecutorService executor = Executors.newSingleThreadExecutor();

        // submit() me Callable task bhej rahe hain jo result return karega
        // Yaha lambda diya hai jo 2 second wait karke 42 return karega
        Future<Integer> future = executor.submit(() -> {
            Thread.sleep(2000); // simulate long task
            return 42; // ye result future me store hoga
        });

        System.out.println("Task submitted... waiting for result");

        // future.get() result ko block karke wait karega jab tak task complete na ho
        Integer result = future.get();
        System.out.println("Result: " + result);

        // executor band karna zaroori hai warna program background me chalta rahega
        executor.shutdown();
    }
}

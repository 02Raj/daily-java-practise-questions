package javainterview.multithreding;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorExample {

    public static void main(String[] args) {
        // 3 threads ka pool bna rahe hain (FixedThreadPool)
        // Matlab max 3 tasks ek time par parallel chal sakte hain
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // submit() se ek Runnable task bheja
        // Runnable result return nahi karta (sirf kaam karta hai)
        executor.submit(() -> {
            // Current thread ka naam print ho raha hai
            System.out.println("Task running by " + Thread.currentThread().getName());
        });

        // Executor ko band kar diya (ab naye tasks accept nahi honge)
        executor.shutdown();
    }
}

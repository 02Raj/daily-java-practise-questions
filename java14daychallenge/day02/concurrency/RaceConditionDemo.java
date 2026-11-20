package java14daychallenge.day02.concurrency;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class RaceConditionDemo {

    private static int unsafeCount = 0;
    private static final AtomicInteger safeCount = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        int numberOfTasks = 1000;
        ExecutorService executor = Executors.newFixedThreadPool(10);
        CountDownLatch latch = new CountDownLatch(numberOfTasks);

        for (int i = 0; i < numberOfTasks; i++) {
            executor.submit(() -> {
                try {
                    unsafeCount++; // NOT atomic: read -> modify -> write
                    safeCount.incrementAndGet(); // Thread-safe via hardware-level CAS
                } finally {
                    latch.countDown();
                }
            });
        }

        latch.await();
        executor.shutdown();

        System.out.println("Expected count: " + numberOfTasks);
        System.out.println("Unsafe count (Race condition): " + unsafeCount);
        System.out.println("Safe count (AtomicInteger):    " + safeCount.get());
    }
}

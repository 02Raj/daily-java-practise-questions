package javainterview.scenariobased;

/*
Test Class with multiple threads
--------------------------------
*/
public class PaymentGatewaySimulation {

    public static void main(String[] args) {

        Account userAccount = new Account(1000); // initial balance 1000

        // Thread simulating a deposit transaction
        Thread t1 = new Thread(() -> {
            userAccount.deposit(500);
        }, "DepositThread");

        // Thread simulating a withdrawal transaction
        Thread t2 = new Thread(() -> {
            userAccount.withdraw(200);
        }, "WithdrawThread");

        // Start threads in parallel
        t1.start();
        t2.start();

        // Wait for threads to finish
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final balance: " + userAccount.getBalance());
    }
}

/*
Explanation:
-------------
1) synchronized ensures **one thread at a time** can enter deposit/withdraw methods.
2) This prevents race conditions and keeps balance accurate.
3) In a high-concurrency environment, you might prefer ReentrantLock or AtomicInteger.
4) Real-world systems also use DB transactions to guarantee **ACID properties**.

Key Takeaways:
---------------
- Always identify **shared resources** (like account balance) that need protection.
- Use thread-safe techniques in Java: synchronized, locks, atomics.
- Understand trade-offs: simplicity vs performance vs scalability.
*/
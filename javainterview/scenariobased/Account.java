package javainterview.scenariobased;

/*
===============================================================
Scenario-Based Java Interview Question: Payment Gateway System
===============================================================

Story Point:
--------------
You are building a Payment Gateway System where multiple users can perform
transactions (deposit/withdraw) on their account **simultaneously**.
You need to ensure that **user account balance remains accurate**
despite concurrent updates.

Problem Statement:
-------------------
- Multiple transactions are processed in parallel (multithreading).
- Each transaction can **read and write** the user’s account balance.
- Without proper handling, **race conditions** can occur.
  Example:
    Initial balance = 1000
    Thread 1 withdraws 100 -> reads 1000, writes 900
    Thread 2 deposits 50 -> reads 1000, writes 1050
  Expected final balance = 950
  Actual final balance without synchronization = 1050 (Incorrect!)

Solution Approach:
-------------------
We need to make balance updates **thread-safe**. Possible approaches:

1) synchronized methods/blocks
   - Ensure **one thread at a time** can update balance.
   - Easy to implement, safe for simple cases.

2) ReentrantLock
   - Provides **more flexible locking**.
   - Allows tryLock(), fairness policies, better for high concurrency.

3) AtomicInteger (Lock-free approach)
   - Fast and thread-safe for numeric updates.
   - Not suitable for complex multi-field updates.

4) Database Transactions
   - In real-world systems, DB ensures atomicity and isolation.
   - Use isolation levels like `SERIALIZABLE` or `REPEATABLE READ`.

Code Example with `synchronized`:
-----------------------------------
*/

class Account {
    private int balance;

    public Account(int balance) {
        this.balance = balance;
    }

    // Deposit money in a thread-safe manner
    public synchronized void deposit(int amount) {
        balance += amount;
        System.out.println(Thread.currentThread().getName() + " deposited " + amount + ", new balance: " + balance);
    }

    // Withdraw money in a thread-safe manner
    public synchronized void withdraw(int amount) {
        balance -= amount;
        System.out.println(Thread.currentThread().getName() + " withdrew " + amount + ", new balance: " + balance);
    }

    public synchronized int getBalance() {
        return balance;
    }
}
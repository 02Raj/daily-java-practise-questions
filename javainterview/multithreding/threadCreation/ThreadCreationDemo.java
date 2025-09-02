package javainterview.multithreding.threadCreation;

// ThreadCreationDemo.java
public class ThreadCreationDemo {
    public static void main(String[] args) {

        // 1. Using Thread class
        MyThreadExtends t1 = new MyThreadExtends();
        t1.start(); // start() -> run() method ko new thread pe execute karega

        // 2. Using Runnable interface
        Thread t2 = new Thread(new MyRunnableImpl());
        t2.start();
    }
}



package javainterview.multithreding.threadCreation;

public class MyRunnableImpl implements Runnable{
    @Override
    public void run() {
        System.out.println("Thread running using Runnable interface: " + Thread.currentThread().getName());
    }
}

package javainterview.multithreding.threadCreation;

public class MyThreadExtends extends Thread{

    @Override
    public void run() {
        System.out.println("Thread running using Thread class: " + Thread.currentThread().getName());
    }
}

package javainterview.multithreding.threadLifecycle;

public class MyThread extends  Thread{

    @Override
    public void run() {
        try {
            System.out.println("Thread is running...");
            Thread.sleep(1000); // Thread TIMED_WAITING me jayega
            synchronized (this) {
                wait(); // Thread WAITING me chala jayega
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
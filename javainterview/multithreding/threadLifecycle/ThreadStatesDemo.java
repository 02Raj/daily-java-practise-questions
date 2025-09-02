package javainterview.multithreding.threadLifecycle;

public class ThreadStatesDemo {

    public static void main(String[] args) throws InterruptedException {
        MyThread t1 = new MyThread();

        // 1. NEW
        System.out.println("State after creating thread: " + t1.getState());

        // 2. RUNNABLE
        t1.start();
        System.out.println("State after calling start(): " + t1.getState());

        // thoda wait karte hain taki thread SLEEP me chala jaye
        Thread.sleep(500);
        System.out.println("State while sleeping: " + t1.getState());

        // thoda aur wait karte hain taki wo WAITING me aa jaye
        Thread.sleep(1500);
        System.out.println("State after wait(): " + t1.getState());

        // ab thread ko notify karna hoga taki wo resume ho
        synchronized (t1) {
            t1.notify();
        }

        // ab thread ko khatam hone do
        t1.join();
        System.out.println("State after completion: " + t1.getState());
    }
}
package withoutrecursion;

public class DeadlockDemo {

    private static final Object Resource1 = new Object();
    private static final Object Resource2 = new Object();

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            synchronized (Resource1) {
                System.out.println("Thread 1: Resource 1 ko lock kiya");

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("Thread 1: Resource 2 ke liye wait kar raha hai");

                synchronized (Resource2) {
                    System.out.println("Thread 1: Resource 2 ko lock kiya");
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            synchronized (Resource2) {
                System.out.println("Thread 2: Resource 2 ko lock kiya");

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("Thread 2: Resource 1 ke liye wait kar raha hai");

                synchronized (Resource1) {
                    System.out.println("Thread 2: Resource 1 ko lock kiya");
                }
            }
        });

        thread1.start();
        thread2.start();
    }
}

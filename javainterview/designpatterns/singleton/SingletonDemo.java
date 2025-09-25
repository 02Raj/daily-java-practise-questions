package javainterview.designpatterns.singleton;

/**
 * 🔹 Definition:
 * Ensures only one object of a class exists in the whole application.
 *
 * 🔹 Use Cases:
 * ✅ Database connection pool (only 1 object needed)
 * ✅ Logger class (global logging)
 * ✅ Configuration manager
 *
 * 🔹 Drawbacks:
 * ❌ Not thread-safe (multiple threads can create multiple objects)
 * ❌ Hard to unit test (because of global state)
 *
 * 🔹 Interview Q&A:
 * Q: What is Singleton Pattern?
 * A: Singleton ensures only one object of a class is created and provides a global access point.
 *
 * Q: Where do you use it?
 * A: For DB connection pools, logger, caching, or configuration managers where single object is enough.
 *
 * Q: What is the drawback?
 * A: Basic Singleton is not thread-safe. Also, global state makes unit testing hard.
 */
public class SingletonDemo {
    private static SingletonDemo instance;

    private SingletonDemo() {} // private constructor

    public static SingletonDemo getInstance() {
        if (instance == null) {
            instance = new SingletonDemo();
        }
        return instance;
    }

    public void showMessage() {
        System.out.println("Singleton instance working!");
    }

    public static void main(String[] args) {
        SingletonDemo obj1 = SingletonDemo.getInstance();
        SingletonDemo obj2 = SingletonDemo.getInstance();
        System.out.println(obj1 == obj2); // true → only one instance
        obj1.showMessage();
    }
}

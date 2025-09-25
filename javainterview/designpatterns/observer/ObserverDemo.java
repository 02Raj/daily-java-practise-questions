package javainterview.designpatterns.observer;


/**
 * 🔹 Definition:
 * One-to-many relationship: when one object changes, all its observers are notified.
 *
 * 🔹 Use Cases:
 * ✅ Event handling (UI button clicks)
 * ✅ Stock market price updates
 * ✅ Messaging apps (notify all users)
 *
 * 🔹 Drawbacks:
 * ❌ Can cause performance issues if many observers
 * ❌ Hard to debug if chain of updates is long
 *
 * 🔹 Interview Q&A:
 * Q: What is Observer Pattern?
 * A: Observer allows one object (subject) to notify many observers when its state changes.
 *
 * Q: Real-world use?
 * A: Stock market apps (price update goes to all users), event listeners in UI.
 *
 * Q: Drawbacks?
 * A: Too many observers → performance issue, and debugging is hard.
 */
public class ObserverDemo {
    public static void main(String[] args) {
        ChatRoom chatRoom = new ChatRoom();

        Observer u1 = new User("Alice");
        Observer u2 = new User("Bob");

        chatRoom.join(u1);
        chatRoom.join(u2);

        chatRoom.sendMessage("Hello, everyone!");
    }
}

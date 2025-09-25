package javainterview.designpatterns.builder;

/**
 * 🔹 Definition:
 * Builder helps construct complex objects step by step instead of using many constructors.
 *
 * 🔹 Use Cases:
 * ✅ Car, Pizza with many optional parts
 * ✅ StringBuilder in Java
 *
 * 🔹 Drawbacks:
 * ❌ More code (builder class needed)
 * ❌ Overkill for simple objects
 *
 * 🔹 Interview Q&A:
 * Q: What is Builder Pattern?
 * A: Builder builds a complex object step by step. It avoids constructor telescoping problem.
 *
 * Q: Where is it useful?
 * A: When object has too many optional fields like Car(engine, color, wheels).
 *
 * Q: Drawbacks?
 * A: Requires extra builder class, not good for simple objects.
 */

public class BuilderDemo {
    public static void main(String[] args) {
        Car car = new Car.CarBuilder()
                .setEngine("V8 Engine")
                .setWheels(4)
                .setColor("Red")
                .build();
        System.out.println(car);
    }
}

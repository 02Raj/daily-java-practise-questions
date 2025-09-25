package javainterview.designpatterns.factory;


/**
 * 🔹 Definition:
 * Factory hides the object creation logic and decides which object to return.
 *
 * 🔹 Use Cases:
 * ✅ Creating shapes (Circle, Rectangle, etc.)
 * ✅ UI Components (Button, Checkbox)
 * ✅ Parser libraries (XML, JSON, CSV)
 *
 * 🔹 Drawbacks:
 * ❌ Adds extra code (factory class required)
 * ❌ Complex if too many product classes
 *
 * 🔹 Interview Q&A:
 * Q: What is Factory Pattern?
 * A: Factory Pattern hides object creation and provides a common interface to create different objects.
 *
 * Q: Where is it useful?
 * A: When object creation is complex or when multiple sub-classes exist (shapes, parsers).
 *
 * Q: Drawbacks?
 * A: Too many factory classes can make the code hard to manage.
 */

public class FactoryDemo {

    public static void main(String[] args) {
        ShapeFactory factory = new ShapeFactory();
        Shape circle = factory.getShape("circle");
        circle.draw();

        Shape rectangle = factory.getShape("rectangle");
        rectangle.draw();
    }
}

package javainterview.designpatterns.factory;

// Factory
class ShapeFactory {
    public Shape getShape(String type) {
        if (type.equalsIgnoreCase("circle")) return new Circle();
        else if (type.equalsIgnoreCase("rectangle")) return new Rectangle();
        return null;
    }
}
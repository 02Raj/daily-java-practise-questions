package oops.classbasics;

public class Circle extends Shape {

    double radius;

    Circle(double length, double width,  double radius) {
        super(length, width);
        this.radius = radius;
    }
    @Override
    void area(){
        System.out.println("Area Of circle is: " + Math.PI * radius * radius  );
    }

    public static void main(String[] args) {
        Circle area = new Circle(5,4,3);
        area.area();
    }
}

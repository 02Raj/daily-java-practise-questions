package oops.classbasics;

public class Rectangle extends Shape {

    double length;
    double width;

    Rectangle(double length, double width){
        super(length,width);
        this.length = length;
        this.width = width;
    }

    @Override
    void area(){
        System.out.println("Area Of rectangle is: " + length * width);
    }

    public static void main(String[] args) {
        Rectangle area = new Rectangle(5,4);
        area.area();
    }
}

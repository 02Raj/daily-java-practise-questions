package javainterview.oops.inheritance;

public class Car {
    private Engine engine = new Engine();

    void drive(){
        engine.start();
        System.out.println("Car is Moving");
    }
}

package oops.classbasics;

public class Bike extends Vehical{
    String brand;
    int modelYear;

    Bike(String brand, int modelYear){
        super(brand,modelYear);
        this.brand = brand;
        this.modelYear = modelYear;
    }

    @Override
    void startEngine() {
        System.out.println("Engine Start with 200mph");
    }

    public static void main(String[] args) {
        Bike mybike = new Bike("HONDA" , 2023);
        mybike.startEngine();
    }
}

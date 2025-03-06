package oops.classbasics;

abstract class Vehical {

//    String brand;
    String brand = "BMW";
    int modelYear;

    Vehical(String brand, int modelYear){
        this.brand = brand;
        this.modelYear = modelYear;
    }

    void honk() {
        System.out.println("Beep Beep!");
    }
    // Abstract method
    abstract void startEngine();

    void showDetails() {
        System.out.println("Brand: " + brand + ", Model Year: " + modelYear);
    }

}



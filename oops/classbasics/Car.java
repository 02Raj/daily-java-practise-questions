package oops.classbasics;

public class Car extends Vehical implements Features,MusicSystem {
    String brand;
    int modelYear;
    int fuelCapacity;
    int currentFuelLevel;
    String model = "Corolla";

    Car(String brand ,int modelYear,int fuelCapacity,int currentFuelLevel,String model){
        super(brand,modelYear);
        this.brand = brand;
        this.modelYear = modelYear;
        this.fuelCapacity = fuelCapacity;
        this.currentFuelLevel = currentFuelLevel;
        this.model = model;
    }

    @Override
    void startEngine(){
        System.out.println("Car engine started! 🚗💨");
    }
    void displayShowDetails(){
        System.out.println("Brand:" + brand);
        System.out.println("Model Year:" + modelYear);
        System.out.println("fuel capacity:" + fuelCapacity);
        System.out.println("current fuel capacity:" + currentFuelLevel);

    }

    void refuel(int fuel) {
        // Fuel add karna hai, lekin capacity se zyada nahi
        if(currentFuelLevel + fuel > fuelCapacity){
            System.out.println("Fuel tank full! Maximum capacity reached.");
            currentFuelLevel = fuelCapacity;
        } else {
            currentFuelLevel += fuel;
            System.out.println("Refueled " + fuel + " liters. Current Fuel Level: " + currentFuelLevel);
        }
    }

    void drive(int distance) {
        // Distance ke hisaab se fuel kam karna hai
        // Agar fuel 0 ho gaya toh "Fuel Empty" print karna hai
        if (currentFuelLevel == 0){
            System.out.println("Fuel Empty! Please Refuel.");
            return;
        }

        if (distance > currentFuelLevel){
            System.out.println("Not enough fuel! You can drive only " + currentFuelLevel + " km.");
            currentFuelLevel = 0;
        }else{
          currentFuelLevel -= distance;
          System.out.println("Drove " + distance + " km. Fuel Remaining: " + currentFuelLevel);
        }
    }

    void checkFuelStatus() {
        if (currentFuelLevel < 10) {
            System.out.println("Fuel Level: " + currentFuelLevel + " - Low Fuel! Please refuel soon.");
        } else {
            System.out.println("Fuel Level: " + currentFuelLevel + " - Enough fuel.");
        }
    }

       @Override
       public void changeGear(int gear) {
     if (gear >= 1 && gear <= 5){
         System.out.println("Gear changed to: " + gear);
     } else {
         System.out.println("Invalid gear! Please select between 1 to 5.");
     }
    }

    @Override
    public void numberOfSeats(int seats) {
        System.out.println("Number of seats in " + brand + ": " + seats);
    }

    @Override
    public void playMusic() {
        System.out.println("Playing music...");
    }
    void displayCar() {
        System.out.println("Brand: " + brand);  // Inherited from Vehicle
        System.out.println("Model: " + model);
    }
    public static void main(String[] args) {
        Car mycar = new Car("Honda",2022,50,10,"Corolla");
        mycar.displayShowDetails();
        mycar.drive(5);
        mycar.refuel(20);
        mycar.drive(30);
        mycar.drive(10);
        mycar.checkFuelStatus();
        mycar.changeGear(3);
        mycar.startEngine();
        mycar.showDetails();
        mycar.numberOfSeats(4);
        mycar.displayCar();
        mycar.honk();
    }
}

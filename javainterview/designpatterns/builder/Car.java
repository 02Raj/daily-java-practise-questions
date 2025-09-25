package javainterview.designpatterns.builder;

public class Car {
    private String engine;
    private int wheels;
    private String color;

    private Car(CarBuilder builder) {
        this.engine = builder.engine;
        this.wheels = builder.wheels;
        this.color = builder.color;
    }


    static class CarBuilder {
        private String engine;
        private int wheels;
        private String color;

        public  CarBuilder setEngine(String engine){
           this.engine = engine;
           return this;
       }

        public  CarBuilder setWheels(int wheels){
           this.wheels = wheels;
           return this;
       }

        public  CarBuilder setColor(String color){
            this.color = color;
            return this;
        }

        public Car build() {
            return new Car(this);
        }
    }
}

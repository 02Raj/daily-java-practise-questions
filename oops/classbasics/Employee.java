package oops.classbasics;

public class Employee extends Person{

    double salary;

    Employee(String name,int age, double salary){
        super(name,age);
        this.salary = salary;
    }

    void displayEmployeeInfo() {
        displayPersonInfo();
        System.out.println("Salary: $" + salary);
    }

    @Override
    void greet() {
        System.out.println("Hello , my name is: " + name);
    }

    public static void main(String[] args) {
        Employee emp = new Employee("Mohit",25,30);
        emp.displayEmployeeInfo();
        emp.greet();
    }
}

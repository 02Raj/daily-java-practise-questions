package oops.classbasics;



//Chaining Constructors
//Write a Java program to create a class called Student with instance variables studentId,
// studentName, and grade. Implement a default constructor and a parameterized constructor that takes all three
// instance variables. Use constructor chaining to initialize the variables. Print the values of the variables.
public class Student {
    String studentId;
    String studentName;
    String grade;

    // Default Constructor (calls parameterized constructor with default values)
    public Student() {
        this("N/A", "Unknown", "N/A"); // Constructor Chaining
    }

    // Parameterized Constructor
    public Student(String studentId, String studentName, String grade) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.grade = grade;
    }

    // Method to print student details
    public void display() {
        System.out.println("Student ID: " + studentId + ", Name: " + studentName + ", Grade: " + grade);
    }

    public static void main(String[] args) {
        Student student1 = new Student(); // Calls default constructor
        Student student2 = new Student("1", "MOHIT", "A");

        System.out.println("Student 1 Details:");
        student1.display();

        System.out.println("Student 2 Details:");
        student2.display();
    }
}

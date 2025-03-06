package oops;

public class Student extends Person{

    String name;
    int age;
    int rollno;

   // static String school = "XYZ School";

    static String school;

    final String country = "India";
    public Student(String name, int age, int rollno) {
//       this.name = name;
//       this.age = age;
        super(name,age);
       this.rollno = rollno;
    }

    static{
        System.out.println("static block excuted");
        school = "xyz school";
    }


    public void displayCountry(){
        System.out.println("Country: " + country);
    }

    public Student() {
        super("unknown",4);
        this.age = 25;
        this.rollno = 25;
    }

    void show(){
        System.out.println("Hello form show method");
    }

    void show(int times){
        for (int i = 0; i < times; i++) {
            System.out.println("Hello from show method: " + (i + 1));
        }

    }

    void display(){
        this.show();
        System.out.println("Hello from display method");
    }

    public void showInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("School name: " + school);
    }

    public static void main(String[] args) {
        Student defaultStudent = new Student();


        Student std = new Student("Alex",24,24);

        // Displaying the student's details (Parameterized constructor)
        System.out.println("Name: " + std.name);
        System.out.println("Age: " + std.age);
        System.out.println("Roll No: " + std.rollno);


        // Displaying the student's details (Non-parameterized constructor)
        System.out.println("Name: " + defaultStudent.name);
        System.out.println("Age: " + defaultStudent.age);
        System.out.println("Roll No: " + defaultStudent.rollno);

        System.out.println("School: " + school);

        std.show(3);
        std.display();

        std.showInfo();

        std.displayCountry();

    }

}

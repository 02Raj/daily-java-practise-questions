package javainterview.Serialization;

import java.io.FileOutputStream;
import java.io.ObjectInputFilter;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Employee implements Serializable {
    private String name;
    private int age;

    public Employee(String name, int age){
        this.name = name;
        this.age = age;
    }


    public static void main(String[] args) {
        try {
            // Object create
            Employee emp = new Employee("Divyansh", 25);

            // Serialize object -> file mein likhna
            FileOutputStream fos = new FileOutputStream("employee.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(emp);
            oos.close();
            fos.close();

            System.out.println("✅ Object serialized successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

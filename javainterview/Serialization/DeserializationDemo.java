package javainterview.Serialization;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class DeserializationDemo {
    public static void main(String[] args) {
        try {
            // File se object wapas lana
            FileInputStream fis = new FileInputStream("employee.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);

            Employee emp = (Employee) ois.readObject();
            ois.close();
            fis.close();

            System.out.println("✅ Object deserialized successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

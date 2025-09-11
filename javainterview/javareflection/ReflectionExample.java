package javainterview.javareflection;

import java.lang.reflect.*;

public class ReflectionExample {
    public static void main(String[] args) throws Exception {
        // Class ka reference lena
        Class<?> clazz = Class.forName("Person");

        // Object create karna
        Object obj = clazz.getDeclaredConstructor().newInstance();

        // Private field ko access karna
        Field field = clazz.getDeclaredField("name");
        field.setAccessible(true); // private ko todne ka tareeka
        field.set(obj, "Raj");

        // Method call karna
        Method method = clazz.getDeclaredMethod("sayHello");
        method.invoke(obj); // Output: Hello Raj
    }
}


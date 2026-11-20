package java14daychallenge.day02.initialization;

class Parent {
    static int parentStatic = print("1. Parent static variable initialized");

    static {
        System.out.println("2. Parent static block executed");
    }

    int parentInstance = print("4. Parent instance variable initialized");

    {
        System.out.println("5. Parent instance init block executed");
    }

    Parent() {
        System.out.println("6. Parent constructor executed");
    }

    static int print(String msg) {
        System.out.println(msg);
        return 10;
    }
}

class Child extends Parent {
    static int childStatic = print("3. Child static variable initialized");

    static {
        System.out.println("3b. Child static block executed");
    }

    int childInstance = print("7. Child instance variable initialized");

    {
        System.out.println("8. Child instance init block executed");
    }

    Child() {
        System.out.println("9. Child constructor executed");
    }
}

public class InitializationDemo {
    public static void main(String[] args) {
        System.out.println("--- Starting main() ---");
        System.out.println("\n--- First Object Creation: new Child() ---");
        Child c1 = new Child();

        System.out.println("\n--- Second Object Creation: new Child() ---");
        Child c2 = new Child();
    }
}

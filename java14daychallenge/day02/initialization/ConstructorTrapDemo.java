package java14daychallenge.day02.initialization;

class ParentTrap {
    ParentTrap() {
        System.out.println("[Step 1] Parent constructor running. Calling print()...");
        print();
        System.out.println("[Step 2] Parent constructor finished.");
    }

    void print() {
        System.out.println("Parent print");
    }
}

class ChildTrap extends ParentTrap {
    int value = 100; // Will initialize ONLY AFTER ParentTrap() finishes!

    ChildTrap() {
        System.out.println("[Step 3] Child constructor running. value is now: " + value);
    }

    @Override
    void print() {
        System.out.println("Child print: " + value);
    }
}

public class ConstructorTrapDemo {
    public static void main(String[] args) {
        System.out.println("--- Creating new ChildTrap() ---");
        new ChildTrap();
    }
}

package collectionFramework.arrayListExample;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class ArrayListExample {

    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();

        names.add("Mohit");
        names.add("Rudra");
        names.add("Pankaj");
        names.add("Divyansh");

        System.out.println("name of index[0]:  " + names.get(0));


        names.set(1, "sheetal sir");

        System.out.println("name of index[0]:  " + names.get(1));

        for (int i = 0; i < names.size(); i++){
            System.out.println(names.get(i));
        }

        if (names.contains("Mohit")) {
            System.out.println("Mohit is list mein hai");
        }

        names.remove("Mohit");

        Collections.sort(names);

        System.out.println(names);

        System.out.println("sorted names: "  + names);
    }
}

package hashing;

import java.util.*;

public class HashExample {
    public static void main(String[] args) {
       /* HashSet<Integer> numbers = new HashSet<>();
        numbers.add(10);
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);

        System.out.println("HashSet elements: " + numbers);*/

      /*  HashMap<String,Integer> studentMarks =  new HashMap<>();
        studentMarks.put("Aman",30);
        studentMarks.put("Amit",25);
        studentMarks.put("Nitesh",20);
        studentMarks.put("Aman",50);

        System.out.println("Student Marks: " + studentMarks);
        System.out.println("Marks of Aman: " + studentMarks.get("Aman"));*/



/*        📌 🔥 Short Notes (For Easy Revision)
        1️⃣ HashMap does not maintain order, so sorting is required.
        2️⃣ Convert HashMap → List of Entries (Map.Entry) to allow sorting.
        3️⃣ Use entryList.sort(Map.Entry.comparingByValue()) to sort by values.
        4️⃣ Use LinkedHashMap to store sorted entries & maintain order.
        5️⃣ Time Complexity: Sorting O(n log n), Iteration O(n), Total: O(n log n).

✅ This approach works well for sorting a HashMap by values efficiently! 🚀🔥*/
        HashMap<String,Integer> empSalries =  new HashMap<>();
        empSalries.put("1",30);
        empSalries.put("2",25);
        empSalries.put("3",20);
        empSalries.put("4",50);

        System.out.println("employee salries with id: " + empSalries);

        // 🔹 Step 2: Convert HashMap into a List of Entries (Map.Entry stores key-value pairs)
        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(empSalries.entrySet());

        //  Sorting the List based on Salary (Value) in Ascending Order
        entryList.sort(Map.Entry.comparingByValue());
        //Sorting List by Salary (Value) in Descending Order
//        entryList.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));


        LinkedHashMap<Integer, Integer> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : entryList) {
            sortedMap.put(Integer.valueOf(entry.getKey()), entry.getValue()); // Adding sorted entries to LinkedHashMap
        }

        // 🔹 Step 5: Print Sorted Employee Salaries
        System.out.println("Sorted Employee Salaries by Value (Ascending): " + sortedMap);
    }
}

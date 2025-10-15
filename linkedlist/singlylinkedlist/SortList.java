package linkedlist.singlylinkedlist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
🔹 Problem Statement:
---------------------
You are given the head of a singly linked list.
Sort the list in ascending order and return its head.

Example:
Input:  head = [4,2,1,3]
Output: [1,2,3,4]

🔹 Intuition:
-------------
Linked List me direct sorting (like arrays) possible nahi hoti
kyunki usme random access (arr[i]) nahi hota.

So, brute force way:
1️⃣ Convert LinkedList → ArrayList
2️⃣ Sort using Collections.sort()
3️⃣ Rebuild a new sorted LinkedList from the sorted values.

🔹 Approach:
------------
Step 1: Traverse linked list and store all node values in an ArrayList.
Step 2: Sort the ArrayList (using built-in sort, O(n log n)).
Step 3: Create a new linked list from sorted elements.
Step 4: Return the new head (dummy.next).

🔹 Formula / Key Concept:
-------------------------
Linked List sorting by using array = Convert → Sort → Rebuild

🔹 Dry Run (Example: head = [4 → 2 → 1 → 3])
---------------------------------------------
arr = [4, 2, 1, 3]
sort(arr) → [1, 2, 3, 4]
Rebuild → 1 → 2 → 3 → 4
Output: [1, 2, 3, 4]

🔹 Time Complexity (TC):
------------------------
O(n)   → to traverse and collect values
O(n log n) → to sort array
O(n)   → to rebuild linked list
✅ Total: O(n log n)

🔹 Space Complexity (SC):
-------------------------
O(n) → for ArrayList (extra space)

🔹 Key to Remember:
-------------------
✔️ Brute force method uses extra space (ArrayList)
✔️ Easy to implement but not optimal
✔️ Merge Sort on Linked List is optimal (O(1) extra space)
*/
public class SortList {

    // Main logic for sorting the linked list
    public ListNode sortList(ListNode head) {
        if (head == null) return null;

        // Step 1️⃣: Convert LinkedList -> ArrayList
        List<Integer> arr = new ArrayList<>();
        ListNode curr = head;
        while (curr != null) {
            arr.add(curr.data);
            curr = curr.next;
        }

        // Step 2️⃣: Sort the ArrayList
        Collections.sort(arr);

        // Step 3️⃣: Rebuild sorted LinkedList
        ListNode dummy = new ListNode(0);
        curr = dummy;
        for (int num : arr) {
            curr.next = new ListNode(num);
            curr = curr.next;
        }

        // Step 4️⃣: Return new head
        return dummy.next;
    }

    // Helper function to print Linked List
    public void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.data);
            if (curr.next != null) System.out.print(" -> ");
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        SortList sorter = new SortList();

        // Example Linked List: 4 -> 2 -> 1 -> 3
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);

        System.out.print("Original List: ");
        sorter.printList(head);

        // Sort the linked list
        ListNode sorted = sorter.sortList(head);

        System.out.print("Sorted List: ");
        sorter.printList(sorted);
    }
}

package linkedlist.singlylinkedlist;

/*
================================================================================
📘 Problem Statement:
Given the head of a singly linked list, delete the middle node and return the
head of the modified list.

⚡ Example:
Input:  [1, 3, 4, 7, 1, 2, 6]
Output: [1, 3, 4, 1, 2, 6]

Here, the middle node is 7 (4th node in 7 elements).
After deleting 7 → list becomes [1, 3, 4, 1, 2, 6]

--------------------------------------------------------------------------------
🎯 Real-World Story:
Imagine you’re maintaining a train of linked compartments.
Each compartment (node) is connected to the next.
You’re told to “remove the middle compartment” without breaking the train.

But — you can only move one step at a time (slow pointer),
and your helper (fast pointer) moves twice as fast.
By the time your helper reaches the last compartment,
you’ll exactlay be standing at the middle one! Perfect moment to detach it.
================================================================================
*/

/*
================================================================================
🧠 Intuition / Thinking Behind:
- We use two pointers:
    👉 `slow` moves one step at a time.
    👉 `fast` moves two steps at a time.
- When `fast` reaches the end → `slow` is at the middle.
- We also maintain a `prev` pointer (one step behind slow) to reconnect links.

📌 Key Idea:
    prev.next = slow.next
    (This skips the middle node.)

================================================================================
🔑 Key to Remember:
1️⃣ Fast moves 2 steps, Slow moves 1 step.
2️⃣ When Fast reaches end → Slow is middle.
3️⃣ Use `prev` to connect before and after middle.
4️⃣ Edge Case:
    - If only 1 node → return null (since that single node is middle).
================================================================================

🧮 Time Complexity: O(N)
🧮 Space Complexity: O(1)
================================================================================
*/

public class DeleteMiddle {

    // Function to delete middle node
    public ListNode deleteMiddle(ListNode head) {
        // 🧱 Base condition: if list is empty or has only one node
        if (head == null || head.next == null) return null;

        ListNode slow = head;   // moves 1 step
        ListNode fast = head;   // moves 2 steps
        ListNode prev = null;   // to store node before slow

        /*
         🔄 LOOP:
         Fast moves 2x speed of slow.
         When fast reaches end → slow at middle.
         prev tracks node before slow for deletion link.
        */
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // 💣 Delete the middle node by skipping it
        prev.next = slow.next;

        return head;
    }

    // Helper function to print linked list
    public static void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.data);
            if (curr.next != null) System.out.print(" -> ");
            curr = curr.next;
        }
        System.out.println();
    }

    // 🌟 DRY RUN EXAMPLE 🌟
    /*
     Input List: [1 → 3 → 4 → 7 → 1 → 2 → 6]
     Steps:
     --------------------------------------------------------------------------
     | Step | Slow | Fast | Prev | Explanation                                 |
     |------|------|------|-------|--------------------------------------------|
     | 1    | 1    | 1    | null | start                                       |
     | 2    | 3    | 4    | 1    | fast moves 2x                               |
     | 3    | 4    | 1    | 3    | move again                                  |
     | 4    | 7    | 6    | 4    | fast reaches end                            |
     | ✅    | stop | end  | 4    | slow at middle (7), prev=4                 |
     --------------------------------------------------------------------------

     Delete middle → link 4 → 1 (skipping 7)
     Final List: [1 → 3 → 4 → 1 → 2 → 6]
    */

    // Main function to test
    public static void main(String[] args) {
        // Create example list: [1, 3, 4, 7, 1, 2, 6]
        ListNode head = new ListNode(1,
                new ListNode(3,
                        new ListNode(4,
                                new ListNode(7,
                                        new ListNode(1,
                                                new ListNode(2,
                                                        new ListNode(6)))))));

        System.out.print("Original List: ");
        printList(head);

        // Delete middle
        DeleteMiddle dm = new DeleteMiddle();
        head = dm.deleteMiddle(head);

        System.out.print("After Deleting Middle: ");
        printList(head);
    }
}

/*
================================================================================
📚 Quick Recap Notes for Revision:
----------------------------------
✅ Technique: Slow & Fast Pointer (Tortoise & Hare)
✅ Middle Logic: Fast → 2x speed
✅ Deletion Logic: prev.next = slow.next
✅ Edge Case: One node → return null
✅ TC = O(N), SC = O(1)
================================================================================
*/

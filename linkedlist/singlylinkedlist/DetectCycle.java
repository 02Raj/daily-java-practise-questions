package linkedlist.singlylinkedlist;

/*
 * =========================
 * FIND START OF CYCLE IN LINKED LIST
 * =========================
 *
 * Problem Statement:
 *  - Given the head of a singly linked list, return the node where the cycle begins.
 *  - If no cycle exists, return null.
 *
 * Intuition:
 *  - First detect if a cycle exists using Floyd’s Tortoise & Hare algorithm.
 *  - When slow & fast meet, the distance from head to cycle start equals distance
 *    from meeting point to cycle start inside the loop.
 *  - Use two pointers to find entry point of cycle.
 *
 * Approach:
 * 1. Initialize slow = head, fast = head
 * 2. Detect cycle:
 *      while(fast != null && fast.next != null):
 *          slow = slow.next
 *          fast = fast.next.next
 *          if slow == fast → cycle exists → break
 * 3. If no cycle → return null
 * 4. Find cycle entry:
 *      entry = head
 *      while(entry != slow):
 *          entry = entry.next
 *          slow = slow.next
 * 5. Return entry → starting node of cycle
 *
 * Formula / Key Points:
 *  - Meeting point distance = k steps inside cycle
 *  - Distance from head to entry = distance from meeting to entry
 *  - After meeting, move one pointer to head, move both 1 step at a time
 *
 * Dry Run Example:
 *  Linked list: 1 -> 2 -> 3 -> 4 -> (back to 2)
 *  Step 1: Detect cycle → slow & fast meet at 3
 *  Step 2: Move entry from head, slow from meeting point
 *          entry: 1->2
 *          slow: 3->4->2
 *          they meet at 2 → start of cycle
 *
 * Time Complexity: O(n) → traverse list + loop traversal
 * Space Complexity: O(1) → no extra space
 *
 * Always Remember:
 *  - Use slow & fast pointers carefully
 *  - Break null condition first
 *  - To find cycle start, reset one pointer to head after meeting
 */

public class DetectCycle {

    // Method to detect starting node of cycle
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        // Step 1: Detect cycle using Floyd’s algorithm
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) { // meeting point
                break;
            }
        }

        // Step 2: If no cycle
        if (fast == null || fast.next == null) {
            return null;
        }

        // Step 3: Find entry point of cycle
        ListNode entry = head;
        while (entry != slow) {
            entry = entry.next;
            slow = slow.next;
        }

        return entry; // starting node of cycle
    }

    // Main method to test
    public static void main(String[] args) {
        DetectCycle obj = new DetectCycle();

        // 🔹 Linked list with cycle: 1 -> 2 -> 3 -> 4 -> (back to 2)
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n2; // cycle back to node with val 2

        ListNode cycleStart = obj.detectCycle(n1);

        if (cycleStart != null)
            System.out.println("Cycle starts at node with value: " + cycleStart.data);
        else
            System.out.println("No cycle detected.");

        // 🔹 Linked list without cycle: 10 -> 20 -> 30 -> null
        ListNode a1 = new ListNode(10);
        ListNode a2 = new ListNode(20);
        ListNode a3 = new ListNode(30);

        a1.next = a2;
        a2.next = a3;

        ListNode noCycle = obj.detectCycle(a1);

        if (noCycle != null)
            System.out.println("Cycle starts at node with value: " + noCycle.data);
        else
            System.out.println("No cycle detected.");
    }
}

/*
Expected Console Output:
Cycle starts at node with value: 2
No cycle detected.
*/

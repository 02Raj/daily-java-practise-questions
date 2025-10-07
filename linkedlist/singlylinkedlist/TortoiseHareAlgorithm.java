package linkedlist.singlylinkedlist;

/**
 *  Problem: Detect a cycle in a Linked List and find the starting node of that cycle.
 *
 *  Approach:
 *  Use Floyd’s Tortoise and Hare Algorithm (also called Cycle Detection Algorithm).
 *
 *  Intuition:
 *  - Use two pointers moving at different speeds.
 *  - If there is a cycle, the faster pointer (hare) will eventually meet the slower pointer (tortoise).
 *  - If there’s no cycle, the fast pointer will reach the end (null).
 *
 *  Algorithm (Step-by-Step):
 *  1. Initialize two pointers, slow and fast, both pointing to the head.
 *  2. Move slow by 1 step, and fast by 2 steps in each iteration.
 *  3. If at any point, slow == fast → cycle exists.
 *  4. If fast reaches null or fast.next == null → no cycle.
 *  5. Once a cycle is detected, reset slow to head.
 *  6. Move both slow and fast one step at a time.
 *  7. The point where they meet again is the start of the cycle.
 *
 *  Time Complexity: O(n)
 *  Space Complexity: O(1)
 *
 *  Example Use Case:
 *  Linked List: 1 → 2 → 3 → 4 → (points back to 2)
 *  Output:
 *     Has cycle: true
 *     Cycle starts at node with data: 2
 */
public class TortoiseHareAlgorithm {

    // Detect if a cycle exists in the Linked List
    public static boolean hasCycle(ListNode head) {

        // If list is empty, no cycle possible
        if (head == null) return false;

        // Initialize pointers
        ListNode slow = head; // moves 1 step
        ListNode fast = head; // moves 2 steps

        // Move both pointers until fast reaches end or both meet
        while (fast != null && fast.next != null) {
            slow = slow.next;       // move slow by 1
            fast = fast.next.next;  // move fast by 2

            // If both meet, cycle detected
            if (slow == fast) {
                return true;
            }
        }

        // If fast reaches null, no cycle
        return false;
    }

    // Find the starting node of the cycle (if it exists)
    public static ListNode detectCycleStart(ListNode head) {

        // Step 1: Check if cycle exists
        if (!hasCycle(head)) return null;

        // Step 2: Initialize pointers again
        ListNode slow = head;
        ListNode fast = head;

        // Step 3: Move both to find the meeting point inside the cycle
        do {
            slow = slow.next;
            fast = fast.next.next;
        } while (slow != fast); // They meet somewhere inside the loop

        // Step 4: Move slow to head and keep fast at meeting point
        // Move both one step at a time, they’ll meet at cycle start
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        // Step 5: Return the node where both meet again — start of cycle
        return slow;
    }

    public static void main(String[] args) {

        // Create linked list: 1 → 2 → 3 → 4
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        // Create a cycle: last node (4) points to node (2)
        head.next.next.next.next = head.next;

        // Check for cycle
        System.out.println("Has cycle: " + hasCycle(head));

        // Find starting node of the cycle
        ListNode cycleStart = detectCycleStart(head);
        if (cycleStart != null) {
            System.out.println("Cycle starts at node with data: " + cycleStart.data);
        }
    }
}

/**
 * Small Dry Run Example:
 *
 * Linked List:
 *  1 → 2 → 3 → 4
 *        ↑       ↓
 *        ← ← ← ←
 *
 * Step-by-step Movement:
 *
 * Step | Slow | Fast | Comment
 * -----|------|------|---------------------------------
 *  1   |  1   |  1   | Start at head
 *  2   |  2   |  3   | Slow +1, Fast +2
 *  3   |  3   |  2   | Fast jumps 3→4→2
 *  4   |  4   |  4   | Both meet → cycle exists
 *
 * Now to find start:
 *  - Move slow back to head (1)
 *  - Keep fast at meeting point (4)
 *  - Move both one step at a time:
 *       slow=2, fast=2 → meet at 2 → cycle start
 *
 * Output:
 *   Has cycle: true
 *   Cycle starts at node with data: 2
 *
 * Key Operations Used:
 *  1. Slow pointer movement (1 step)
 *  2. Fast pointer movement (2 steps)
 *  3. Loop detection via pointer meeting
 *  4. Reset slow to head for start detection
 */

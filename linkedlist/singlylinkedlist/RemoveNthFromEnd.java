package linkedlist.singlylinkedlist;

/**
 * Problem Statement:
 * -----------------
 * Given the head of a singly linked list, remove the n-th node from the end of the list
 * and return its head.
 *
 * Example:
 * Input:  1 -> 2 -> 3 -> 4 -> 5, n = 2
 * Output: 1 -> 2 -> 3 -> 5
 *
 * Approach:
 * ---------
 * 1. Brute Force (Two-pass):
 *    - First, count the total number of nodes in the linked list.
 *    - Then, move to (length - n)-th node and remove the next node.
 *    - Time Complexity: O(N + N) = O(N)
 *    - Space Complexity: O(1)
 *
 * 2. Optimal (One-pass, Two-pointer):
 *    - Use dummy node to simplify edge cases (like removing head)
 *    - Use fast and slow pointers:
 *      1. Move fast pointer n+1 steps ahead
 *      2. Move both fast and slow together until fast reaches the end
 *      3. Slow will be just before the node to delete
 *      4. Delete node: slow.next = slow.next.next
 *    - Time Complexity: O(N), Space Complexity: O(1)
 *
 * Key Intuition:
 * --------------
 * - Using a dummy node avoids handling head deletion separately.
 * - Fast pointer gap of n+1 ensures slow stops at the node before the target.
 * - Moving both fast and slow together keeps this relative gap.
 */

public class RemoveNthFromEnd {

    // Definition of singly linked list node
    public static class ListNode {
        int data;
        ListNode next;
        ListNode(int val) { data = val; next = null; }
    }

    /**
     * Brute Force approach - 2-pass solution
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {

        // Step 1: Create dummy node to handle edge cases
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // Step 2: Count total number of nodes
        int length = 0;
        ListNode current = head;
        while(current != null) {
            length++;
            current = current.next;
        }

        // Step 3: Move to the node just before the target
        ListNode prev = dummy; // Start from dummy
        for(int i = 0; i < length - n; i++) {
            prev = prev.next;
        }

        // Step 4: Skip the target node
        prev.next = prev.next.next;

        // Step 5: Return new head
        return dummy.next;
    }

    /**
     * Optimal approach - 1-pass solution using fast and slow pointers
     */
    public ListNode removeNthFromEndOptimal(ListNode head, int n) {

        // Step 1: Dummy node to simplify edge cases
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode fast = dummy;
        ListNode slow = dummy;

        // Step 2: Move fast pointer n+1 steps ahead
        // Why n+1? So that slow points to node BEFORE the one to remove
        for(int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        // Step 3: Move both pointers together until fast reaches end
        while(fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // Step 4: Remove the target node
        slow.next = slow.next.next;

        // Step 5: Return new head
        return dummy.next;
    }

    /**
     * Helper function to print linked list
     */
    public void printList(ListNode head) {
        ListNode temp = head;
        while(temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        RemoveNthFromEnd solution = new RemoveNthFromEnd();

        // Create linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.print("Original list: ");
        solution.printList(head);

        int n = 2; // Remove 2nd node from end

        // Using Brute Force
        head = solution.removeNthFromEnd(head, n);
        System.out.print("After removing " + n + "-th node from end (Brute Force): ");
        solution.printList(head);

        // Recreate original list for Optimal
        head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        // Using Optimal
        head = solution.removeNthFromEndOptimal(head, n);
        System.out.print("After removing " + n + "-th node from end (Optimal): ");
        solution.printList(head);
    }
}

/**
 * Time Complexity Analysis:
 * -------------------------
 * 1. Brute Force: O(N) + O(N) = O(N) (two passes)
 * 2. Optimal: O(N) (one pass with two pointers)
 *
 * Space Complexity Analysis:
 * --------------------------
 * Both approaches use O(1) extra space (dummy node does not count as extra memory)
 *
 * Key points to remember:
 * -----------------------
 * - Always use dummy node to handle edge cases like removing head
 * - For optimal, move fast pointer n+1 steps ahead, then move both pointers
 * - Slow will automatically point to node BEFORE the target
 * - Use slow.next = slow.next.next to remove the node safely
 *
 * Small Dry Run (Optimal):
 * -----------------------
 * List: 1 -> 2 -> 3 -> 4 -> 5, n=2
 * fast moves 3 steps: fast -> 3, slow -> dummy
 * Move together until fast=null:
 *   fast -> null, slow -> 3
 * Delete: slow.next = slow.next.next -> 4 removed
 * Result: 1 -> 2 -> 3 -> 5
 */

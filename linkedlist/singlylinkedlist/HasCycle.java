package linkedlist.singlylinkedlist;

/*
 * =========================
 * DETECT CYCLE IN LINKED LIST
 * =========================
 *
 * Problem Statement:
 *  - Given the head of a singly linked list, determine if the list has a cycle.
 *  - A cycle exists if some node can be reached again by continuously following next pointers.
 *
 * Intuition:
 *  - Use two pointers (Floyd’s Cycle Detection / Tortoise and Hare)
 *  - Slow moves 1 step, Fast moves 2 steps
 *  - If there is a cycle, slow and fast will eventually meet
 *  - If no cycle, fast will reach null
 *
 * Approach:
 * 1. Initialize slow = head, fast = head
 * 2. Iterate while fast != null && fast.next != null:
 *      - slow = slow.next
 *      - fast = fast.next.next
 *      - if slow == fast → cycle exists → return true
 * 3. If loop ends → fast reached null → no cycle → return false
 *
 * Formula / Key Points:
 *  - Slow moves 1 step, Fast moves 2 steps
 *  - Check equality inside loop
 *  - No extra space needed
 *
 * Dry Run Example 1 (no cycle):
 *  1 -> 2 -> 3 -> 4 -> null
 *  slow: 1→2→3→4
 *  fast: 1→3→null → no cycle → return false
 *
 * Dry Run Example 2 (with cycle):
 *  1 -> 2 -> 3 -> 4 -> (back to 2)
 *  slow: 1→2→3→4→2→...
 *  fast: 1→3→2→4→3→2→...
 *  slow meets fast → cycle detected → return true
 *
 * Time Complexity: O(n) → at most traverse all nodes
 * Space Complexity: O(1) → in-place, no extra space
 *
 * Always Remember:
 *  - Use Floyd’s cycle detection for O(1) space
 *  - Do not modify the linked list
 *  - Check null conditions carefully to avoid NullPointerException
 */

public class HasCycle {

    // Method to detect cycle in linked list
    public boolean hasCycle(ListNode head){

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;          // move slow by 1
            fast = fast.next.next;     // move fast by 2

            if(slow == fast){          // cycle detected
                return true;
            }
        }

        return false; // no cycle
    }

    // Main method to test
    public static void main(String[] args) {
        HasCycle obj = new HasCycle();

        // ✅ Linked List without cycle: 1 -> 2 -> 3 -> 4 -> null
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        System.out.println("List 1 has cycle? " + obj.hasCycle(node1)); // Expected: false

        // ✅ Linked List with cycle: 1 -> 2 -> 3 -> 4 -> (back to 2)
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n2; // creates cycle

        System.out.println("List 2 has cycle? " + obj.hasCycle(n1)); // Expected: true
    }
}

/*
Expected Console Output:
List 1 has cycle? false
List 2 has cycle? true
*/

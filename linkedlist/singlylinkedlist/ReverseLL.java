package linkedlist.singlylinkedlist;

/*
 * =========================
 * REVERSE SINGLY LINKED LIST
 * =========================
 *
 * Problem Statement:
 *  - Given the head of a singly linked list, reverse the list.
 *  - Return the new head of the reversed list.
 *
 * Intuition:
 *  - In a singly linked list, each node points only to next.
 *  - To reverse, we need to change the direction of next pointers.
 *  - Use three pointers: prev, curr, next to safely reverse the links.
 *
 * Approach:
 * 1. Initialize:
 *      prev = null
 *      curr = head
 * 2. Iterate while curr != null:
 *      - Store next node: next = curr.next
 *      - Reverse current pointer: curr.next = prev
 *      - Move prev forward: prev = curr
 *      - Move curr forward: curr = next
 * 3. Return prev → new head of reversed list
 *
 * Formula / Key Points:
 *  - Always save curr.next in temp (next) before changing curr.next
 *  - Move prev and curr pointers carefully to avoid losing nodes
 *  - prev at the end points to new head
 *
 * Dry Run Example:
 *  Original: 1 -> 2 -> 3
 *
 *  Step 1: prev=null, curr=1, next=2
 *          curr.next = prev → 1->null
 *          prev = 1, curr = 2
 *
 *  Step 2: prev=1, curr=2, next=3
 *          curr.next = prev → 2->1->null
 *          prev = 2, curr = 3
 *
 *  Step 3: prev=2, curr=3, next=null
 *          curr.next = prev → 3->2->1->null
 *          prev = 3, curr = null → done
 *
 * Time Complexity: O(n) → traverse all nodes once
 * Space Complexity: O(1) → in-place reversal, no extra space
 *
 * Always Remember:
 *  - Do not lose next node → store in temp variable
 *  - Update pointers in correct order: next → curr.next → prev → curr
 *  - prev is the new head at the end
 *
 */

public class ReverseLL {

    // Function to reverse the linked list
    public ListNode reverseList(ListNode head){
        ListNode prev = null;       // Step 1: previous node
        ListNode curr = head;       // Step 2: current node

        while(curr != null){
            ListNode next = curr.next; // Step 3: store next node
            curr.next = prev;          // Step 4: reverse pointer
            prev = curr;               // Step 5: move prev forward
            curr = next;               // Step 6: move curr forward
        }

        return prev; // Step 7: prev is new head
    }

    // Helper method to print the linked list
    public void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.data);
            if (temp.next != null) System.out.print(" -> ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Main method to test reverse
    public static void main(String[] args) {
        // Linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ReverseLL obj = new ReverseLL();

        System.out.println("Original Linked List:");
        obj.printList(head);

        // Reverse the list
        ListNode reversedHead = obj.reverseList(head);

        System.out.println("Reversed Linked List:");
        obj.printList(reversedHead);
    }
}

/*
Expected Console Output:
Original Linked List:
1 -> 2 -> 3 -> 4 -> 5
Reversed Linked List:
5 -> 4 -> 3 -> 2 -> 1
*/

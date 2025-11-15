package linkedlist.singlylinkedlist;

/**
 *  PROBLEM:
 * Reverse nodes of linked list in groups of size k.
 *
 *  INTUITION (Story):
 * Imagine the list is a line of people. We take k people at a time,
 * reverse their order, connect the line back, and repeat.
 *
 *  KEY TO REMEMBER:
 * - Reverse ONLY when you have k nodes.
 * - Use dummy node for safe pointer handling.
 * - Reversal uses: curr, prev, next → classic linked list reversal.
 *
 *  TIME COMPLEXITY (TC):
 * O(n)
 * → Because each node is visited at most twice:
 *    - once in finding kth node
 *    - once in reversing
 *
 *  SPACE COMPLEXITY (SC):
 * O(1)
 * → Only pointers used (dummy, prevGroupEnd, kth, groupStart, etc.)
 * → No extra data structure.
 */
public class ReverseKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {

        // Edge case: no need to reverse
        if (head == null || k == 1) return head;

        // Dummy node (VERY IMPORTANT)
        // Helps in reversing from the very first node safely
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // This will always point to the end of the last processed group
        ListNode prevGroupEnd = dummy;

        while (true) {

            // STEP 1: Find kth node from prevGroupEnd
            // If we cannot find k nodes, stop (remaining nodes < k)
            ListNode kth = prevGroupEnd;
            for (int i = 0; i < k && kth != null; i++) {
                kth = kth.next;
            }

            // If kth becomes null → No more complete groups → Stop
            if (kth == null) break;

            // STEP 2: Identify group boundaries
            ListNode groupStart = prevGroupEnd.next; // First node of the group
            ListNode nextGroupStart = kth.next;      // Node after kth (next group's start)

            // STEP 3: Reverse the group
            // Standard reverse pointers
            ListNode curr = groupStart;
            ListNode prev = nextGroupStart;

            /**
             *  REVERSAL LOGIC:
             * Reverse [groupStart ... kth] so that it ends up:
             * kth → ... → groupStart → nextGroupStart
             *
             * Condition:
             * Reverse until curr reaches nextGroupStart
             */
            while (curr != nextGroupStart) {
                ListNode next = curr.next; // store next node
                curr.next = prev;          // reverse pointer
                prev = curr;               // move prev ahead
                curr = next;               // move curr ahead
            }

            // STEP 4: Connect reversed group back to main list
            prevGroupEnd.next = kth;      // kth becomes new head of this group
            prevGroupEnd = groupStart;    // groupStart becomes end after reverse
        }

        // Return new head (dummy.next)
        return dummy.next;
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Creating example linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println("Original List:");
        printList(head);

        ReverseKGroup obj = new ReverseKGroup();
        int k = 2;

        ListNode result = obj.reverseKGroup(head, k);

        System.out.println("Reversed in groups of " + k + ":");
        printList(result);
    }
}
package linkedlist.singlylinkedlist;

/**
 * ✅ Problem Statement:
 * Sort a linked list consisting of nodes with values 0, 1, and 2.
 * Rearrange the list so that all 0s come first, then 1s, and then 2s.
 *
 * ⚙️ Example:
 * Input:  1 → 0 → 2 → 1 → 0
 * Output: 0 → 0 → 1 → 1 → 2
 *
 * We’ll use both:
 * 1️⃣ Brute-force approach (count and overwrite)
 * 2️⃣ Optimal approach (Dutch National Flag style using 3 dummy lists)
 */

public class Sort0s1s2sLinkedList {

    // ==========================================================
    // 1️⃣ BRUTE FORCE APPROACH
    // ==========================================================
    public ListNode sortList(ListNode head) {
        if (head == null) return null;

        int count0 = 0, count1 = 0, count2 = 0;

        // Step 1️⃣: Count occurrences of 0, 1, and 2
        ListNode current = head;
        while (current != null) {
            if (current.data == 0) count0++;
            else if (current.data == 1) count1++;
            else count2++;
            current = current.next;
        }

        // Step 2️⃣: Overwrite node values in the same order
        current = head;
        for (int i = 0; i < count0; i++) { current.data = 0; current = current.next; }
        for (int i = 0; i < count1; i++) { current.data = 1; current = current.next; }
        for (int i = 0; i < count2; i++) { current.data = 2; current = current.next; }

        return head;
    }

    // ==========================================================
    // 2️⃣ OPTIMAL APPROACH (Dutch National Flag Algorithm)
    // ==========================================================
    public ListNode sortListOptimal(ListNode head) {
        if (head == null) return null;

        // Step 1️⃣: Create dummy nodes for 0, 1, 2 lists
        ListNode zeroD = new ListNode(-1);
        ListNode oneD  = new ListNode(-1);
        ListNode twoD  = new ListNode(-1);

        // Pointers to keep track of last nodes of each list
        ListNode zero = zeroD, one = oneD, two = twoD;

        // Step 2️⃣: Traverse and link nodes into separate lists
        ListNode current = head;
        while (current != null) {
            if (current.data == 0) {
                zero.next = current;
                zero = zero.next;
            } else if (current.data == 1) {
                one.next = current;
                one = one.next;
            } else {
                two.next = current;
                two = two.next;
            }
            current = current.next;
        }

        // Step 3️⃣: Connect three lists together
        zero.next = (oneD.next != null) ? oneD.next : twoD.next;
        one.next = twoD.next;
        two.next = null;

        // Step 4️⃣: Return new head (start of zero list)
        head = zeroD.next;
        return head;
    }

    // ==========================================================
    // 🔎 SMALL DRY RUN (for optimal)
    // ==========================================================
    /*
       Input: 1 → 0 → 2 → 1 → 0

       zeroD(-1) →
       oneD(-1)  →
       twoD(-1)  →

       Step 1: current = 1 → goes to one list
       oneD → 1
       Step 2: current = 0 → goes to zero list
       zeroD → 0
       Step 3: current = 2 → goes to two list
       twoD → 2
       Step 4: current = 1 → goes to one list
       oneD → 1 → 1
       Step 5: current = 0 → goes to zero list
       zeroD → 0 → 0

       Final Connect:
       zero → one → two
       Result: 0 → 0 → 1 → 1 → 2
     */

    // ==========================================================
    // ⏱️ Time Complexity:
    // ==========================================================
    // O(N) → single traversal (each node visited once)
    //
    // 🧮 Space Complexity:
    // O(1) → only pointers used (no extra list created)
    //
    // ==========================================================
    // ⚡ Key Formula / Trigger Points to Remember:
    // ==========================================================
    // 👉 Linked list rearrangement → always think dummy node pattern
    // 👉 0/1/2 → Dutch National Flag (3 partitions)
    // 👉 When you connect multiple lists → handle tail.next = null at end
    // 👉 If values repeat → no need to swap, just link in order
    // 👉 TC = O(N), SC = O(1) for in-place rearrangement
    // ==========================================================

    public static void main(String[] args) {
        // Sample linked list: 1 → 0 → 2 → 1 → 0
        ListNode head = new ListNode(1, new ListNode(0, new ListNode(2, new ListNode(1, new ListNode(0)))));

        Sort0s1s2sLinkedList obj = new Sort0s1s2sLinkedList();

        System.out.println("Before sorting:");
        printList(head);

        head = obj.sortListOptimal(head);

        System.out.println("\nAfter sorting:");
        printList(head);
    }

    // Helper to print the linked list
    static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
    }
}

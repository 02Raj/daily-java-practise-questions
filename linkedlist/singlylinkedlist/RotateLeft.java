package linkedlist.singlylinkedlist;

/**
 *  PROBLEM STATEMENT:
 * Rotate a linked list to the LEFT by k positions.
 *
 * Example:
 * Input  : [1,2,3,4,5], k=2
 * Output : [3,4,5,1,2]
 *
 *  INTUITION (EASY):
 * LEFT rotation ka matlab:
 * → Pehle k nodes ko peeche bhej do.
 *
 * Example:
 * [1,2,3,4,5], k=2
 * Move first 2 to end:
 * → [3,4,5,1,2]
 *
 *  WHY DIFFERENT FORMULA FROM RIGHT ROTATION?
 *
 * RIGHT ROTATION:
 * → Last k elements ko front me lana hota hai.
 * → New head = element at index (n - k)
 *
 * LEFT ROTATION:
 * → First k elements ko last me bhejna hota hai.
 * → New head = element at index k
 *
 * Isliye:
 * RIGHT:  stepsToNewHead = n - k
 * LEFT :  stepsToNewHead = k
 *
 *  WHY k = k % n REQUIRED?
 * If k > n, e.g. list = [1,2,3], k=10
 * left rotate 10 times = left rotate (10 % 3) = 1 time
 * → 10 baar rotate karne ka koi matlab nahi.
 *
 *  KEY TO REMEMBER:
 * LEFT ROTATION:
 * 1. Find (k - 1)-th node ⇒ newTail
 * 2. newHead = newTail.next
 * 3. Cut the circle
 *
 *  TIME COMPLEXITY:
 * O(n)
 * → 1 baar list traverse (length ke liye)
 * → 1 baar newTail tak move
 *
 *  SPACE COMPLEXITY:
 * O(1)
 * → Only pointers used.
 *
 *  MINI DRY RUN:
 * List = 1 → 2 → 3 → 4 → 5, k = 2
 *
 * n = 5
 * k = k % 5 = 2
 * Make circle:
 * 1→2→3→4→5→1→...
 *
 * newTail = k-1 = 1st index = node 2
 * newHead = 2.next = 3
 * Break at newTail → 2.next = null
 *
 * Final:
 * 3 → 4 → 5 → 1 → 2
 */

public class RotateLeft {

    public ListNode rotateLeft(ListNode head , int k){

        // Edge Case: 0 or 1 node → rotation changes nothing
        if(head == null || head.next == null) return head;

        // STEP 1: Find length (n) and the last node (tail)
        ListNode temp = head;
        int n = 1;
        while(temp.next != null){
            temp = temp.next;
            n++;
        }
        ListNode tail = temp;  // tail points to the last node

        // STEP 2: Effective left rotation
        k = k % n; // Very important
        if(k == 0) return head;

        // STEP 3: Make list circular
        tail.next = head;

        // STEP 4: Move to newTail (k - 1)-th node
        ListNode newTail = head;
        for(int i = 1; i < k; i++){
            newTail = newTail.next;
        }

        // STEP 5: newHead is next of newTail
        ListNode newHead = newTail.next;

        // STEP 6: Break circular list
        newTail.next = null;

        return newHead;
    }

    public static void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {

        // Example list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        RotateLeft rl = new RotateLeft();
        ListNode result = rl.rotateLeft(head, 2);

        System.out.println("Left Rotated List:");
        printList(result);  // Expected: 3 → 4 → 5 → 1 → 2
    }
}

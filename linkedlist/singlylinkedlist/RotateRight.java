package linkedlist.singlylinkedlist;

/**
 *  PROBLEM STATEMENT:
 * Rotate a linked list to the right by k positions.
 *
 * Example:
 * head = [1,2,3,4,5], k = 2
 * Output = [4,5,1,2,3]
 *
 *  INTUITION:
 * Rotation ka matlab list ke last k nodes ko front me laana.
 * But directly k times rotate karna costly hoga → O(n * k)
 * Isliye list ko circular banate hain, phir circle tod kar new head banate hain.
 *
 *  KEY FORMULA:
 * Effective rotations = k % n
 * Steps to reach newHead = n - (k % n)
 *
 *  APPROACH:
 * 1. Length (n) find karo + tail find karo.
 * 2. Effective rotation: k = k % n
 * 3. tail.next = head → circular list ban jati hai.
 * 4. stepsToNewHead = n - k
 * 5. stepsToNewHead - 1 times aage jao → yahi newTail hai.
 * 6. newHead = newTail.next
 * 7. newTail.next = null → circle break.
 *
 *  TIME COMPLEXITY:
 * O(n)
 * → Because hum list ko 1 baar traverse karte hain (length calculation),
 *   aur 1 baar newTail dhoondhte hain.
 *
 *  SPACE COMPLEXITY:
 * O(1)
 * → Only pointers use hote hain (temp, tail, newTail, newHead).
 *
 *  MINI DRY RUN:
 * List = 1 → 2 → 3 → 4 → 5
 * k = 2
 * n = 5
 * effective k = 2 % 5 = 2
 * stepsToNewHead = 5 - 2 = 3
 *
 * Move 2 steps:
 * newTail = node(3)
 * newHead = node(4)
 * break circle at node(3)
 *
 * Final = 4 → 5 → 1 → 2 → 3
 */

public class RotateRight {

    public ListNode rotateRight(ListNode head , int k){

        // EDGE CASE: If list has 0 or 1 node → rotation changes nothing
        if(head == null || head.next == null) return head;

        // STEP 1: Find length (n) and last node (tail)
        ListNode temp = head;
        int n = 1;
        while(temp.next != null){
            temp = temp.next;
            n++;
        }

        ListNode tail = temp; // tail now points to last node

        // STEP 2: Effective rotation
        k = k % n;                 // Extra rotations remove
        int stepsToNewHead = n - k; // Distance to new head from start

        // STEP 3: Make list circular
        tail.next = head;

        // STEP 4: Find newTail (which comes just before newHead)
        ListNode newTail = head;
        for(int i = 1; i < stepsToNewHead; i++){
            newTail = newTail.next;
        }

        // STEP 5: newHead is next of newTail
        ListNode newHead = newTail.next;

        // STEP 6: Break the circle
        newTail.next = null;

        // STEP 7: Return new head
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

        //  Creating sample linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        // Input: head = [1,2,3,4,5], k = 2
        RotateRight rr = new RotateRight();
        ListNode result = rr.rotateRight(head, 2);

        //  Print Output
        System.out.println("Rotated List:");
        printList(result);
    }
}

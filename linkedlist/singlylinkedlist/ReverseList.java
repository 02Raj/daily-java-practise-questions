package linkedlist.singlylinkedlist;



public class ReverseList {

    // Step 2: Reverse logic
    public ListNode reverseList(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        ListNode next = null;

        while (curr != null) {
            next = curr.next;   // Save next node
            curr.next = prev;   // Reverse the link
            prev = curr;        // Move prev forward
            curr = next;        // Move curr forward
        }
        return prev; // New head of reversed list
    }

    // Step 3: Print list helper
    public void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.data);
            if (temp.next != null) System.out.print(" -> ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Step 4: Main method
    public static void main(String[] args) {
        ReverseList rl = new ReverseList();

        // Create linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println("Original List:");
        rl.printList(head);

        // Reverse the list
        ListNode reversedHead = rl.reverseList(head);

        System.out.println("Reversed List:");
        rl.printList(reversedHead);
    }
}

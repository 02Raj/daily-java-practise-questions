package linkedlist.doubleylinkedlist;

public class DeleteAllOccurrences {

    public ListNode deleteAllOccurrences(ListNode head, int target) {
        ListNode curr = head;

        while (curr != null) {
            ListNode nextNode = curr.next;

            if (curr.data == target) {
                // Case 1: curr is head
                if (curr == head) {
                    head = curr.next;
                    if (head != null)
                        head.prev = null;
                }
                // Case 2: curr is not head
                else {
                    curr.prev.next = curr.next;
                    if (curr.next != null)
                        curr.next.prev = curr.prev;
                }
            }
            curr = nextNode; // move ahead
        }
        return head;
    }

    // Helper function to print list
    public void printList(ListNode head) {
        ListNode curr = head;
        System.out.print("List: ");
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DeleteAllOccurrences obj = new DeleteAllOccurrences();

        // Create linked list: 1 <-> 2 <-> 3 <-> 2 <-> 4 <-> 2
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.prev = head;
        head.next.next = new ListNode(3);
        head.next.next.prev = head.next;
        head.next.next.next = new ListNode(2);
        head.next.next.next.prev = head.next.next;
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.prev = head.next.next.next;
        head.next.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next.prev = head.next.next.next.next;

        System.out.println("Before deletion:");
        obj.printList(head);

        // Delete all occurrences of 2
        head = obj.deleteAllOccurrences(head, 2);

        System.out.println("After deleting 2:");
        obj.printList(head);
    }
}
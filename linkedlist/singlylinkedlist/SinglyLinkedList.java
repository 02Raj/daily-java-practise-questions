package linkedlist.singlylinkedlist;

public class SinglyLinkedList {
    private ListNode head;

    // Insert at end (default insert)
    public void insert(int val) {
        ListNode newNode = new ListNode(val);

        if (head == null) {
            head = newNode;
            return;
        }

        ListNode current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    // Insert at beginning
    public void insertAtBeginning(int val) {
        ListNode newNode = new ListNode(val);
        newNode.next = head;
        head = newNode;
    }

    // Insert at position (0-based index)
    public void insertAtPosition(int index, int val) {
        if (index < 0) {
            System.out.println("Invalid index");
            return;
        }

        if (index == 0) {
            insertAtBeginning(val);
            return;
        }

        ListNode newNode = new ListNode(val);
        ListNode current = head;
        int count = 0;

        while (current != null && count < index - 1) {
            current = current.next;
            count++;
        }

        if (current == null) {
            System.out.println("Index out of range");
            return;
        }

        newNode.next = current.next;
        current.next = newNode;
    }

    // ✅ DELETE METHODS

    // Delete from beginning
    public void deleteFromBeginning() {
        if (head == null) {
            System.out.println("List is empty, nothing to delete");
            return;
        }
        head = head.next;
    }

    // Delete from end
    public void deleteFromEnd() {
        if (head == null) {
            System.out.println("List is empty, nothing to delete");
            return;
        }
        if (head.next == null) { // only one node
            head = null;
            return;
        }

        ListNode current = head;
        while (current.next.next != null) { // second last node tak
            current = current.next;
        }
        current.next = null;
    }

    // Delete at specific position (0-based index)
    public void deleteAtPosition(int index) {
        if (head == null) {
            System.out.println("List is empty, nothing to delete");
            return;
        }
        if (index == 0) {
            deleteFromBeginning();
            return;
        }

        ListNode current = head;
        int count = 0;

        while (current != null && count < index - 1) {
            current = current.next;
            count++;
        }

        if (current == null || current.next == null) {
            System.out.println("Index out of range");
            return;
        }

        current.next = current.next.next;
    }

    // Delete by key value
    public void deleteByValue(int key) {
        if (head == null) {
            System.out.println("List is empty, nothing to delete");
            return;
        }

        if (head.data == key) {
            head = head.next;
            return;
        }

        ListNode current = head;
        while (current.next != null && current.next.data != key) {
            current = current.next;
        }

        if (current.next == null) {
            System.out.println("Value not found in list");
            return;
        }

        current.next = current.next.next;
    }

    // Traverse list
    public void traverseList() {
        ListNode current = head;
        System.out.print("Linked List Elements: ");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();

        list.insert(5);
        list.insert(10);
        list.insert(15);
        list.insert(20);
        list.insert(25);

        list.traverseList();  // 5 10 15 20 25

        list.deleteFromBeginning();
        list.traverseList();  // 10 15 20 25

        list.deleteFromEnd();
        list.traverseList();  // 10 15 20

        list.deleteAtPosition(1);
        list.traverseList();  // 10 20

        list.deleteByValue(10);
        list.traverseList();  // 20
    }
}

package linkedlist.doubleylinkedlist;

public class Main {

    // Node class (doubly linked)
    public static class Node {
        int data;
        Node next;
        Node prev;  // 👈 extra pointer for previous node
    }

    // Doubly LinkedList class
    public static class DoublyLinkedList {
        Node head;
        Node tail;
        int size;

        // ✅ Add node at the end
        void addLast(int val) {
            Node temp = new Node();
            temp.data = val;
            temp.next = null;
            temp.prev = null;

            if (size == 0) {
                head = tail = temp;
            } else {
                tail.next = temp;
                temp.prev = tail;   // 👈 link back
                tail = temp;
            }
            size++;
        }

        // ✅ Add node at the beginning
        void addFirst(int val) {
            Node temp = new Node();
            temp.data = val;
            temp.next = head;
            temp.prev = null;

            if (size == 0) {
                head = tail = temp;
            } else {
                head.prev = temp;
                head = temp;
            }
            size++;
        }

        // ✅ Remove first node
        void removeFirst() {
            if (size == 0) {
                System.out.println("List is empty");
            } else if (size == 1) {
                head = null;
                tail = null;
                size = 0;
            } else {
                head = head.next;
                head.prev = null;  // 👈 disconnect back
                size--;
            }
        }

        // ✅ Get value at index
        int get(int index) {
            if (index < 0 || index >= size) {
                System.out.println("Invalid index");
                return -1;
            }
            Node temp = head;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            return temp.data;
        }

        int getFirst() {
            if (size == 0) {
                System.out.println("List is Empty");
                return -1;
            }
            return head.data;
        }

        int getLast() {
            if (size == 0) {
                System.out.println("List is Empty");
                return -1;
            }
            return tail.data;
        }

        // ✅ Print list forward
        void printForward() {
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.data + " ⇄ ");
                temp = temp.next;
            }
            System.out.println("null");
        }

        // ✅ Print list backward
        void printBackward() {
            Node temp = tail;
            while (temp != null) {
                System.out.print(temp.data + " ⇄ ");
                temp = temp.prev;
            }
            System.out.println("null");
        }

        int getSize() {
            return size;
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();

        System.out.println("Add 10 at last:");
        list.addLast(10);
        list.printForward();  // 10 ⇄ null

        System.out.println("Add 20 at last:");
        list.addLast(20);
        list.printForward();  // 10 ⇄ 20 ⇄ null

        System.out.println("Add 30 at last:");
        list.addLast(30);
        list.printForward();  // 10 ⇄ 20 ⇄ 30 ⇄ null

        System.out.println("Add 5 at first:");
        list.addFirst(5);
        list.printForward();  // 5 ⇄ 10 ⇄ 20 ⇄ 30 ⇄ null

        System.out.println("Total Nodes: " + list.getSize());  // 4

        System.out.println("Removing first:");
        list.removeFirst();
        list.printForward();  // 10 ⇄ 20 ⇄ 30 ⇄ null

        System.out.println("Get value at index 1: " + list.get(1));  // 20

        System.out.println("Get first node: " + list.getFirst());   // 10
        System.out.println("Get last node: " + list.getLast());     // 30

        System.out.println("Forward print:");
        list.printForward();    // 10 ⇄ 20 ⇄ 30 ⇄ null

        System.out.println("Backward print:");
        list.printBackward();   // 30 ⇄ 20 ⇄ 10 ⇄ null
    }
}

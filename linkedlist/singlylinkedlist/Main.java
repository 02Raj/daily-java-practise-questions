package linkedlist.singlylinkedlist;



public class Main {

    // Node class
    public static class Node {
        int data;
        Node next;
    }

    // LinkedList class
    public static class LinkedList {
        Node head;
        Node tail;
        int size;

        // ✅ Add node at the end
        void addLast(int val) {
            Node temp = new Node();
            temp.data = val;
            temp.next = null;

            if (size == 0) {
                head = tail = temp;
            } else {
                tail.next = temp;  // ❗Fix: tail ke next mein new node
                tail = temp;       // tail ko update karo
            }
            size++;
        }

        void removeFirst(){
            if(size == 0){
                System.out.println("List is empty");
            }else if(size == 1){
                head = null;
                tail = null;
                size = 0;
            }else{
                head = head.next;
                size--;
            }
        }

        int get(int index){
            if(index < 0 || index >= size) {
                System.out.println("Invlid index");
                return -1;
            }else{
                Node temp = head;
                for (int i = 0; i < index; i++){
                    temp  = temp.next;
                }
                return temp.data;
            }
        }

        int getFirst(){
            if(size == 0){
                System.out.println("List is Empty");
                return -1;
            }else{
                return head.data;
            }
        }

        int getLast(){
            if(size==0){
                System.out.println("List is Empty");
                return -1;
            }else {
                return tail.data;
            }
        }

        void addFirst(int data){
            Node newNode = new Node();
            newNode.data = data;
            newNode.next = head;
            head = newNode;
            if (size == 0) {
                tail = newNode;
            }
            size++;
        }

        // ✅ Print all nodes
        void printList() {
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.data + " → ");
                temp = temp.next;
            }
            System.out.println("null");
        }

        // ✅ Size method (optional)
        int getSize() {
            return size;
        }
    }

    // Main method to run test cases
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        // 🔽 Test Cases
        System.out.println("Add 10:");
        list.addLast(10);
        list.printList();  // Output: 10 → null

        System.out.println("Add 20:");
        list.addLast(20);
        list.printList();  // Output: 10 → 20 → null

        System.out.println("Add 30:");
        list.addLast(30);
        list.printList();  // Output: 10 → 20 → 30 → null

        System.out.println("Total Nodes: " + list.getSize());  // Output: 3

        System.out.println("Removing first:");
        list.removeFirst();
        list.printList();  // Expected output: 20 → 30 → null

        System.out.println("Get value at index 2: ");
        System.out.println(list.get(2)); // agar method get(int index) hai

        list.printList();

        System.out.println("Get first node: ");
        System.out.println(list.getFirst()); // agar return karta hai int

        System.out.println("Get last node: ");
        System.out.println(list.getLast());

        list.printList();
        System.out.println("Add first in node:");
        list.addFirst(12);
        list.printList();
    }
}

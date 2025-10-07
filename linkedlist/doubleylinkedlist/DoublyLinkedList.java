package linkedlist.doubleylinkedlist;

public class DoublyLinkedList {

    private ListNode head;

    // 1️⃣ Insert at Beginning
    public void insertAtBeginning(int data) {
        ListNode newNode = new ListNode(data);
        if (head != null) {
            newNode.next = head;
            head.prev = newNode;
        }
        head = newNode;
    }

    // 2️⃣ Insert at End
    public void insertAtEnd(int data){
        ListNode newNode = new ListNode(data);
        if (head == null) {
            head = newNode;
            return;
        }

        ListNode temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = newNode;
        newNode.prev = temp;
    }

    // 3️⃣ Insert After a Given Nod
    public void insertAfter(int key, int data){
        ListNode temp = head;

        while (temp != null && temp.data != key) {
            temp = temp.next;
        }
        if (temp == null){
            System.out.println("Key not found!");
            return;
        }

        ListNode newNode = new ListNode(data);
        newNode.next = temp.next;
        newNode.prev = temp;

    }

}

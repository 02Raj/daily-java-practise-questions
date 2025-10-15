package linkedlist.singlylinkedlist;

public class ListNode {
    int data;
    ListNode next;

    ListNode(int data){
        this.data = data;
        this.next = null;
    }

    //  Constructor 2: for linking nodes easily
    ListNode(int data, ListNode next) {
        this.data = data;
        this.next = next;
    }
}

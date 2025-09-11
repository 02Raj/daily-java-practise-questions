package stack;

public class Queue {
    Node front ,rear;

    Queue(){
        this.front = this.rear = null;
    }

    void enqueue(int data){
        Node newNode = new Node(data);

        if(rear == null){
            front = rear = null;
        }

        rear.next = newNode;
    }
}

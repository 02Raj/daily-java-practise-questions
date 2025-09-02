package stack;

import java.util.Stack;

public class QueueUsingStack {

    private Stack<Integer> inStack;
    private Stack<Integer> outStack;

    public QueueUsingStack(){
        inStack = new Stack<>();
        outStack = new Stack<>();
    }

    public void enqueue(int x){
        inStack.push(x);
        System.out.println(x + " enqueued to queue.");
    }

    public int dequeue(){
        if(isEmpty()){
            System.out.println("Queue is empty.");
            return -1;
        }
        if (outStack.isEmpty()){
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
        return outStack.peek();
    }

    public boolean isEmpty(){
        return inStack.isEmpty() && outStack.isEmpty();
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return -1;
        }
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
        return outStack.peek();
    }

    public static void main(String[] args) {
        QueueUsingStack q = new QueueUsingStack();

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);

        System.out.println("Dequeued: " + q.dequeue()); // 10
        System.out.println("Front: " + q.peek());       // 20
        System.out.println("Dequeued: " + q.dequeue()); // 20
        System.out.println("Dequeued: " + q.dequeue()); // 30
    }
}

package stack;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {
    private Queue<Integer> q;

    // Constructor
    public StackUsingQueue() {
        q = new LinkedList<>();
    }

    // Push operation
    public void push(int x) {
        int size = q.size();
        q.add(x); // pehle element ko queue me dal do

        // ab rotate karke x ko front me le aao
        for (int i = 0; i < size; i++) {
            q.add(q.remove());
        }
        System.out.println(x + " pushed to stack.");
    }

    // Pop operation
    public int pop() {
        if (q.isEmpty()) {
            System.out.println("Stack is empty. Cannot pop.");
            return -1;
        }
        return q.remove(); // front element = top of stack
    }

    // Peek operation
    public int top() {
        if (q.isEmpty()) {
            System.out.println("Stack is empty.");
            return -1;
        }
        return q.peek();
    }

    // Check if empty
    public boolean isEmpty() {
        return q.isEmpty();
    }


    public static void main(String[] args) {
        StackUsingQueue st  = new StackUsingQueue();

        st.push(10);
        st.push(20);
        st.push(30);

        System.out.println("Top: " + st.top()); // 30
        System.out.println("Popped: " + st.pop()); // 30
        System.out.println("Popped: " + st.pop()); // 20
        System.out.println("Top: " + st.top());   // 10
    }
}

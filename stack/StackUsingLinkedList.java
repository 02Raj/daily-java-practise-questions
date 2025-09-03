package stack;

// Stack Implementation using Linked List
class StackUsingLinkedList {
    private Node top; // top of stack

    StackUsingLinkedList() {
        this.top = null;
    }

    // Push operation
    public void push(int data) {
        Node newNode = new Node(data);
        newNode.next = top; // link new node to previous top
        top = newNode;
        System.out.println(data + " pushed to stack");
    }

    // Pop operation
    public int pop() {
        if (top == null) {
            System.out.println("Stack Underflow");
            return -1;
        }
        int popped = top.data;
        top = top.next; // move top to next node
        return popped;
    }

    // Peek operation (top element)
    public int peek() {
        if (top == null) {
            System.out.println("Stack is Empty");
            return -1;
        }
        return top.data;
    }

    // Check if stack is empty
    public boolean isEmpty() {
        return top == null;
    }

    // Print stack elements
    public void printStack() {
        Node temp = top;
        System.out.print("Stack: ");
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        StackUsingLinkedList stack = new StackUsingLinkedList();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        stack.printStack(); // Stack: 30 20 10

        System.out.println("Top element is " + stack.peek()); // 30
        System.out.println("Popped element is " + stack.pop()); // 30

        stack.printStack(); // Stack: 20 10
    }
}
package stack;



public class ArrayStack {
    private int[] arr;        // Stack ke elements store karne ke liye array
    private int top;          // Top pointer (stack ke upar wale element ka index)
    private int capacity;     // Stack ki maximum size

    // Constructor (jab naya stack banate hain, tab call hota hai)
    public ArrayStack(int capacity) {
        this.capacity = capacity;   // Stack ka maximum size set karo
        arr = new int[capacity];    // Utne size ka integer array banao
        top = -1;                   // Shuru me stack empty hota hai, isliye top = -1
    }

    // Push operation: stack ke top pe element add karta hai
    public void push(int x) {
        if (top == capacity - 1) {          // Agar top last index pe hai => stack full
            throw new RuntimeException("Stack Overflow"); // Error throw karo
        }
        arr[++top] = x;     // top ko ek step aage badhao (pre-increment) aur wahan x rakho
    }

    // Pop operation: stack ke top se element remove karta hai
    public int pop() {
        if (isEmpty()) {                        // Agar stack empty hai
            throw new RuntimeException("Stack Underflow"); // Error throw karo
        }
        return arr[top--];  // top wale element ko return karo aur top ko ek step piche le aao
    }

    // Top operation: sirf upar wala element return karo (hataye bina)
    public int top() {
        if (isEmpty()) {                        // Agar stack khali hai
            throw new RuntimeException("Stack is Empty"); // Error throw karo
        }
        return arr[top];   // top wale element ka value return karo
    }

    // Check operation: stack empty hai ya nahi
    public boolean isEmpty() {
        return top == -1;   // Agar top = -1 hai to stack empty hai
    }

    // Main method: yaha testing ho rahi hai
    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(5);   // 5 size ka stack banao

        stack.push(10);   // [10] (top = 0)
        stack.push(20);   // [10, 20] (top = 1)
        stack.push(30);   // [10, 20, 30] (top = 2)

        // Ab top element dekho
        System.out.println("Top element: " + stack.top()); // Output: 30

        // Ab pop karo (30 nikal jayega)
        System.out.println("Popped: " + stack.pop());      // Output: 30, ab stack = [10, 20]

        // Ab dobara top element dekho
        System.out.println("Top element after pop: " + stack.top()); // Output: 20
    }
}
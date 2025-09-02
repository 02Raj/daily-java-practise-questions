package stack;

class QueueUsingArray {
    private int[] arr;
    private int front;
    private int rear;
    private int capacity;
    private int size;

    // Constructor
    public QueueUsingArray(int capacity) {
        this.capacity = capacity;
        arr = new int[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    // Add element to the queue
    public void enqueue(int data) {
        if (isFull()) {
            System.out.println("Queue is full. Cannot insert " + data);
            return;
        }
        rear = (rear + 1) % capacity; // circular increment
        arr[rear] = data;
        size++;
        System.out.println(data + " enqueued to queue.");
    }

    // Remove element from the queue
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue.");
            return -1;
        }
        int removed = arr[front];
        front = (front + 1) % capacity; // circular increment
        size--;
        return removed;
    }

    // Peek front element
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return -1;
        }
        return arr[front];
    }

    // Check if queue is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Check if queue is full
    public boolean isFull() {
        return size == capacity;
    }

    // Display queue elements
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        System.out.print("Queue elements: ");
        for (int i = 0; i < size; i++) {
            System.out.print(arr[(front + i) % capacity] + " ");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        QueueUsingArray queue = new QueueUsingArray(5);

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.display();

        System.out.println("Dequeued: " + queue.dequeue());
        queue.display();

        System.out.println("Front element: " + queue.peek());
    }
}

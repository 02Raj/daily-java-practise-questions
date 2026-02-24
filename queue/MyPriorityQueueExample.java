package queue;

import java.util.PriorityQueue;

public class MyPriorityQueueExample {

    public static void main(String[] args) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        try {
            pq.add(10);
            pq.add(20);
            pq.add(30);
            pq.offer(5);
            System.out.println("PriorityQueue: " + pq);
            System.out.println("peek(): " + pq.peek());  //
            System.out.println("element(): " + pq.element()); //

//            System.out.println("remove(): " + pq.remove());
            System.out.println("poll(): " + pq.poll());
            System.out.println("Removing elements in priority order:");
            while(!pq.isEmpty()){
                System.out.println(pq.remove());
            }

        }catch (Exception e){
            System.out.println("Exception: " + e.getMessage());
        }
    }
}

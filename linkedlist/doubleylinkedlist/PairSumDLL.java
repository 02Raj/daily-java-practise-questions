package linkedlist.doubleylinkedlist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Problem Statement:
Find all pairs in a sorted doubly linked list whose sum equals a given target.

Intuition:
In a doubly linked list, we can move both forward and backward (using next and prev).
So, we can use the Two Pointer technique:
- Start one pointer (left) from the head.
- Start another pointer (right) from the tail.
- Check their sum.
  -> If sum == target → we found a valid pair.
  -> If sum < target → move left forward to increase sum.
  -> If sum > target → move right backward to decrease sum.

Why not use fast and slow pointers?
Fast and slow pointers are useful for detecting cycles or finding the middle element, not for comparing values from both ends.
Here, Two Pointer is perfect since we need pair comparison.

Time Complexity: O(N) — each node is visited once.
Space Complexity: O(1) — no extra space is used except the result list.
*/

public class PairSumDLL {

    public static List<List<Integer>> findPairsWithGivenSum(ListNode head, int target) {

        List<List<Integer>> result = new ArrayList<>();

        if (head == null) {
            System.out.println("List is empty");
            return result;
        }

        // Find the tail of the list
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }

        // Initialize two pointers
        ListNode left = head;
        ListNode right = tail;

        System.out.println("Starting Two Pointer Search...");
        System.out.println("Target Sum: " + target);

        // Traverse until both pointers meet
        while (left != right && right.next != left) {

            int sum = left.data + right.data;
            System.out.println("Checking Pair (" + left.data + ", " + right.data + ") → Sum = " + sum);

            if (sum == target) {
                System.out.println("Pair Found: (" + left.data + ", " + right.data + ")");
                result.add(Arrays.asList(left.data, right.data));

                left = left.next;
                right = right.prev;
            }
            else if (sum < target) {
                System.out.println("Sum < Target → Move Left Forward");
                left = left.next;
            }
            else {
                System.out.println("Sum > Target → Move Right Backward");
                right = right.prev;
            }
        }

        System.out.println("\nAll Pairs with Given Sum:");
        for (List<Integer> pair : result) {
            System.out.println(pair);
        }

        return result;
    }

    public static void main(String[] args) {

        /*
        Example:
        Doubly Linked List: 1 ⇄ 2 ⇄ 3 ⇄ 4 ⇄ 5 ⇄ 6
        Target = 7
        Expected Output: [ [1,6], [2,5], [3,4] ]
        */

        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);

        // Connect nodes
        head.next = node2; node2.prev = head;
        node2.next = node3; node3.prev = node2;
        node3.next = node4; node4.prev = node3;
        node4.next = node5; node5.prev = node4;
        node5.next = node6; node6.prev = node5;

        // Call method
        findPairsWithGivenSum(head, 7);
    }
}

/*
Recap:
- Two Pointer is best for problems that need comparison from both ends.
- Fast and Slow pointer is used only for cycle or midpoint detection.
- Each step adjusts pointers based on whether the sum is less or greater than target.

Revision Tip:
"Doubly Linked → both directions → Two Pointer best choice."
*/

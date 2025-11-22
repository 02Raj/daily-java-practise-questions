package linkedlist.singlylinkedlist;

import java.util.HashSet;
import java.util.Set;

public class NumComponents {

    /*
        Problem Statement:
        ------------------
        Given the head of a linked list and an integer array nums,
        count how many connected components are formed by the nodes
        whose values appear in nums.
        A connected component means consecutive linked-list nodes
        that are all present in nums.

        Example:
        Linked List: 0 -> 1 -> 2 -> 3
        nums = [0, 1, 3]
        Components:
        (0 -> 1)   and   (3)
        Answer = 2


        Intuition:
        ----------
        Only those nodes matter which exist in nums.
        If a node is in nums and the next node is NOT in nums,
        then a component ends at this node.
        Count such ending points.


        Approach:
        ---------
        1. Put all nums values into a HashSet for O(1) lookup.
        2. Traverse the linked list node by node.
        3. For every node:
           If current node is in the set AND
           the next node is either null or not in the set,
           then this is the end of a connected component.
           Increase count.
        4. Return the total count.


        Important formula to remember:
        ------------------------------
        Count a component when:
        (node in nums) AND (next node not in nums or next is null)


        Time Complexity:
        ----------------
        O(n + m)
        n = number of nodes in linked list
        m = size of nums array
        Building HashSet = O(m)
        Traversing list = O(n)

        Space Complexity:
        -----------------
        O(m)
        Because HashSet stores the nums values.


        Key points to remember for similar problems:
        --------------------------------------------
        1. Always use HashSet for fast lookup.
        2. Think in terms of "component ends" not "component starts".
        3. Component ends when next node is not part of the set.
        4. Linked list traversal + set membership check solves most
           linked-list component problems.
        5. Avoid doing nested loops; use HashSet to reduce lookup time.
     */

    public int numComponents(ListNode head, int[] nums) {

        // Step 1: Store nums into a set for fast O(1) lookups
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            set.add(n);
        }

        int count = 0;
        ListNode current = head;

        // Step 2: Traverse the linked list
        while (current != null) {

            // Step 3: Check if this node ends a component
            if (set.contains(current.data) &&
                    (current.next == null || !set.contains(current.next.data))) {

                count++;
            }

            current = current.next;  // move forward
        }

        return count;
    }

    public static void main(String[] args) {
        // You can test your linked list here
    }
}

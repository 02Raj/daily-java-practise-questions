package linkedlist.singlylinkedlist;

import java.util.ArrayList;
import java.util.List;

public class isPalindrome {

    /*
     * =========================
     * BRUTE FORCE APPROACH
     * =========================
     *
     * Intuition:
     *  - Store all node values in an ArrayList
     *  - Check if the array is a palindrome by comparing front and back
     *
     * Approach:
     * 1. Traverse the linked list and store values in a list
     * 2. Use two pointers (left=0, right=size-1) to compare values
     * 3. If all match → return true, else return false
     *
     * Formula:
     *  list[left] == list[right] → move left++, right--
     *
     * Time Complexity: O(n) → traverse + compare
     * Space Complexity: O(n) → array to store node values
     *
     * Optional How/Why:
     *  - Simple to implement
     *  - Not space efficient for large lists
     */
    public boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode curr = head;
        while(curr != null){
            list.add(curr.data);
            curr = curr.next;
        }

        int left = 0;
        int right = list.size() - 1;
        while(left < right){
            if(!list.get(left).equals(list.get(right))) return false;
            left++;
            right--;
        }
        return true;
    }

    /*
     * =========================
     * OPTIMAL APPROACH (O(1) SPACE)
     * =========================
     *
     * Intuition:
     *  - Compare halves directly without extra array
     *  - Reverse second half of linked list to compare
     *
     * Approach:
     * 1. Edge case: if list is empty or single node → return true
     * 2. Find middle using slow/fast pointers
     * 3. Reverse second half
     * 4. Compare first half and reversed second half node by node
     * 5. Restore second half (optional)
     *
     * Formula:
     *  slow = head; fast = head;
     *  while(fast != null && fast.next != null){ slow = slow.next; fast = fast.next.next; }
     *  secondHalf = reverse(slow.next)
     *  compare first half and secondHalf
     *
     * Time Complexity: O(n) → traverse + reverse + compare
     * Space Complexity: O(1) → no extra array
     *
     * Optional How/Why:
     *  - Saves memory for large lists
     *  - Still linear time
     *
     * Dry Run Example: 1->2->2->1
     *  Step 1: find middle → slow points to second '2'
     *  Step 2: reverse second half → 2->1 becomes 1->2
     *  Step 3: compare halves → 1==1, 2==2 → palindrome
     *  Step 4: restore second half → 1->2 becomes 2->1
     */
    public boolean isPalindromeOptimal(ListNode head) {
        if(head == null || head.next == null) return true;

        // Step 1: Find middle node
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse second half
        ListNode second = reverse(slow.next);
        ListNode secondCopy = second; // to restore later

        // Step 3: Compare both halves
        ListNode first = head;
        boolean palindrome = true;
        while(second != null){
            if(first.data != second.data){
                palindrome = false;
                break;
            }
            first = first.next;
            second = second.next;
        }

        // Step 4: Restore second half
        slow.next = reverse(secondCopy);

        return palindrome;
    }

    // Helper method to reverse a linked list
    private ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null){
            ListNode next = curr.next;  // save next
            curr.next = prev;           // reverse pointer
            prev = curr;                // move prev forward
            curr = next;                // move curr forward
        }
        return prev;  // new head
    }

    /*
     * =========================
     * MAIN METHOD / TEST CASES
     * =========================
     *
     * Includes:
     * - small dry run examples
     * - console output
     */
    public static void main(String[] args) {
        isPalindrome obj = new isPalindrome();

        // Example 1: 1->2->2->1 (palindrome)
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(2);
        ListNode n4 = new ListNode(1);
        n1.next = n2; n2.next = n3; n3.next = n4;

        System.out.println("Brute Force: " + obj.isPalindrome(n1)); // true
        System.out.println("Optimal: " + obj.isPalindromeOptimal(n1)); // true

        // Example 2: 1->2 (not palindrome)
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        a1.next = a2;

        System.out.println("Brute Force: " + obj.isPalindrome(a1)); // false
        System.out.println("Optimal: " + obj.isPalindromeOptimal(a1)); // false
    }
}
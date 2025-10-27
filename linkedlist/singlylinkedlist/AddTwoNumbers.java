package linkedlist.singlylinkedlist;

/**
 * 💡 Problem:
 * Given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order, and each node contains a single digit.
 * Add the two numbers and return the sum as a linked list.
 *
 * Example:
 * Input: (2 → 4 → 3) + (5 → 6 → 4)
 * Output: 7 → 0 → 8
 * Explanation: 342 + 465 = 807
 *
 * ---------------------------------------------------------
 * 🧠 STORY:
 * Imagine two linked lists where each node represents a digit.
 * You need to add them the same way you do addition by hand — digit by digit,
 * managing carry if sum > 9.
 *
 * ---------------------------------------------------------
 * 💭 INTUITION:
 * When you add numbers on paper (like 342 + 465),
 * you start from the *rightmost digits* → 2+5=7, then move left.
 * Here, since digits are stored in reverse order in the linked list
 * (ones place comes first), we can simply traverse from head to tail.
 *
 * So at each node:
 * 1️⃣ Take one digit from each list (if present)
 * 2️⃣ Add them along with any previous carry
 * 3️⃣ Create a new node for the current sum’s last digit
 * 4️⃣ Carry forward the tens digit (if any)
 *
 * The process continues until both lists and carry are finished.
 *
 * ---------------------------------------------------------
 * 🧾 FORMULA:
 * For each digit:
 * sum = x + y + carry
 * carry = sum / 10
 * newNodeValue = sum % 10
 *
 * ---------------------------------------------------------
 * 🔑 KEY TO REMEMBER:
 * ✅ Always handle carry properly
 * ✅ Loop until both lists end AND carry becomes 0
 * ✅ Use dummy node to simplify head pointer handling
 * ✅ Don’t convert entire number to integer (overflow risk)
 *
 * ---------------------------------------------------------
 * 💣 BRUTE FORCE APPROACH:
 * Convert linked lists into actual numbers, add them, then rebuild list.
 * ❌ Risk: Overflow for large numbers.
 * ❌ Time: O(max(m, n))
 * ❌ Space: O(1) (but unsafe for large inputs)
 *
 * ---------------------------------------------------------
 * ⚡ OPTIMAL APPROACH:
 * Traverse both lists simultaneously, add digits with carry.
 * ✅ Safe for large numbers
 * ✅ Time: O(max(m, n))
 * ✅ Space: O(1)
 *
 * ---------------------------------------------------------
 * 🔍 SMALL DRY RUN (OPTIMAL):
 * l1 = [2, 4, 3]
 * l2 = [5, 6, 4]
 * carry = 0
 *
 * Step 1: 2 + 5 + 0 = 7 → carry=0 → list: [7]
 * Step 2: 4 + 6 + 0 = 10 → carry=1 → list: [7,0]
 * Step 3: 3 + 4 + 1 = 8 → carry=0 → list: [7,0,8]
 * ✅ Output: [7,0,8]
 */

public class AddTwoNumbers {

    // 🔹 BRUTE FORCE APPROACH
    public ListNode addTwoNumbersBruteForce(ListNode l1, ListNode l2) {

        long num1 = 0;
        long num2 = 0;
        long place = 1;

        // Convert first list to number
        ListNode temp1 = l1;
        while (temp1 != null) {
            num1 += temp1.data * place;
            place *= 10;
            temp1 = temp1.next;
        }

        // Reset place for second list
        place = 1;
        ListNode temp2 = l2;
        while (temp2 != null) {
            num2 += temp2.data * place;
            place *= 10;
            temp2 = temp2.next;
        }

        // Add both numbers
        long sum = num1 + num2;

        // Convert back to linked list
        if (sum == 0) return new ListNode(0);

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while (sum > 0) {
            curr.next = new ListNode((int) (sum % 10));
            sum /= 10;
            curr = curr.next;
        }

        return dummy.next; // ✅ Return head of the new list
    }

    // 🔹 OPTIMAL APPROACH
    public ListNode addTwoNumbersOptimal(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        int carry = 0;

        // Loop until both lists end or carry becomes 0
        while (l1 != null || l2 != null || carry != 0) {
            int x = (l1 != null) ? l1.data : 0;
            int y = (l2 != null) ? l2.data : 0;
            int sum = x + y + carry;

            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        return dummy.next; // ✅ Head of new linked list
    }

    // 🔹 MAIN METHOD for Testing
    public static void main(String[] args) {
        // Example: (2 → 4 → 3) + (5 → 6 → 4)
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        AddTwoNumbers solution = new AddTwoNumbers();

        // Uncomment to test brute force (may overflow for big numbers)
        // ListNode resultBrute = solution.addTwoNumbersBruteForce(l1, l2);

        // ✅ Optimal approach
        ListNode result = solution.addTwoNumbersOptimal(l1, l2);

        // Print result: Expected [7 → 0 → 8]
        System.out.print("Result: ");
        while (result != null) {
            System.out.print(result.data);
            if (result.next != null) System.out.print(" → ");
            result = result.next;
        }
    }
}

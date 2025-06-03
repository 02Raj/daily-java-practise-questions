package neetcode.slidingwindow.fixedsize;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class FirstNegativeInteger {
    public static List<Integer> firstNegativeInteger(int[] arr, int k) {
        List<Integer> result = new ArrayList<>();

        // Queue banayi jisme sirf negative numbers ke indexes store karenge
        Deque<Integer> q = new LinkedList<>();

        int left = 0, right = 0;

        // Jab tak pura array traverse nahi ho jaata
        while (right < arr.length) {

            // Agar current element negative hai, to uska index queue me daal do
            if (arr[right] < 0) {
                q.addLast(right); // ❗ Index store kar rahe hain, value nahi
            }

            // Window ka size abhi chhota hai (k se chhota) to right ko aage badhao
            if (right - left + 1 < k) {
                right++;
            }

            // Jab window ka size exactly k ho jaaye
            else if (right - left + 1 == k) {

                // ✅ Queue empty nahi hai → matlab negative number present hai
                // Queue ka front index leke uski value result list me daal do
                if (!q.isEmpty()) {
                    result.add(arr[q.peek()]);
                } else {
                    result.add(0); // ❌ Agar koi negative nahi mila to 0 daalo
                }

                // 🧹 Check karo: kya queue ka front index window ke left ke barabar hai?
                // Agar haan → iska matlab woh element ab window ke bahar jaa raha hai
                // ➡ To queue se us index ko hata do
                if (!q.isEmpty() && q.peek() == left) {
                    q.poll(); // queue se nikal diya
                }

                // 🏃 Window ko aage slide karo
                left++;
                right++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        FirstNegativeInteger obj = new FirstNegativeInteger();
        int[] arr =  {12, -1, -7, 8, -15, 30, 16, 28};
        int k = 3;

        // Output: Har window of size k ka first negative number
        System.out.println("First negative integer in each window of size " + k + " is: " + obj.firstNegativeInteger(arr, k));
    }
}

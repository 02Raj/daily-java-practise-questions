package stack;

import java.util.Scanner;
import java.util.Stack;

public class DuplicateBracker {

    public static void main(String[] args) {
//        Scanner scn = new Scanner(System.in);
//        System.out.println("Enter an expression:");
//        String str = scn.nextLine();
        String str = "((a+b))";
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch == ')') {
                // If the top of the stack is an opening parenthesis, it means we found a duplicate bracket.
                // For example, "((a+b))" -> when the second ')' is encountered, '(' will be at the stack top.
                // Or "()" -> when ')' is encountered, '(' will be at the stack top.
                if (st.peek() == '(') {
                    System.out.println(true); // Duplicate found
                    return; // Exit the program
                } else {
                    // Pop elements from the stack until an opening parenthesis is found.
                    // This removes the content inside the current pair of parentheses.
                    while (st.peek() != '(') {
                        st.pop();
                    }
                    st.pop(); // Pop the opening parenthesis itself
                }
            } else {
                // For any character other than a closing parenthesis, push it onto the stack.
                st.push(ch);
            }
        }

        // If the loop completes without finding any duplicate brackets, print false.
        System.out.println(false);
//        scn.close(); // Close the scanner
    }
}

package stack;

import java.util.Stack;

public class BalancedBracket {

    public static void main(String[] args) {
        String str = "{[()]}"; // Test string

        Stack<Character> st = new Stack<>();
        boolean isBalanced = true;

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch == '(' || ch == '{' || ch == '[') {
                st.push(ch);
            } else if (ch == ')') {
                if (!handleClosing(st, '(')) {
                    isBalanced = false;
                    break;
                }
            } else if (ch == '}') {
                if (!handleClosing(st, '{')) {
                    isBalanced = false;
                    break;
                }
            } else if (ch == ']') {
                if (!handleClosing(st, '[')) {
                    isBalanced = false;
                    break;
                }
            }
        }

        if (isBalanced && st.isEmpty()) {
            System.out.println("Balanced");
        } else {
            System.out.println("Not Balanced");
        }
    }

    public static boolean handleClosing(Stack<Character> st, char expectedOpening) {
        if (st.isEmpty()) {
            return false;
        } else if (st.peek() != expectedOpening) {
            return false;
        } else {
            st.pop();
            return true;
        }
    }
}

package stack;

import java.util.Scanner;
import java.util.Stack;

public class InfixEvaluation {
    // Method: precedence check
    public static int precedence(char op) {
        switch (op) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    // Method: do operation
    public static int applyOp(int a, int b, char op) {
        switch (op) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            case '/': return a / b; // assume b != 0
        }
        return 0;
    }

    // Evaluate infix expression
    public static int evaluate(String expression) {
        Stack<Integer> values = new Stack<>(); // stack for numbers
        Stack<Character> ops = new Stack<>();  // stack for operators

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            // Agar space ho to skip
            if (c == ' ')
                continue;

            // Agar digit ho
            if (Character.isDigit(c)) {
                values.push(c - '0'); // convert char to int
            }

            // Agar opening bracket
            else if (c == '(') {
                ops.push(c);
            }

            // Agar closing bracket
            else if (c == ')') {
                while (ops.peek() != '(') {
                    int b = values.pop();
                    int a = values.pop();
                    char op = ops.pop();
                    values.push(applyOp(a, b, op));
                }
                ops.pop(); // '(' ko remove karo
            }

            // Agar operator
            else {
                while (!ops.isEmpty() && precedence(ops.peek()) >= precedence(c)) {
                    int b = values.pop();
                    int a = values.pop();
                    char op = ops.pop();
                    values.push(applyOp(a, b, op));
                }
                ops.push(c);
            }
        }

        // remaining operations
        while (!ops.isEmpty()) {
            int b = values.pop();
            int a = values.pop();
            char op = ops.pop();
            values.push(applyOp(a, b, op));
        }

        return values.pop();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter an infix expression (single-digit only): ");
        String exp = sc.nextLine();

        int result = evaluate(exp);
        System.out.println("Result: " + result);
    }
}

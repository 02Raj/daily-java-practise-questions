package string;

public class RemoveOuterParentheses {

    /*
     ---------------------------------------------------------
                     🟩 PROBLEM STATEMENT
     ---------------------------------------------------------
     Given a valid parentheses string S, return the string
     after removing the outermost parentheses of each primitive
     substring.

     Example:
       Input:  "(()())(())"
       Output: "()()()"

     ---------------------------------------------------------
                     🟩 STORY POINTS (WHAT YOU LEARN)
     ---------------------------------------------------------
     ✔ Understanding of primitive parentheses blocks
     ✔ How depth changes when '(' comes and ')' comes
     ✔ How to detect outermost parentheses
     ✔ Using StringBuilder efficiently
     ✔ Simple stack-depth approach without actual Stack

     ---------------------------------------------------------
                     🟩 INTUITION
     ---------------------------------------------------------
     • Jab '(' mile → depth++
     • Jab ')' mile → depth--
     • Outer parentheses woh hote hain jaha depth == 1
     • Isliye hum sirf un parentheses ko ignore karenge
       jinka depth == 1 hone wala ho.

     ---------------------------------------------------------
                     🟩 APPROACH (VERY SIMPLE)
     ---------------------------------------------------------
     LOOP over characters of S:
       1. If '(':
             depth++ karo
             Agar depth > 1 → yeh outer nahi hai → add to result
       2. If ')':
             Agar depth > 1 → yeh outer nahi hai → add to result
             depth-- karo

     Return result.

     ---------------------------------------------------------
                     🟩 SMALL DRY RUN (IMPORTANT)
     ---------------------------------------------------------
     Input:  "(()())"

           ch   depth(before)  action           result
           -------------------------------------------
           '('      0          depth=1          ""   (outer → skip)
           '('      1          depth=2          "("
           ')'      2          add ")"          "()"
                        depth=1
           '('      1          depth=2          "()("
           ')'      2          add ")"          "()()"
                        depth=1
           ')'      1          depth=0          ""   (outer → skip)

     Output = "()()"

     ---------------------------------------------------------
                     🟩 KEY TO REMEMBER (SUPER KEY)
     ---------------------------------------------------------
     ✔ TX = depth++ (when '(' comes BEFORE checking)
     ✔ SC = depth-- (when ')' comes AFTER checking)

     ✔ OUTER PARENTHESIS = depth == 1
     ✔ Add only when depth > 1
     ---------------------------------------------------------
    */

    public String removeOuterParentheses(String s) {
        int depth = 0;
        StringBuilder result = new StringBuilder();

        for (char ch : s.toCharArray()) {

            if (ch == '(') {
                // Increase depth first
                depth++;

                // Add only when depth > 1 (means NOT OUTER)
                if (depth > 1) {
                    result.append(ch);
                }

            } else {
                // For closing bracket:
                // Add only when depth > 1 (means NOT OUTER)
                if (depth > 1) {
                    result.append(ch);
                }

                // Now decrease depth
                depth--;
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {

        RemoveOuterParentheses obj = new RemoveOuterParentheses();

        String input = "(()())(())";
        String output = obj.removeOuterParentheses(input);

        System.out.println("Input : " + input);
        System.out.println("Output: " + output);
    }
}

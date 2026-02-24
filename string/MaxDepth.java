package string;

public class MaxDepth {

    /*
     ---------------------------------------------------------
      Problem Statement:
     ---------------------------------------------------------
     Given a string containing parentheses, return the
     maximum nesting depth of the parentheses.

     Example:
     Input:  "(1+(2*3)+((8)/4))+1"
     Output: 3

     Meaning → The deepest level of "(" inside "(" inside "(" is 3.

     ---------------------------------------------------------
      Intuition:
     ---------------------------------------------------------
     - Whenever we see an opening bracket '(', we go one level deeper.
     - Whenever we see a closing bracket ')', we come one level up.
     - The highest value of “depth” we ever reach is the answer.

     Think of it like:
     '(' → going down stairs → depth++
     ')' → going up stairs → depth--

     ---------------------------------------------------------
      Approach (Step-by-Step):
     --------------------------------------------------------
     1. Initialize depth = 0 and maxDepth = 0
     2. Loop through every character:
        - If '(' → depth++
          → Update maxDepth = max(maxDepth, depth)
        - If ')' → depth--
     3. Final maxDepth is the deepest nested level.

     ---------------------------------------------------------
      Why this works:
     ---------------------------------------------------------
     Depth directly tells us how many parentheses are currently open.
     Maximum of this value = maximum nesting.

     ---------------------------------------------------------
     ⏱ Time Complexity (TC):
     ---------------------------------------------------------
     O(n)
     → We scan each character once.

     ---------------------------------------------------------
      Space Complexity (SC):
     ---------------------------------------------------------
     O(1)
     → Only two integer variables used (depth, maxDepth)

     ---------------------------------------------------------
      Key To Remember:
     ---------------------------------------------------------
     - '(' → depth++
     - ')' → depth--
     - Track maximum depth during traversal
     - Works only because parentheses are balanced in question

     ---------------------------------------------------------
     */

    public int maxDepth(String s){
        int depth = 0;
        int maxDepth = 0;

        for (char c : s.toCharArray()){

            if (c == '('){
                depth++;
                maxDepth = Math.max(maxDepth, depth);
            }
            else if (c == ')'){
                depth--;
            }
        }

        return maxDepth;
    }

    public static void main(String[] args) {
        MaxDepth md = new MaxDepth();
        String s = "(1+(2*3)+((8)/4))+1";
        System.out.println(md.maxDepth(s));  // Output: 3
    }
}

package withoutrecursion;

import java.util.Stack;

public class ValidParentheses {


    public static void main(String[] args) {
        ValidParentheses  validParentheses = new ValidParentheses();
        String testString = "() {} []";
        System.out.println("Is \"" + testString + "\" valid? " + validParentheses.isValid(testString));
        testString = "([)]";
        System.out.println("Is \"" + testString + "\" valid? " + validParentheses.isValid(testString));

       }


    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length() ; i++){
            char c = s.charAt(i);

            if( c == '('){
                stack.push(')');
               }else if( c == '{'){
                stack.push('}');
                }else if (c == '['){
                stack.push(']');
            } else {
                if( stack.isEmpty() || stack.pop() != c){
                   return false;
                }
            }
        }
  return stack.isEmpty();
    }
}

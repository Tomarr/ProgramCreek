import java.util.Stack;

/**
 * Created by RT033812 on 3/9/2017.
 */

//Evaluate the value of an arithmetic expression in Reverse Polish Notation. Valid
//operators are +, -, *, /. Each operand may be an integer or another expression. For
//    example:
//    ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
//    ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
public class RPN {

    public static int calRPN(String[] token) {

        int returnValue = 0;
        String operations = "+-*/";

        Stack<String> stack = new Stack<String>();

        for (String t : token) {
            if (!operations.contains(t)) {
                stack.push(t);
            } else {
                int a = Integer.valueOf(stack.pop());
                int b = Integer.valueOf(stack.pop());

                switch(t) {  // switch for String is applicable for java 1.7 and higher version
                    case "+":
                        stack.push(String.valueOf(a + b));
                        break;
                    case "-":
                        stack.push(String.valueOf(a - b));
                        break;
                    case "*":
                        stack.push(String.valueOf(a * b));
                        break;
                    case "/":
                        stack.push(String.valueOf(a / b));

                }
            }
        }

        returnValue += Integer.valueOf(stack.pop());

        return returnValue;

    }

    public static void main(String[] args) {

        String[] token = new String[]{"2", "1", "+", "3", "*"};

        System.out.println(calRPN(token));
    }
}

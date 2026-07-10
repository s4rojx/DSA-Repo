package Stack;

import java.util.*;

public class PrefixConversion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String exp = sc.next();
        Stack<Integer> valueStack = new Stack<>();
        Stack<String> infix = new Stack<>();
        Stack<String> postfix = new Stack<>();
        for (int i = exp.length() - 1; i >= 0; i--) {
            char ch = exp.charAt(i);
            if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {

                // Evaluation
                int v1 = valueStack.pop();
                int v2 = valueStack.pop();
                int val = operation(v1, v2, ch);
                valueStack.push(val);

                // Infix conversion
                String inV1 = infix.pop();
                String inV2 = infix.pop();
                String inVal = "(" + inV1 + ch + inV2 + ")";
                infix.push(inVal);

                // Postfix conversion
                String poV1 = postfix.pop();
                String poV2 = postfix.pop();
                String poVal = poV1 + poV2 + ch;
                postfix.push(poVal);
            } else {
                valueStack.push(ch - '0');
                infix.push(ch + "");
                postfix.push(ch + "");
            }
        }
        System.out.println(valueStack.pop());
        System.out.println(infix.pop());
        System.out.println(postfix.pop());
    }

    public static int operation(int a, int b, char c) {
        if (c == '+') {
            return a + b;

        }
        if (c == '-') {
            return a - b;
        }
        if (c == '*') {
            return a * b;
        }
        if (c == '/') {
            return a / b;
        }
        return -1;
    }

}

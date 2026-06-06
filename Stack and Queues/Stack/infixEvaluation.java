package Stack;

import java.util.*;

public class infixEvaluation {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        Stack<Integer> opnd = new Stack<>();//operand stack
        Stack<Character> optor = new Stack<>(); //operator stack
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == ' ') continue;
            if (ch == '(') {
                optor.push(ch);
            } else if (Character.isDigit(ch)) {
                opnd.push(ch - '0');
            } else if (ch == ')') {
                // if we encounter closing bracket until we get opening bracket =>
                // pop a operator and 2 operand -> perform operation and push result to operand stack
                while (optor.peek() != '(') {
                    char op = optor.pop();
                    int v2 = opnd.pop();
                    int v1 = opnd.pop();
                    int opv = operation(v1, v2, op);
                    opnd.push(opv);
                }
                //extra pop for the opening bracket
                optor.pop();
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '%' || ch == '^') {
                //ch wanting higher priority to solve first
                //if incoming operator smaller priority than tos then first perform operation for tos then
                // push result into the operand stack and push the operand to the operand stack
                while (!optor.isEmpty() && optor.peek() != '(' && precedence(ch) <= precedence(optor.peek())) {
                    char op = optor.pop();
                    int v2 = opnd.pop();
                    int v1 = opnd.pop();
                    int opv = operation(v1, v2, op);
                    opnd.push(opv);
                }
                //ch pushing itself
                optor.push(ch);
            }
        }
        while (!optor.isEmpty()) {
            char op = optor.pop();
            int v2 = opnd.pop();
            int v1 = opnd.pop();
            int opv = operation(v1, v2, op);
            opnd.push(opv);
        }
        System.out.println(opnd.peek());

    }

    static int precedence(char op) {
        if (op == '+' || op == '-') {
            return 1;
        }
        if (op == '*' || op == '/' || op == '%') {
            return 2;
        } else {
            return 3;
        }
    }

    static int operation(int v1, int v2, char op) {
        switch (op) {
            case '+':
                return v1 + v2;
            case '-':
                return v1 - v2;
            case '*':
                return v1 * v2;
            case '/':
                return v1 / v2;
            case '%':
                return v1 % v2;
            case '^':
                return (int) Math.pow(v1, v2);
        }
        return 0;
    }
}

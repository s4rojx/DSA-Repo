package Stack;

import java.util.*;

public class SmallestNumberFollowingPattern {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        Stack<Integer> st = new Stack<>();
        int p = 1;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch == 'd') {
                st.push(p++);
            } else {
                st.push(p++);
                while (!st.isEmpty()) {
                    System.out.print(st.pop() + " ");
                }
            }
        }
        st.push(p);
        while(!st.isEmpty()){
            System.out.print(st.pop()+" ");
        }

    }
}
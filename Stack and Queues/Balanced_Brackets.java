import java.io.*;
import java.util.*;

public class Balanced_Brackets {

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        StringBuilder out = new StringBuilder();
        String s = sc.nextLine();
        Stack <Character> st = new Stack<>();
        for (int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch == '(' ||ch == '{' || ch =='['){
                st.push(ch);
            }else if(ch ==')'){
                if(st.size() == 0){
                    out.append(false);
                    System.out.print(out);
                    return;
                }else if(st.peek() !='('){
                    out.append(false);
                    System.out.print(out);
                    return;
                }else st.pop();
            }else if(ch =='}'){
                if(st.size() == 0){
                    out.append(false);
                    System.out.print(out);
                    return;
                }else if(st.peek() !='{'){
                    out.append(false);
                    System.out.print(out);
                    return;
                }else st.pop();

            }else if(ch ==']'){
                if(st.size() == 0){
                    out.append(false);
                    System.out.print(out);
                    return;
                }else if(st.peek() !='['){
                    out.append(false);
                    System.out.print(out);

                    return;
                }else st.pop();
            }
        }
        if (!st.isEmpty()){
            out.append(false);
        }else {
            out.append(true);
        }
        //Code

        System.out.print(out);
    }
}
import java.io.*;
import java.util.*;

public class NextGreaterElementAlt {

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
        Stack<Integer> st = new Stack<>();
        int n = sc.nextInt();
        int [] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int [] nge = new int[n];
        //Here dont put element ot stack rather put the index of the element to stack
        st.push(0);
        for(int i=1;i<n;i++){
            while(!st.isEmpty() && arr[i]>arr[st.peek()]){
                int pos = st.peek();
                nge[pos] = arr[i];
                st.pop();

            }
            st.push(i);
        }
            while(st.size() > 0){
                int pos = st.peek();
                nge[pos] = -1;
                st.pop();
            }

        out.append(Arrays.toString(nge));

        System.out.print(out);
    }
}
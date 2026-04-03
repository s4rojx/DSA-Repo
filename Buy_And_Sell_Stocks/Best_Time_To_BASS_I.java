import java.io.*;
import java.util.*;

public class Best_Time_To_BASS_I {

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
        int n = sc.nextInt();
        int [] prices = new int[n];
        for (int i = 0; i < n; i++) {
            prices[i] = sc.nextInt();

        }//lsf ->least so far,op, op-> Overall profit, pist-> Profit if sold today
        int lsf = Integer.MAX_VALUE;
        int op=0,pist=0;
        for (int i = 0; i < n; i++) {
            if(prices[i]<lsf){
                lsf = prices[i];
            }
            pist = prices[i]-lsf;
            if(pist>op){
                op=pist;
            }
        }
        out.append(op).append("\n");
        System.out.print(out);
    }
}
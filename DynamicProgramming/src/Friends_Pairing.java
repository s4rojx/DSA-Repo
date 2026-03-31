import java.io.*;
import java.util.*;

public class Friends_Pairing {

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

        //Code
        int n= sc.nextInt();
        int [] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2]= 2 ;
        for(int i=3;i<=n;i++){
            dp[i] = dp[i-1]+(i-1)*dp[i-2];
        }
        out.append(dp[n]).append("\n");
        System.out.print(out);
    }
}
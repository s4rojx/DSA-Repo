import java.io.*;
import java.util.*;

public class Buy_And_Sell_Stocks_IV {

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
        int [] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int [][] dp= new int[n][3];
        dp[0][0] = -arr[0]; // bsp(buy state profit) bought stock
        dp[0][1] = 0; // ssp(sell state profit) did nothing
        dp[0][2] = 0; //csp(Cooldown State Profit)
        for (int i = 1; i <n; i++) {
            dp[i][0] = Math.max((dp[i-1][0]),(dp[i-1][2]-arr[i])); //dp[i][0] → max profit on day i when you HOLD a stock
            dp[i][1] = Math.max(dp[i-1][1] , (dp[i-1][0] +arr[i]));
            dp[i][2] = Math.max(dp[i-1][2],dp[i-1][1]);
        }
        out.append(dp[n-1][1]).append("\n");
        System.out.print(out);
    }
}
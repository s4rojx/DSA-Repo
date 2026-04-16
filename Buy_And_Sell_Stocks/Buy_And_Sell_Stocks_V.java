import java.io.*;
import java.util.*;

public class Buy_And_Sell_Stocks_V {

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

        // Create a fast input reader (faster than normal Scanner)
        FastScanner sc = new FastScanner();

        // StringBuilder is used to build the output efficiently
        StringBuilder out = new StringBuilder();

        // Read the number of days (size of array)
        int n = sc.nextInt();

        // Create an array to store stock prices for n days
        int[] arr = new int[n];

        // Read all the stock prices into the array
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Variable to store maximum profit if we sell today (using one transaction)
        int mpist = 0;

        // Variable to keep track of the lowest stock price seen so far from the left
        int leastsf = arr[0];

        // dpL[i] will store the maximum profit we can make with at most 1 transaction
        // using prices from day 0 to day i
        int[] dpL = new int[n];

        // Loop to fill the dpL array (Left to Right)
        for (int i = 1; i < n; i++) {

            // If current price is lower than leastsf, update leastsf (better buying price)
            if (leastsf > arr[i]) {
                leastsf = arr[i];
            }

            // Calculate profit if we buy at leastsf and sell today (on day i)
            mpist = arr[i] - leastsf;

            // Store the best profit so far up to day i
            // Either the profit if sold today, or the previous best profit
            if (mpist > dpL[i-1]) {
                dpL[i] = mpist;
            } else {
                dpL[i] = dpL[i-1];
            }
        }

        // Variable to store maximum profit if we buy today and sell later
        int maxpibt = 0;

        // Variable to keep track of the highest stock price seen so far from the right
        int maxat = arr[n-1];

        // dpr[i] will store the maximum profit we can make with at most 1 transaction
        // using prices from day i to the last day
        int[] dpr = new int[n];

        // Loop to fill the dpr array (Right to Left - going backwards)
        for (int i = n-2; i >= 0; i--) {

            // If current price is higher than maxat, update maxat (better selling price in future)
            if (arr[i] > maxat) {
                maxat = arr[i];
            }

            // Calculate profit if we buy today (day i) and sell at maxat (best future price)
            maxpibt = maxat - arr[i];

            // Store the best profit from day i onwards
            // Either the profit if bought today, or the previous best (from right side)
            if (maxpibt > dpr[i+1]) {
                dpr[i] = maxpibt;
            } else {
                dpr[i] = dpr[i+1];
            }
        }

        // Variable to store the final maximum profit with at most 2 transactions
        int op = 0;

        // Check every possible day i as the splitting point between two transactions
        // Add profit from first transaction (left) + second transaction (right)
        for (int i = 0; i < n; i++) {
            if (dpL[i] + dpr[i] > op) {
                op = dpL[i] + dpr[i];
            }
        }

        // Append the final answer to output
        out.append(op).append("\n");

        // Print the final result
        System.out.print(out);
    }
}
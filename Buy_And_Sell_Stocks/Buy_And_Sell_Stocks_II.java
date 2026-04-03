import java.io.*;
import java.util.*;

public class Buy_And_Sell_Stocks_II {

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
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();;
        }
        //Initially buying date-> 0, selling date-> 0, profit -> 0
        int bd = 0,sd=0,profit = 0;
        for (int i = 1; i < arr.length; i++) {
            if(arr[i]>=arr[i-1]){
                sd ++; //we go to the selling date by incrementing the sd
            }
            else { //if tomorrow's price < today's then collect the profit and point both buy date and sell date to today

                profit += arr[sd] - arr[bd];
                bd = sd = i;
            }
        }
        profit += arr[sd] - arr[bd];
        out.append(profit).append("\n");
        System.out.print(out);
    }
}
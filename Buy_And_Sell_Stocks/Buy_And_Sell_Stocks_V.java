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
        FastScanner sc = new FastScanner();
        StringBuilder out = new StringBuilder();
        int n = sc.nextInt();
        int [] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int mpist = 0; //max profit if sold today
        int leastsf = arr[0]; //least so far
        int [] dpL = new int[n]; //[DP on left]maximum profit if sold upto today
        for (int i = 1; i < n; i++) {
            if(leastsf >arr[i]){
                leastsf = arr[i];
            }
            mpist = arr[i] - leastsf;
            if(mpist > dpL[i-1]){
                dpL[i] = mpist;
            }
            else
                dpL[i] = dpL[i-1];
        }
        int maxpibt = 0; //max profit if brought today
        int maxat = arr[n-1]; //max after today
        int [] dpr = new int[n];//dp on right array
        for (int i = n-2; i >=0; i--) {
            if(arr[i]>maxat){
                maxat = arr[i];
            }
            maxpibt = maxat - arr[i];
            if(maxpibt > dpr[i+1]){
                dpr[i] = maxpibt;
            }
            else
                dpr[i] = dpr[i+1];
        }
        int op = 0;
        for (int i = 0; i < n; i++) {
            if(dpL[i]+dpr[i]>op)
                op = dpL[i]+dpr[i];
        }
        out.append(op).append("\n");
        System.out.print(out);
    }
}
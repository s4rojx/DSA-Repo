import java.io.*;
import java.util.*;

public class Bit_manipulation {

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
        int i = sc.nextInt();
        int j = sc.nextInt();
        int k = sc.nextInt();
        int m = sc.nextInt();

        int onmask = (1<<i);
        int offmask = ~(i<<j);
        int tmask = (i<<k);
        int checkmask = (1<<m);

        System.out.println(n | onmask);
        System.out.println(n & offmask);
        System.out.println(n ^ tmask);
        System.out.println((n & checkmask) ==0 ? false : true);

        //Code

        System.out.print(out);
    }
}
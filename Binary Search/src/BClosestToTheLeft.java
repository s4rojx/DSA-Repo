import java.io.*;
import java.util.*;

public class BClosestToTheLeft {

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
        int t = sc.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(sc.nextInt());
        }
        while (t-- > 0) {
            int p = sc.nextInt();
            int ans = upperBound(arr,p);
            out.append(ans).append("\n");
        }

        System.out.print(out);
    }

    public static boolean check(int m, int x) {
        return m > x;
    }

    public static int upperBound(ArrayList<Integer> arr, int x) {
        int low = 0;
        int high = arr.size() - 1;
        int ans = arr.size();
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (check(arr.get(mid), x)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}

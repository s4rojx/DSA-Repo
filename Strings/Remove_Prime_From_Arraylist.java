import java.io.*;
import java.util.*;

public class Remove_Prime_From_Arraylist {

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
    public static Boolean isPrime(int n){
        if(n<=1)
            return false;
        for (int i = 2; i*i <= n ; i++) {
            if(n%i==0)
                return false;
        }

        return true;
    }
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        StringBuilder out = new StringBuilder();
        ArrayList<Integer> list = new ArrayList<>();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }
        for (int i = list.size()-1; i >=0  ; i--) {
            int val = list.get(i);
            if(isPrime(val)){
                list.remove(i);
            }
        }
        //Code
        out.append(list).append("\n");
        System.out.print(out);
    }
}
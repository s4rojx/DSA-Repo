import java.io.*;
import java.util.*;

public class String_Compression {

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
    public static String compression1(String str ){
        String s = String.valueOf(str.charAt(0));
        for(int i=1;i<str.length();i++){
            char curr = str.charAt(i);
            char prev = str.charAt(i-1);
            if(curr != prev){
                s +=curr;
            }
        }
        return s;
    }
    public static String compression2(String str){
        String s = String.valueOf(str.charAt(0));
        int cnt =1;
        for(int i=1;i<str.length();i++){
            char curr = str.charAt(i);
            char prev = str.charAt(i-1);

            if(curr == prev)
                cnt ++;
            else {
                if(cnt>1){
                    s+=cnt;
                    cnt=1;
                }
                s+=curr;
            }

        }
        if(cnt>1){
            s+=cnt;
        }
        return s;
    }
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        StringBuilder out = new StringBuilder();
        String s = sc.nextLine();
        out.append(compression1(s)).append("\n");
        out.append(compression2(s)).append("\n");

        System.out.print(out);
    }


}
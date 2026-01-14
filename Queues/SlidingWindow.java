package Queues;
import java.io.*;
import java.util.Stack;

public class SlidingWindow {
     static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [] arr = new int[n];
        int [] nge = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] =Integer.parseInt(br.readLine());
        }

        int k = Integer.parseInt(br.readLine());
        Stack <Integer> st = new Stack<>();
        st.push(arr.length - 1);
        nge[n-1] = n;
        for (int i = n-2 ; i >=0 ; i--) {
            while (!st.isEmpty() && arr[i] > arr[st.peek()]){
                st.pop();
            }
            if(st.isEmpty()){
                nge[i] = n;
            }
            else{
                nge[i] = st.peek();
            }
            st.push(arr[i]);

        }
         int[] res = new int[n - k + 1];
         int p= 0;
         int j= 0;
        for(int i = 0; i < n - k; i++) {
                if(j<i){
                    j =i;
                }
                while (nge[j] < i + k){
                    j = nge[j];
                }

            res[p++] = nge[j];
        }
         System.out.println(res);
    }
}



import java.util.*;

public class StockSpan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int [] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        st.push(0);
        ans[0]=1;
        for (int i = 1; i< n ; i++) {
            //jab tak stack khali na ho jaata ya phir
             while (!st.isEmpty() && arr[i]>arr[st.peek()]){
                st.pop();
             }
             //If stack empty then answer is (index+1)
             if(st.isEmpty()) {
                ans[i]= i+1;
             }
             //if stack not empty then answer is (current index - tos index)
             else{
                ans[i]= i-st.peek();
             }
             st.push(i);
        }
        System.out.print(Arrays.toString(ans));

    }
}
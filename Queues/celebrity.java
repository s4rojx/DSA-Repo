package Queues;
import java.util.*;
public class celebrity {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [][] arr = new int[n][n];
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        findCelebrity(arr);
    }

    private static void findCelebrity(int[][] arr) {
    Stack <Integer> st = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            st.push(i);
        }
        while(st.size() >=2){
            int i = st.pop();
            int j = st.pop();

            if(arr[i][j]==1){
                //if i knows j then , i isn't a celebrity
                st.push(j);
            }
            if(arr[i][j]==0){
                //if i doesn't knows j then , j isn't a celebrity
                st.push(i);
            }
        }
        int pot = st.pop();
        for (int i = 0; i < arr.length; i++) {
            if(i != pot){
                if(arr[i][pot]==0 || arr[pot][i] ==1){
                    System.out.println("none");
                    return;
                }
            }
        }
        System.out.println(pot);
    }
}

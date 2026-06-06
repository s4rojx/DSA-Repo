package Stack;
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
        while(st.size() >=2)// until we have 2 or more than 2 people in stack
        {
            //pop 2
            int i = st.pop();
            int j = st.pop();
            //this is the check for if i knows j
            if(arr[i][j]==1){
                //if i knows j then , i isn't a celebrity but j is potentially a celebrity
                st.push(j);
            }
            else{
                //if i doesn't know j then i is potentially a celebrity
                st.push(i);
            }
        }
        int pot = st.pop();//potential celebrity ko pop karke store karo
        for (int i = 0; i < arr.length; i++) {
            if(i != pot){
                //if there exist some i that doesnt know pot
                //or there exist some i to whom i knows then pot isnt a celebrity
                if(arr[i][pot]==0 || arr[pot][i] ==1){
                    System.out.println("none");
                    return;
                }
            }
        }
        System.out.println(pot);
    }
}

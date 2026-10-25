package Sliding_Window;

import java.util.*;

public class FirstNegativeIntegerInEveryWindowK {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        ArrayList<Integer> ans = new ArrayList<>();
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (arr[i] < 0) {
               q.addLast(i);
            }
            if(i>= k-1){
                while(!q.isEmpty() && q.peekFirst() < i - k + 1){
                    q.pollFirst();
                }
                if(q.isEmpty()){
                    ans.add(0);
                }else {
                    ans.add(arr[q.peekFirst()]);
                }
            }
        }
        System.out.println(ans);

    }

}

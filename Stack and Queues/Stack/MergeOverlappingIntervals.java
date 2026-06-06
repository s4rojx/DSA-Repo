package Stack;

import java.util.*;

public class MergeOverlappingIntervals {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] sArr = new int[n];
        int[] eArr = new int[n];
        for (int i = 0; i < n; i++) {
            sArr[i] = sc.nextInt();
            eArr[i] = sc.nextInt();

        }
        Stack<Integer> start = new Stack<>();
        Stack<Integer> end = new Stack<>();
        start.push(sArr[0]);
        end.push(eArr[0]);
        for (int i = 1; i < n; i++) {
            if(sArr[i]<=end.peek()){
                int fEndTime = Math.max(eArr[i], end.peek());
                if(fEndTime !=end.peek()){
                    end.pop();
                    end.push(fEndTime);
                }
            }


        }

    }
}
package Sliding_Window;

import java.util.*;

public class SlidingWindowMaximum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        ArrayList<Integer> ans = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < k; i++) {
            max = Math.max(max, arr[i]);
        }
        ans.add(max);
        for (int i = k; i < n; i++) {
            int leaving = arr[i - k];
            int entering = arr[i];
            if (leaving == max) {
                max = Integer.MIN_VALUE;
                for (int j = i - k + 1; j <= i; j++) {
                    max = Math.max(arr[j], max);
                }
            } else {
                max = Math.max(max, entering);
            }
            ans.add(max);
        }
        System.out.println(ans);

    }
}
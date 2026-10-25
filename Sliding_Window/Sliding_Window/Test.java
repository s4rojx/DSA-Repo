package Sliding_Window;

import java.util.*;

public class Test {
    static void main() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {

            sum += arr[i];

            if (i >= k - 1) {
                maxSum = Math.max(maxSum, sum);
                sum -= arr[i - k + 1];
            }


        }
        System.out.println(maxSum);

    }
}
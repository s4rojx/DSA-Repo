package DP_BasicsToAdv;

import java.util.*;

public class KnapsackRecursion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int[] val = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            val[i] = sc.nextInt();
        }
        int w = sc.nextInt();
        int[][] dp = new int[n + 1][w + 1];
        int ans = knapsack(arr, val, w, n, dp);
        System.out.println(ans);
    }

    public static int knapsack(int wt[], int[] val, int w, int n, int[][] dp) {
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= w; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (wt[i - 1] <= j) {
                    dp[i][j] = Math.max(
                            val[i - 1] + dp[i - 1][j - wt[i - 1]],
                            dp[i - 1][j]
                    );
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][w];
    }
}
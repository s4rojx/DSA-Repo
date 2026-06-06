package DP_BasicsToAdv;

import java.util.*;

public class SubsetSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int sum = sc.nextInt();
        boolean[][] dp = new boolean[n + 1][sum + 1];
        boolean ans = knap(arr, n, sum, dp);
        System.out.println(ans);
    }

    private static boolean knap(int[] arr, int n, int sum, boolean[][] dp) {
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }
        for (int j = 1; j <= sum; j++) {
            dp[0][j] = false;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (arr[i - 1] <= j) {
                    dp[i][j] = dp[i-1][j-arr[i-1]] || dp[i-1][j];
                }
                else
                    dp[i][j] = dp[i-1][j];
                }
            }

        return dp[n][sum];
    }
}
import java.util.*;
public class TargetSumSubsetOptimized {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        int tar = sc.nextInt();

        boolean[] dp = new boolean[tar + 1];
        dp[0] = true; // empty subset always sums to 0

        for (int i = 0; i < n; i++) {
            // RIGHT TO LEFT — critical, prevents reuse of same item
            for (int j = tar; j >= arr[i]; j--) {
                dp[j] = dp[j] || dp[j - arr[i]];
            }
        }

        System.out.println(dp[tar]);
    }
}
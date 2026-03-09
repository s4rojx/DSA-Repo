import java.util.Scanner;

public class ZeroOneKnapSack {
    static void main() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] wt = new int[n];
        int [] val = new int[n];
        for (int i = 0; i < n; i++) {
            wt[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            val[i] = sc.nextInt();
        }
        int w = sc.nextInt();
        int [][] dp = new int[n+1][w+1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if(i == 0 || j == 0){
                    dp[i][j] = 0;
                }
                else{
                    if (j >= wt[i - 1]) {
                        dp[i][j] = Math.max(dp[i - 1][j],
                                val[i - 1] + dp[i - 1][j - wt[i - 1]]);
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }
        }
        System.out.println(dp[n][w]);
    }
}

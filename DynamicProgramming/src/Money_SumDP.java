import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Money_SumDP {
    static void main() {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int [] arr = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            sum+=arr[i];
        }
        boolean [][] dp = new boolean[n+1][sum+1];
        dp[0][0] = true;
        for (int i = 1; i < n+1; i++) {
            for (int j = 0; j < sum + 1; j++) {
                if(j==0){
                    dp[i][j] = true;
                } else if (arr[i] >= j) {
                    if(dp[i-1][j]){
                        dp[i][j] = true;
                    } else if (dp[i-1][j-arr[i]]) {
                        dp[i][j] = true;
                    }
                    else dp[i][j] = false;
                }
            }
        }
        int k = 0;
        HashSet<Integer> deno = new HashSet<>();
        int cnt =0;
            for (int i = 1; i < sum+1; i++) {
            if(dp[k++][i]){
                cnt ++;
                deno.add(i);
                break;
            }
        }
        System.out.println(cnt);
            for(int item:deno){
                System.out.print(item+" ");
            }
    }
}


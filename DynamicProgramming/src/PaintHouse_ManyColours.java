//Current complexity = O(n^3)

import java.util.*;
public class PaintHouse_ManyColours {
    static void main() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();//No of houses
        int c = sc.nextInt();//No of colors
        
        int [][] arr = new int[n][c];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j]=sc.nextInt();
            }
        }
        int [][] dp = new int[n][c];
        for (int j = 0; j < arr[0].length; j++) {
            dp[0][j] = arr[0][j];
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                int min = Integer.MAX_VALUE;
                for (int k = 0; k < dp[0].length; k++) {
                    if(k!=j){
                       if(dp[i-1][k]<min)
                           min = dp[i-1][k];
                    }
                }
                dp[i][j] = arr[i][j]+min;
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < dp[0].length; i++) {
            if(dp[n-1][i]<min){
                min = dp[n-1][i];
            }
        }
        System.out.println(min);
    }
}

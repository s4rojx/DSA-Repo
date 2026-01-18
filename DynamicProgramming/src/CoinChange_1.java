import java.util.Scanner;

public class CoinChange_1 {
    static void main() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int [] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        int amt = sc.nextInt();
        
        int dp[] = new int[amt+1];
        dp[0] = 1;
        //i loop iterates for coins (as per arr. index)
        for (int i = 0; i < arr.length; i++) {
            //for any coin (say z) the loop runs from z to further
            //same has been done in the below loop
            for (int j = arr[i]; j < dp.length ; j++) {
                dp[j] += dp[j - arr[i]];
            }
        }
        System.out.println(dp[amt]);
    }
}

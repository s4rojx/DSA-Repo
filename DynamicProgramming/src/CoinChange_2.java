import java.util.Scanner;

public class CoinChange_2 {
    static void main() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        int tar = sc.nextInt();

        int dp[] = new int[tar+1];
        dp[0] = 1;
        //The outer (amt) loop is for traversing every element of dp array
        //from -> index 1 to target
        for (int amt = 1; amt <= tar; amt++) {
            //Traverse every available coin denomination
            for (int coin : arr) {
                //coin can only contribute if its value is either equal to
                //or less than amount (dp array elements)
                //For ex. 3 can contribute to 3 or higher not less than 3 values
                if(coin <= amt){
                    int ramt = amt -coin;
                    dp[amt] += dp[ramt];
                }
            }
        }
        System.out.println(dp[tar]);
    }
}

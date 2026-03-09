import java.util.Scanner;

public class UnboundedKnapsack {
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
        int [] dp = new int[w+1];
        dp [0] = 0;
        //outer for loop to iterate through dp array representing bag capacity
        for (int bagc = 1; bagc < dp.length; bagc++) {
            int max = 0;
            //inner loop to iterate through wt and val when needed
            for (int i = 0; i < n; i++) {
                //a weight can only be added when its weight is less than the maximum the bag can accomodate
                if(wt[i] <=bagc){
                    int rbagc = bagc - wt[i];//after taking a weight calculate the remaining bag capacity
                    int rbagv = dp[rbagc];//after jumping wt[i] backwards what's the value stored in the dp array in that position
                    //for ex. for 5 if we use wt. 3 bag we jump 3 steps back and see the value in wt.2 bag and add that value to the value of 3
                    int tbagv = rbagv + val[i];//adding value of that wt with the jumped value backward = wt of the item backward
                    if(tbagv > max){ // find max value that can be obtained by using all possible weights and jumps and stpre that in the dp array
                        max = tbagv;
                    }
                }
            }
            dp[bagc] = max;
        }
        System.out.println(dp[w]);
    }
}

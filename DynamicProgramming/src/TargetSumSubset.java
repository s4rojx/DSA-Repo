import java.util.Scanner;

public class TargetSumSubset {
    static void main() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int [] arr  = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int tar = sc.nextInt();

        boolean [][] dp = new boolean[n+1][tar+1];
        for(int i = 0;i< dp.length; i++){
            for (int j = 0; j < dp[0].length; j++) {
                //First element
                if(i==0 && j==0){
                    dp[i][j] = true;
                }
                //1st row -> false
                else if (i==0 ) {
                        dp[i][j] = false;
                }
                //1st col -> true
                else if (j==0 ) {
                        dp[i][j] = true;
                }
                else {
                        //agar uske upar wale target bana diye toh woh bhi bana degi
                        if(dp[i-1][j] == true){
                            dp[i][j] = true;
                        }
                        else{
                            int val = arr[i-1];//dp wale array mai (i) equals to arr mai (i-1)
                            if(j>=val){
                                //upar row ke j-val wale agar true hain the val uske saath mil kar bana dega required target
                               if(dp[i-1][j-val] ==true){
                                    dp[i][j] = true;
                               }
                            }
                        }
                }
            }
        }
        System.out.println(dp[n][tar]);
    }
}

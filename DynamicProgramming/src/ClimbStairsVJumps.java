import java.util.Scanner;

public class ClimbStairsVJumps {
   public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        int [] dp = new int[n+1];
        dp[n] = 1;//n se n jaane ka ek hi raasta hota hai 
      //dp[i] pe , i se n tak ke jaane ke raste saved hain
        //Here we move from right to left so i loop runs ulta
        for (int i = n-1; i >=0; i--)//dp[i] pe store karega ki i se n jaane ka kitna rasta hota hai
           {//arr[i] contains in how may ways can we go from i to n 
            for (int j = 1; j <= arr[i] && i+j < dp.length; j++) 
            //(i+j) condtition is given to preven going beyond the dp array
            {
                dp[i] += dp[i+j];
            }
        }
        System.out.println(dp[0]);
    }
}

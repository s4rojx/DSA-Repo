//Leetcode 53
package kadanes_algo;
import java.util.Scanner;

public class MaximumSumOfSubArray {
    static void main() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(solve(arr));
    }

    private static int solve(int[] nums) {
        int csum = nums[0], osum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if(csum > 0){
                csum+=nums[i];
            }
            else
                csum = nums[i];
            if(csum > osum){
                osum = csum;
            }

        }

        return osum;
    }
}

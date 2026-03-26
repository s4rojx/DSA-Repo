package Sliding_Window;

import java.util.Scanner;

public class Max_Sum_SubArray_Size_K {
    static void main() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        //
        int k = sc.nextInt();
        int sum = 0 ;
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }

        //Complexity O(N)
        int mSum = sum;
        for (int i = 0; i < n - k; i++) {
            sum = sum - arr[i] + arr[i+k];
            if(sum > mSum){
                mSum = sum;
            }
        }
        System.out.println(mSum);

    }
}

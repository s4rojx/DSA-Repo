package Sliding_Window;

import java.util.*;

public class LongestSubarrayWIthSumK {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        int i = 0, j = 0, sum = 0;
        int len = 0;
        while (j < n) {
            sum += arr[j];
            j++;
            if(sum > k) {
                while (sum > k) {
                    sum -= arr[i];
                    i++;
                }
            }
            if(sum == k){
                len = Math.max((j-i+1), len);
            }
            j++;
        }
        System.out.println(len);

    }
}
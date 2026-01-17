package Recursion;
import java.util.*;
public class TargetSumSubset {
    static void main() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        int tar = sc.nextInt();
        printTargetSumSubsets(arr, 0, "",0, tar);
    }
    // set -> subset, sos -> sum of subset, tar -> target
    private static void printTargetSumSubsets(int [] arr, int idx, String subset, int sos, int tar){
        if(idx == arr.length){
            if(sos == tar){
                System.out.println(subset);
            }
            return;
        }

        printTargetSumSubsets(arr, idx+1, subset+arr[idx]+",", sos+arr[idx],tar);
        printTargetSumSubsets(arr,idx+1,subset,sos,tar);
    }
}

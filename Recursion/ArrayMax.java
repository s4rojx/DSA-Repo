package Recursion;
import java.util.Scanner;

public class ArrayMax {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] arr = new int[n];

        for (int i = 0; i < arr.length; i++) {
            arr [i] = sc.nextInt();
        }
        int max = maxOfArray(arr, 0, 2);
        System.out.println(max);
    }

    private static int maxOfArray(int[] arr, int idx, int ele) {
        if(idx == arr.length){
            return -1;
        }
        else {
            int f11 = maxOfArray(arr, idx+1, ele);
            return f11;
        }
    }

}

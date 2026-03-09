package Recursion;

import java.util.Scanner;

public class ArrayMin {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        int min = minOfArray(arr, 0);
        System.out.println(min);
    }

    private static int minOfArray(int[] arr, int idx) {
        if (idx == arr.length - 1) {
            return arr[idx];
        }
        int misa = minOfArray(arr, idx + 1);
        if (misa < arr[idx])
            return misa;
        else return arr[idx];
    }
}
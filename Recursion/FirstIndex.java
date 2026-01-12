package Recursion;

import java.util.Scanner;

public class FirstIndex {
    static void main() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        int f1 = firstidx(arr, 0, 4);
        System.out.println(f1);
    }

    private static int firstidx(int[] arr, int idx, int ele) {
        if(arr[idx]==ele)
            return idx;
        else{
            int fiisa = firstidx(arr, idx+1, ele);
            return fiisa;
        }

    }

}

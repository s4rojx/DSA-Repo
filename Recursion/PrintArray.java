package Recursion;
import java.util.Scanner;

public class PrintArray {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr [i] = sc.nextInt();
        }
        displayArr(arr, n-1);
    }
//expection: Index se end tak print kar dega
// faith: idx+1 se end tak print karna jaanta hai
    private static void displayArr(int[] arr, int idx) {
        if(idx <0)
            return;

        System.out.println(arr[idx]);
        displayArr(arr, idx-1);
    }
}

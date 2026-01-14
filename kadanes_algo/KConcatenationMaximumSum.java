package kadanes_algo;

import java.util.Scanner;

public class KConcatenationMaximumSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int n = sc.nextInt();
        int[] arr = new int[n];
        long sum = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            sum += arr[i];
        }
        if (k == 1) {
            System.out.println(kadanes(arr));
        } else if (sum < 0) {
            System.out.println(kadanesOfTwo(arr));
        } else {
            System.out.println(kadanesOfTwo(arr) + (k - 2L) * sum);
        }
    }

    private static int kadanesOfTwo(int[] arr) {
        int n = arr.length;
        int[] narr = new int[2 * n];
        for (int i = 0; i < n; i++) {
            narr[i] = arr[i];
            narr[i + n] = arr[i];
        }
        return kadanes(narr);
    }

    private static int kadanes(int[] a) {
        int csum = 0;
        int osum = 0;
        for (int i = 0; i < a.length; i++) {
            if (csum < 0) {
                csum = 0;
            }
            csum += a[i];
            if (csum > osum) {
                osum = csum;
            }
        }
        return osum;
    }
}
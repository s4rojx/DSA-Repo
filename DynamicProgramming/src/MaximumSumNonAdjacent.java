import java.util.Scanner;

public class MaximumSumNonAdjacent {
    static void main() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int inc =arr[0];
        int exc =0;
        for (int i = 1; i < n; i++) {
            int nInc = arr[i] + exc;
            int nExc = Math.max(inc,exc);

            inc = nInc;
            exc = nExc;
        }
        System.out.println(Math.max(inc,exc));
    }
}

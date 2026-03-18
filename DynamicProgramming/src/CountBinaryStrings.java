import java.util.Scanner;

public class CountBinaryStrings {
    static void main() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] dp0 = new int[n+1];
        int [] dp1 = new int[n+1];
        for (int i = 0; i < n + 1; i++) {
            if(i<2){
                dp0[i] = dp1[i] = i;
            }
            else{
                dp0[i] = dp1[i-1];
                dp1[i] = dp1[i-1] + dp0[i-1];
            }
        }
        System.out.println(dp0[n]+dp1[n]);
    }
}

package Recursion;
import java.util.Scanner;

public class IncDec {
    static void main() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        pdi(n);
    }

    private static void pdi(int n) {
        if(n==0)
            return;
        System.out.println(n);
        pdi(n-1);
        System.out.println(n);
    }
}

import java.util.Scanner;

public class CountBinaryStringsOptimized {
    static void main() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int oldZeros = 1;
        int oldOnes = 1;
        for (int i = 2; i < n + 1; i++) {
            int newZeros = oldOnes;
            int newOnes = oldOnes+oldZeros;
            oldOnes = newOnes;
            oldZeros = newZeros;
        }
        System.out.println(oldZeros+oldOnes);
    }
}

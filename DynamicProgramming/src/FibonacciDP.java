import java.util.Scanner;

public class FibonacciDP {
    static void main() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int fibn = FibMemoized(n,new int[n+1]);
        //we are storing values in qb for 0-n so size of the array should be n+1
        System.out.println(fibn);
    }

    private static int Fib(int n) {
        if(n<2)
            return n;
        int fibnm1 = Fib(n-1);
        int fibnm2 = Fib(n-2);
        int fibn = fibnm1 + fibnm2;
        return fibn;
    }

   /* The n passed method FibMemoized is ques. and fibn->answer
    In question position we store the answer*/
    private static int FibMemoized(int n, int [] qb) {
        if(n<2)
            return n;
        //does the qb contains the answer already
        //if yes do return that and skip extra calculation
        if(qb[n] != 0){
            return qb[n];
        }
        int fibnm1 = FibMemoized(n-1, qb);
        int fibnm2 = FibMemoized(n-2, qb);
        int fibn = fibnm1 + fibnm2;

        qb[n] = fibn;//stored answer in question's position
        return fibn;
    }
}

//Given a number n of any base b1
//convert the number n to another base b2
//[n]8  = [?]10       Here b1=8 and b2=10
import java.util.Scanner;
public class anyBaseToAnyBase {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n= sc.nextInt();
        int b1= sc.nextInt();
        int b2= sc.nextInt();
        int dv = getValue(n,b1,b2);
        System.out.println(dv);
    }

    public static int getValue(int n, int b1,int b2) {
        int rv =0;
        int p=0;
        while(n > 0){
            int rem = n % b2;
            n =n/b2;
            rv += rem * Math.pow(b1,p);// Multiply each remainder with increasing power of b1 => 0 - (no of digits-1)
            p++;
        }
        return rv;
    }
}

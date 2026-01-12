//Given a decimal number n , and given a base b
//convert the number n to corresponding value in base b
//[n]10  = [?]8       Here b=8
import java.util.*;
public class decimalToAnyBase {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n= sc.nextInt();
        int b= sc.nextInt();
        int dv = getValueInBase(n,b);
        System.out.println(dv);
    }

    public static int getValueInBase(int n, int b) {
        int rv =0;
        int p=0;
        while( n>0){
            int dig = n%b;
            n = n/b;

            rv += dig * Math.pow(10,p);// Multiply each remainder with increasing power of 10
            p++;
        }
        return rv;
    }
}

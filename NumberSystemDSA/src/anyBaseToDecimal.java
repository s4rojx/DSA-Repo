//Given a number n of any base
//convert the number n to corresponding decimal value
//[n]8  = [?]10       Here b=8

import java.util.Scanner;
public class anyBaseToDecimal {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n= sc.nextInt();
        int b2= sc.nextInt();
        int dv = getValue(n,b2);
        System.out.println(dv);
    }

    public static int getValue(int n, int b2) {

        int rv =0;
        int p=0;
        while(n > 0){
            int rem = n % 10;
            n =n/10;
            rv += rem * Math.pow(b2,p);// Multiply each remainder with increasing power of b => 0 - (no of digits-1)
            p++;
        }
        return rv;
    }

}

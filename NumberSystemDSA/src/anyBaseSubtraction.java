/*
 * 1.You are given a base b
 * 2. You are given 2 numbers n1 and n2 of base b
 * You are required to subtract the two numbers and print their value in base b
 * given that n2 > n1*/

import java.util.Scanner;

public class anyBaseSubtraction {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int b= sc.nextInt();
        int n1= sc.nextInt();
        int n2= sc.nextInt();
        int dv = funct2(b,n1,n2);
        System.out.println(dv);
    }

    private static int funct2(int b, int n1, int n2) {
        int rv = 0, p=0,c=0;
        while(n2 > 0){
            int d1 = n1 % 10;
            n1 = n1/10;
            int d2 = n2 % 10;
            n2 = n2/10;
            int d = 0;
            d2+= c;
            if(d2 >= d1){
                 c = 0;
                d = d2 -d1;
            }
            else {
                c =-1;
                d = d2 + b - d1;
            }
            rv += d * Math.pow(10,p);
            p++;
        }
        return rv;
    }
}
/*b: The base of the numbers (e.g., 2 for binary).
n1: The subtrahend (number to subtract), in base b but input as decimal.
n2: The minuend (number to subtract from), in base b but input as decimal.

Starts a while loop that continues as long as n2 has digits to process (n2 > 0).

Extracts the rightmost digit of n1 using modulo (n1 % 10).
Removes the rightmost digit from n1 by integer division (n1 / 10). Same for n2

d will hold the difference for the current digit position after subtraction.

Adjusts the current digit of n2 (d2) by adding the borrow (c) from the previous iteration.

if(d2 >= d1){ => Determines whether subtraction can proceed directly or if borrowing from the next digit is needed.
Sets the borrow (c) to 0, indicating no borrow is needed for the next digit position.

else{} => Sets the borrow (c) to 0, indicating no borrow is needed for the next digit position.
c = -1;
Purpose: Sets the borrow (c) to -1, indicating a borrow is needed for the next digit position.

d = d2 + b - d1;
Purpose: Computes the result digit d by adding the base b to d2 (to account for the borrow) and then subtracting d1.
*/
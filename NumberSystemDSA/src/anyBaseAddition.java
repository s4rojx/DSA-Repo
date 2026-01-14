/*
* 1.You are given a base b
* 2. You are given 2 numbers n1 and n2 of base b
* You are required to add the two numbers and print their value in base b*/

import java.util.Scanner;
public class anyBaseAddition {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int b= sc.nextInt();
        int n1= sc.nextInt();
        int n2= sc.nextInt();
        int dv = funct(b,n1,n2);
        System.out.println(dv);
}

    public static int funct(int b, int n1, int n2) {
        int rv = 0, p=0,c=0;
        while(n1>0 || n2>0 || c>0){
        int d1 = n1 % 10;
        int d2 = n2 % 10;
        n1 = n1/10; //Removes the rightmost digit from n1 by integer division (n1 / 10).
        n2 = n2/10; //Removes the rightmost digit from n2 by integer division (n2 / 10).
        int d =  d1+d2+c; //Adds the digits d1 (from n1), d2 (from n2), and the carry c to get the total sum for the current digit position.
        c = d / b; //Computes the carry for the next digit position by dividing d by the base b (integer division).
        d = d % b; //Computes the digit to be placed in the current position of the result by taking d % b.
        rv += d * Math.pow(10,p); //Adds the current digit d to the result rv, placing it in the correct position by multiplying by 10^p.
        p++;
        }
        return rv;
    }
    }


    /*
* Let’s walk through an example with b = 2, n1 = 101 (binary 101, decimal 5), n2 = 110 (binary 110, decimal 6). The goal is to compute 101 + 110 in binary (result: 1011, decimal 11).

Initialization: rv = 0, p = 0, c = 0.
First Iteration (rightmost digits):

d1 = n1 % 10 = 101 % 10 = 1
d2 = n2 % 10 = 110 % 10 = 0
n1 = n1 / 10 = 101 / 10 = 10
n2 = n2 / 10 = 110 / 10 = 11
d = d1 + d2 + c = 1 + 0 + 0 = 1
c = d / b = 1 / 2 = 0 (no carry)
d = d % b = 1 % 2 = 1
rv += d * Math.pow(10, p) = 0 + 1 * 10^0 = 0 + 1 = 1
p++ → p = 1


Second Iteration:

d1 = 10 % 10 = 0
d2 = 11 % 10 = 1
n1 = 10 / 10 = 1
n2 = 11 / 10 = 1
d = 0 + 1 + 0 = 1
c = 1 / 2 = 0
d = 1 % 2 = 1
rv += 1 * 10^1 = 1 + 10 = 11
p++ → p = 2


Third Iteration:

d1 = 1 % 10 = 1
d2 = 1 % 10 = 1
n1 = 1 / 10 = 0
n2 = 1 / 10 = 0
d = 1 + 1 + 0 = 2
c = 2 / 2 = 1 (carry 1)
d = 2 % 2 = 0
rv += 0 * 10^2 = 11 + 0 = 11
p++ → p = 3


Fourth Iteration (only carry remains):

d1 = 0 % 10 = 0 (since n1 = 0)
d2 = 0 % 10 = 0 (since n2 = 0)
n1 = 0 / 10 = 0
n2 = 0 / 10 = 0
d = 0 + 0 + 1 = 1
c = 1 / 2 = 0
d = 1 % 2 = 1
rv += 1 * 10^3 = 11 + 1000 = 1011
p++ → p = 4


Loop Ends: n1 = 0, n2 = 0, c = 0, so the loop terminates.
Return: rv = 1011 (binary 1011, decimal 11).

The result 1011 represents the binary number 1011 (decimal 11), which is correct: 101 (5) + 110 (6) = 1011 (11) in base 2.
* */
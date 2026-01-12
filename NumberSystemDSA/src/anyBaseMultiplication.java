import java.util.Scanner;
public class anyBaseMultiplication {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int b = sc.nextInt();
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        int dv = finalMul(b, n1, n2); //Calls the baseMul method with b, n1, and n2 to compute their product in base b, storing the result in dv (as a decimal number representing the base-b result)
        System.out.println(dv);
    }

    public static int anyBaseSum(int b, int n1, int n2) //method for adding two numbers (n1 and n2) in base b
    {
        int rv = 0, p = 0, c = 0;
        while (n1 > 0 || n2 > 0 || c > 0) {
            int d1 = n1 % 10;
            int d2 = n2 % 10;
            n1 = n1 / 10;
            n2 = n2 / 10;
            int d = d1 + d2 + c;
            c = d / b;
            d = d % b;
            rv += d * Math.pow(10, p);
            p++;
        }
        return rv;
    }

    public static int getProductWithASingleDigit(int b, int n1, int d2) //Defines a method to multiply a number n1 (in base b) by a single digit d2 (in base b)
    {
        int rv = 0, c = 0, p = 0;
        while (n1 > 0 || c > 0) //Loops while n1 has digits or there’s a non-zero carry.
        {
            int d1 = n1 % 10; //Extracts the rightmost digit of n1.
            n1 = n1 / 10; //Removes the rightmost digit from n1.
            int d = d1 * d2 + c; //Multiplies d1 by d2 and adds the carry c to get the total for the current position
            c = d / b; //Computes the carry by dividing d by the base b.
            d = d % b; //Computes the digit for the current position using d % b.
            rv += d * Math.pow(10, p); //Adds the digit d to rv, placed at the correct position using 10^p.
            p++;
        }
        return rv;
    }

    public static int finalMul(int b, int n1, int n2) {
        int rv = 0, p = 1;
        while (n2 > 0) //Loops while n2 has digits, processing each digit of n2.
        {
            int d2 = n2 % 10; //Extracts the rightmost digit of n2.
            n2 = n2 / 10; //Removes the rightmost digit from n2.
            int sprd = getProductWithASingleDigit(b, n1, d2); //Multiplies n1 by the current digit d2 using getProductWithASingleDigit, storing the partial product in sprd.
            rv = anyBaseSum(b, rv, sprd * p); //Adds the partial product sprd, shifted by p (e.g., multiplied by 10^0, 10^1), to the running result rv using anyBaseSum
            p *= 10;
        }
        return rv;
    }
}
/*Example Walkthrough
For b = 2, n1 = 101 (binary 101, decimal 5), n2 = 11 (binary 11, decimal 3), compute 101 * 11 (5 * 3 = 15, binary 1111):

First iteration (n2 = 11):

d2 = 11 % 10 = 1, n2 = 11 / 10 = 1.
sprd = getProductWithASingleDigit(2, 101, 1) = 101 (101 * 1 = 101).
rv = funct(2, 0, 101 * 1) = 101.
p = 1 * 10 = 10.


Second iteration (n2 = 1):

d2 = 1 % 10 = 1, n2 = 1 / 10 = 0.
sprd = getProductWithASingleDigit(2, 101, 1) = 101.
rv = funct(2, 101, 101 * 10) = funct(2, 101, 1010) = 1111 (101 + 1010 = 1111).
p = 10 * 10 = 100.


Loop ends, n2 = 0. Return rv = 1111 (binary 1111, decimal 15).*/
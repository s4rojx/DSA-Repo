package Recursion;
import java.util.*;
public class exponent {
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter base :");
        int a = sc.nextInt();
        System.out.print("Enter exponenet :");
        int b = sc.nextInt();
        System.out.println(expo(a,b));

    }

    private static int expo(int a, int b) {
        if(b==0)
            return 1;
        int ans = expo(a,b/2);
        if(b%2 ==0){
            return ans*ans;
        }
        else
            return a*ans*ans;
    }
    sc.close();

}

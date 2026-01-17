package Recursion;

import java.util.ArrayList;
import java.util.Scanner;

class printStairPath {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        printSP(n, "");
    }

    private static void printSP(int n, String path) {
        if(n<0)
            return;
        if(n==0){
            System.out.print(path+" ,");
            return;
        }
        printSP(n-1,path + "1");
        printSP(n-2,path + "2");
        printSP(n-3,path + "3");
    }
}
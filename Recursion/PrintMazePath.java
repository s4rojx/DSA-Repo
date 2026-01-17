package Recursion;

import java.util.*;
public class PrintMazePath{
   public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        pmp(1,1,n,m,"");
    }

    private static void pmp(int sr, int sc, int dr, int dc, String psf) {
        if (sr > dr || sc > dc) {
            return;
        }
        if(sc == dc && sr == dr){
            System.out.print(psf+",");
            return;
        }
        pmp(sr,sc+1,dr,dc,psf+"h");
        pmp(sr+1,sc,dr,dc,psf+"v");
    }
}

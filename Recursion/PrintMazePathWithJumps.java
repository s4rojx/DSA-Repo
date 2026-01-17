package Recursion;

import java.util.*;

public class PrintMazePathWithJumps {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int m = sc.nextInt();
    pmpwj(1,1,n,m,"");
}

private static void pmpwj(int sr, int sc, int dr, int dc, String psf) {
        if(sc == dc && sr == dr){
        System.out.print(psf+",");
        return;
    }
    for(int h = 1; h <= dc-sc ;h++){
        pmpwj(sr,sc+h,dr,dc,psf+"h");
    }
    for(int v = 1; v <= dr-sr ;v++){
        pmpwj(sr+v,sc,dr,dc,psf+"v");
    }
    for (int d = 1; d<= dc-sc && d<= dr-sr ; d++) {
        pmpwj(sr+d,sc+d,dr,dc,psf+"d"+d);

    }
  }
}

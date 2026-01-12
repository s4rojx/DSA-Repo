package Recursion;
import java.util.*;
public class GetMazePath {
    static void main() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList <String> paths = gmp(1,1,n,m);
        System.out.println(paths);

    }
//sr-> Source row ,sc-> source coloumn
    private static ArrayList<String> gmp(int sr, int sc, int dr, int dc) {
        //base case -> Empty path for n.m
        if(sr == dr && sc == dc){
            ArrayList <String> bres = new ArrayList<>();
            bres.add("");
            return bres;
        }

        ArrayList <String> hpaths = new ArrayList<>();
        ArrayList <String> vpaths = new ArrayList<>();
        if(sc < dc){
            hpaths = gmp(sr, sc+1, dr, dc);
        }
        if(sr<dr){
            vpaths= gmp(sr+1, sc, dr, dc);
       }
        ArrayList <String> paths = new ArrayList<>();

        for(String hpath: hpaths){
            paths.add("h" + hpath);
        }
        for(String vpath: vpaths){
            paths.add("v" + vpath);
        }
        return paths;
    }
}

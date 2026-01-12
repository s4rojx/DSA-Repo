package Recursion;

import  java.util.*;
public class StairPath {
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList <String> paths = getStairPath(n);
        System.out.println(paths);

    }
    public static ArrayList<String> getStairPath(int n){
        if(n==0){
            ArrayList<String> bres = new ArrayList<>();
            bres.add("");
            return bres;
        } else if (n<0) {
            ArrayList<String> bres = new ArrayList<>();
            return bres;
        }

        ArrayList<String> paths1 = getStairPath(n-1);
        ArrayList<String> paths2 = getStairPath(n-2);
        ArrayList<String> paths3 = getStairPath(n-3);

        ArrayList<String> paths = new ArrayList<>();
        for(String path: paths1){
            paths.add(1+path);
        }
        for(String path: paths2){
            paths.add(2+path);
        }
        for(String path: paths3){
            paths.add(3+path);
        }
        return paths;

    }
}

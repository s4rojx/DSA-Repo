package Recursion;

import java.util.ArrayList;
import java.util.Scanner;

public class MazePathWithJumps {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<String> paths = gmpj(1, 1, n, m);
        System.out.println(paths);
    }

    // sr -> source row, sc -> source column
    private static ArrayList<String> gmpj(int sr, int sc, int dr, int dc) {
        if (sr == dr && sc == dc) {
            ArrayList<String> bram = new ArrayList<>();
            bram.add("");
            return bram;
        }

        ArrayList<String> paths = new ArrayList<>();

        // horizontal moves - jumps up to (dc - sc)
        for (int h = 1; h <= dc - sc; h++) {
            ArrayList<String> hpaths = gmpj(sr, sc + h, dr, dc);
            for (String hpath : hpaths) {
                paths.add("h" + h + hpath);
            }
        }

        // vertical moves - jumps up to (dr - sr)
        for (int v = 1; v <= dr - sr; v++) {
            ArrayList<String> vpaths = gmpj(sr + v, sc, dr, dc);
            for (String vpath : vpaths) {
                paths.add("v" + v + vpath);
            }
        }

        // diagonal moves - jumps up to min(dc - sc, dr - sr)
        for (int d = 1; d <= dc - sc && d <= dr - sr; d++) {
            ArrayList<String> dpaths = gmpj(sr + d, sc + d, dr, dc);
            for (String dpath : dpaths) {
                paths.add("d" + d + dpath);
            }
        }

        return paths;
    }
}

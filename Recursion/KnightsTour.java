package Recursion;

import java.util.Scanner;

public class KnightsTour {
    static void main() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int r = sc.nextInt();
        int c = sc.nextInt();
        int [][] chess = new int[n][n];
        knightTour(chess, r, c, 1);

    }

    private static void knightTour(int[][] chess, int r, int c, int move) {

        // Out of bounds or already visited
        if(r<0 || c<0 || r >= chess.length ||c >= chess.length || chess[r][c] > 0){
            return;
        }
        //If all squares are covered, print and backtrack
        if (move == chess.length * chess.length) {
            chess[r][c] = move;
            displayBoard(chess);
            chess[r][c] = 0; //backtrack
            return;
        }
        chess[r][c] = move;
        knightTour(chess, r-2, c+1 , move+1);
        knightTour(chess, r-1, c+2 , move+1);
        knightTour(chess, r+1, c+2 , move+1);
        knightTour(chess, r+2, c+1 , move+1);
        knightTour(chess, r+2, c-1 , move+1);
        knightTour(chess, r+1, c-2 , move+1);
        knightTour(chess, r-1, c-2 , move+1);
        knightTour(chess, r-2, c-1 , move+1);

        chess[r][c] = 0; //BackTrack
    }

    private static void displayBoard(int[][] chess) {
        for (int i = 0; i < chess.length; i++) {
            for (int j = 0; j < chess[0].length; j++) {
                System.out.print(chess[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

}

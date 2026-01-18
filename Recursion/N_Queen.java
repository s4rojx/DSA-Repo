package Recursion;
import java.util.*;
public class N_Queen {
    static void main() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] chess = new int[n][n];
        printNQueens(chess, "", 0);
    }

    private static void printNQueens(int[][] chess, String qsf, int row) {
        if (row == chess.length) {
            System.out.println(qsf + ".");
            return;
        }
        //Jo parameter mai pass kiya jaata hai woh levels pe dikhai deti
        //Jo loops se aata hai woh options hote hain
        //Here row -> Levels(parameters) , col -> options of tree (Loops)
        for (int col = 0; col < chess.length; col++) {
            if (isItSafePlaceForQueen(chess, row, col) == true) {
                chess[row][col] = 1;
                printNQueens(chess, qsf + row + "-" + col + ", ", row + 1);
                chess[row][col] = 0;
            }

        }
    }

    private static boolean isItSafePlaceForQueen(int[][] chess, int row, int col) {
        //This loop is for vertical safe position check in same (coloumn)
        for (int i = row - 1, j = col; i >= 0; i--) {
            if (chess[i][j] == 1) {
                return false;
            }
        }
        //this loop is for left upper column checking
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (chess[i][j] == 1) {
                return false;
            }
        }
        for (int i = row - 1, j = col + 1; i >= 0 && j < chess.length; i--, j++) {
            if (chess[i][j] == 1) {
                return false;
            }
        }
        return true;
    }
}
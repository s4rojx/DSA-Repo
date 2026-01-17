package Recursion;

import java.util.Scanner;

public class FloodFill {
    static void main() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int [][] arr = new int[n][m];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        // By default, the visited array contains false values in all cells
        boolean [][] visited = new boolean[n][m];
        floodFill(arr, 0, 0, "",visited);
    }
   public static void floodFill(int [][] maze, int row, int col, String psf, boolean [][] visited){
        // (maze[row][col] == 1) => This should be at the last only strictly
       //if we place (maze[row][col] == 1) in first we will get ArrayIndexOutOfBound Exception
        if(row < 0 || col < 0 || row == maze.length || col == maze[0].length || maze[row][col] == 1 || visited[row][col] == true){
            return;
        }
        if( row == maze.length - 1 && col == maze[0].length - 1){
            System.out.println(psf);
            return;
        }
        visited[row][col] = true;
       floodFill(maze, row - 1 , col ,psf + "t",visited);
       floodFill(maze, row, col - 1 ,psf + "l",visited);
       floodFill(maze, row + 1, col,psf + "d",visited);
       floodFill(maze, row, col + 1 ,psf + "r",visited);
       visited [row][col] = false;
    }
}

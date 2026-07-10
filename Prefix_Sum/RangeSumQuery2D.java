import java.util.*;

public class RangeSumQuery2D {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        int row1 = sc.nextInt();
        int col1 = sc.nextInt();
        int row2 = sc.nextInt();
        int col2 = sc.nextInt();
        setMatrix(matrix);
        int result = rangeSum(matrix, row1, col1, row2, col2);
        System.out.println(result);

    }

    private static int rangeSum(int[][] matrix, int row1, int col1, int row2, int col2) {
        int total = matrix[row2][col2];
        int up = row1 > 0 ? matrix[row1 - 1][col2] : 0;
        int left = (col1 > 0) ? matrix[row2][col1 - 1] : 0;
        int corner = (row1 > 0 && col1 > 0) ? matrix[row1 - 1][col1 - 1] : 0;

        return total - up - left + corner;
    }

    private static void setMatrix(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 && j == 0) {
                    continue;
                } else if (i == 0) {
                    matrix[i][j] = matrix[i][j - 1] + matrix[i][j];
                } else if (j == 0) {
                    matrix[i][j] = matrix[i - 1][j] + matrix[i][j];
                } else {
                    matrix[i][j] = matrix[i - 1][j] + matrix[i][j - 1] + matrix[i][j] - matrix[i - 1][j - 1];
                }
            }

        }
    }
}
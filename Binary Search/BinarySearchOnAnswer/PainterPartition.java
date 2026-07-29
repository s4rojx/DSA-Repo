import java.util.*;

public class PainterPartition {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // Number of boards
        int k = sc.nextInt(); // Number of painters
        int[] boards = new int[n];
        for (int i = 0; i < n; i++) {
            boards[i] = sc.nextInt();
        }
// Finds minimum of maximum time allowed
        System.out.println(findMinTime(boards, k));
    }

    // Greedy check: Can we paint all boards in 'mid' time using 'k' painters?
    public static boolean isPossible(int[] boards, int k, int mid) {
        int currSum = 0;
        int painterUsed = 1;
        for (int board : boards) {
            if (board > mid) return false; // Single board too long for current 'mid' limit
            if (currSum + board <= mid) {
                currSum += board; // Add to current painter's load
            } else {
                painterUsed++; // Assign to a new painter
                currSum = board;
                if (painterUsed > k) return false; // Ran out of painters
            }
        }
        return true;
    }

    public static int findMinTime(int[] boards, int k) {
        int low = 0; // Minimum possible is the largest board
        int high = 0; // Maximum possible is the sum of all boards
        for (int board : boards) {
            low = Math.max(board, low);
            high += board;
        }

        int ans = high;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isPossible(boards, k, mid)) {
                ans = mid; // Found a valid time, try for smaller
                high = mid - 1;
            } else {
                low = mid + 1; // Need more time
            }
        }
        return ans;
    }
}
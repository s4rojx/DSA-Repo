import java.util.*;

public class PainterPartition {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // no of partitions
        int k = sc.nextInt(); // no of painters
        int[] boards = new int[n];
        for (int i = 0; i < n; i++) {
            boards[i] = sc.nextInt();
        }
        System.out.println(findMinTime(boards,k));

    }

    public static boolean isPossible(int[] boards, int k, int mid) {
        int currSum = 0;
        int painterUsed = 1;
        for (int board : boards) {
            if (board > mid) {
                return false;
            }
            if (currSum + board <= mid) {
                currSum += board;
            } else {
                painterUsed++;
                currSum = board;
                if (painterUsed > k)
                    return false;
            }
        }
        return true;
    }

    public static int findMinTime(int[] boards, int k) {
        int low = 0;
        int high = 0;
        for (int i = 0; i < boards.length; i++) {
            low = Math.max(boards[i], low);
            high = high + boards[i];
        }
        int ans = high;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isPossible(boards, k, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}
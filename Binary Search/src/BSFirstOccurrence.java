import java.util.*;

public class BSFirstOccurrence {

    static boolean check(int index, ArrayList<Integer> arr) {
        return arr.get(index) == 1;
    }

    static int binarySearch(ArrayList<Integer> arr) {
        int low = 0;
        int high = arr.size() - 1;
        int ans = -1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (check(mid, arr)) {
                ans = mid;        // possible first 1
                high = mid - 1;   // search left side
            } else {
                low = mid + 1;    // search right side
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0, 1, 1, 1));

        System.out.println(binarySearch(arr)); // Output: 5
    }
}
import java.util.*;

public class FirstOccurence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int ele = sc.nextInt();
        int start = 0;
        int end = n - 1;
        int res = -1; // store the value of index when match is found
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == ele) {
                res = mid;
                end = mid - 1; //To get first idx we need to scan even to the right to check if any position exist where
                //the no can be found , if not then return current index
            } else if (arr[mid] > ele) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        System.out.println(res);
    }
}
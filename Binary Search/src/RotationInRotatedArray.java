import java.util.*;

/*
  Example : [9,12,14,18,19,22,2,4,6,7] => OUTPUT: 4
             .  .  .  .  .  . ↑ . . .
 */
public class RotationInRotatedArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int low = 0;
        int high = n - 1;
        int res = 0;
        while (low <= high) {
            if (arr[low] <= arr[high]) //This means the array or part of it is sorted and the rotation is just the low
            {
                System.out.println(low);
                return;
            }
            int mid = low + (high - low) / 2;
            if (arr[mid] > arr[high])//means the unsorted part that contains the smallest lies on the right
                low = mid + 1;
            else //means the unsorted part that contains the smallest lies on the left
                high = mid;
        }
        System.out.println(low);
    }
}

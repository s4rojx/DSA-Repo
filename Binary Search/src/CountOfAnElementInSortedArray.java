import java.util.*;
/*
Basically the idea is count of index is basically (last index - first index + 1), and specifically its asked of
sorted array so that confirms -> Binary search pattern
*/
public class CountOfAnElementInSortedArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int ele = sc.nextInt();
        int first = firstOccurence(arr, ele);
        int last = lastOccurence(arr, ele);
        System.out.println("Count of Element is: " + (last - first + 1));

    }

    static int firstOccurence(int arr[], int ele) {
        int low = 0;
        int high = arr.length - 1;
        int res = -1;
        while (high >= low) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == ele) {
                res = mid;
                high = mid - 1;
            } else if (arr[mid] > ele) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return res;
    }

    static int lastOccurence(int arr[], int ele) {
        int low = 0;
        int high = arr.length - 1;
        int res = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == ele) {
                res = mid;
                low = mid + 1;
            } else if (arr[mid] >= ele) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return res;
    }
}
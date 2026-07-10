import java.util.*;

public class LongestSubarraySumK2 {
    public static void main(String[] args) {
        int[] arr = {5,2,2,5,1,1,1,1,4};
        int k = 4;
        System.out.println(longestSubarray(arr, k));
    }
    static int longestSubarray(int[] arr, int k) {
        Map<Integer, Integer> mp = new HashMap<>();
        int res = 0;
        int prefSum = 0;
        for (int i = 0; i < arr.length; i++) {
            prefSum += arr[i];
            if (prefSum == k)
                res = i + 1;
            else if (mp.containsKey(prefSum - k))
                res = Math.max(res, i - mp.get(prefSum - k));
            if (!mp.containsKey(prefSum))
                mp.put(prefSum, i);
        }

        return res;
    }
}
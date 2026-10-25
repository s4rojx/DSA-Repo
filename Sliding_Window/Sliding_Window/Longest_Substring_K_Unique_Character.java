package Sliding_Window;

import java.util.*;

public class Longest_Substring_K_Unique_Character {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int k = sc.nextInt();

        System.out.println(longestKSubstr(s, k));
    }

    public static int longestKSubstr(String s, int k) {
        if (s == null || s.length() == 0 || k == 0) return -1;

        Map<Character, Integer> map = new HashMap<>();
        int i = 0;               // left pointer
        int maxLen = -1;

        for (int j = 0; j < s.length(); j++) {   // right pointer
            char ch = s.charAt(j);
            map.put(ch, map.getOrDefault(ch, 0) + 1);

            // Shrink window if we have more than k distinct characters
            while (map.size() > k) {
                char leftChar = s.charAt(i);
                map.put(leftChar, map.get(leftChar) - 1);
                if (map.get(leftChar) == 0) {
                    map.remove(leftChar);
                }
                i++;
            }
            // Now the window has at most k distinct characters
            if (map.size() == k) {
                maxLen = Math.max(maxLen, j - i + 1);
            }
        }

        return maxLen;
    }
}
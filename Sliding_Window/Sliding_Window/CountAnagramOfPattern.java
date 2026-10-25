
package Sliding_Window;

import java.util.*;

public class CountAnagramOfPattern {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.next();
        String pat = sc.next();
        System.out.println(countAnagram(text, pat));
    }

    public static int countAnagram(String text, String pat) {
        HashMap<Character, Integer> map = new HashMap<>();
        int k = pat.length();
        for (char ch : pat.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        int count = map.size(), i = 0, j = 0, ans = 0;
        while (j < text.length()) {
            char ch = text.charAt(j);
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) - 1);
                if (map.get(ch) == 0) {
                    count--;
                }
            }
            if (j - i + 1 < k) {
                j++;
            }
            else if (j - i + 1 == k) {      
                if (count == 0) {
                    ans++;
                }
                char left = text.charAt(i);
                if (map.containsKey(left)) {
                    map.put(left, map.get(left) + 1);
                    if (map.get(left) == 1)
                        count++;
                }
                i++;
                j++;
            }

        }
        return ans;

    }

}

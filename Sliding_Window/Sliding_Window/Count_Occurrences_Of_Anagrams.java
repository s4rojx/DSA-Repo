package Sliding_Window;

import java.util.*;

public class Count_Occurrences_Of_Anagrams {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.next();
        String pat = sc.next();
        System.out.println(anagramCount(text,pat));

    }

    static boolean check(int[] cnt) {
        for (int i = 0; i < 26; i++) {
            if (cnt[i] != 0) return false;
        }
        return true;
    }

    static int anagramCount(String text, String pat) {
        int m = pat.length();
        int n = text.length();
        if (m > n) {
            return 0;
        }
        int[] cnt = new int[26];
        int ans = 0;
        for (int i = 0; i < m; i++) {
            char ch = pat.charAt(i);
            cnt[ch - 'a']++;
        }
        for (int i = 0; i < m - 1; i++) {
            char ch = text.charAt(i);
            cnt[ch - 'a']--;
        }
        for (int i = m - 1; i < n; i++) {
            char ch = text.charAt(i);
            cnt[ ch - 'a']--;
            if(check(cnt)) ans++;
            char del = text.charAt(i - m +1);
            cnt[del - 'a']++;
        }
        return ans;
    }
}
package HashMaps_Heaps;

import java.util.HashMap;
import java.util.Scanner;

public class HighestFrequencyCharacter {
    static void main() {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        HashMap<Character, Integer> hm = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            hm.merge(ch,1,Integer::sum);
        }
        char mfc = str.charAt(0);
        for(Character key: hm.keySet()){
            if(hm.get(key) > hm.get(mfc)){
                mfc = key;
            }
        }
        System.out.println(mfc);
    }
}

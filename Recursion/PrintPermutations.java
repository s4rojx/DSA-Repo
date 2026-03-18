package Recursion;

import java.util.HashSet;
import java.util.Scanner;

public class PrintPermutations {
    static void main() {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        HashSet<String> set = new HashSet<>();
        printPermutation(str,"",set);
        for(String s:set){
            System.out.println(s);
        }
}
//asf -> answer so far
    private static void printPermutation(String ques, String asf, HashSet<String> set) {
    if(ques.length()==0){
        set.add(asf);
        return;
    }
        for (int i = 0; i < ques.length(); i++) {
            char ch = ques.charAt(i);
            String roq = ques.substring(0,i) + ques.substring(i+1);
            printPermutation(roq,asf+ch, set);
        }
    }
}


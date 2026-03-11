package Recursion;

import java.util.HashSet;
import java.util.Scanner;

public class leetcodeSubsequence2 {
    static void main() {
        Scanner sc = new Scanner(System.in);
        String ques = sc.next();
        HashSet<String> set= new HashSet<>();
        printSubsequence(ques,"",set);
        System.out.println(set.size()-1);
    }

    private static void printSubsequence(String ques, String ans, HashSet<String> set) {
        if(ques.length()==0){
            set.add(ans);
            return;
        }
        char ch = ques.charAt(0);
        String roq = ques.substring(1);
        printSubsequence(roq,ans+"",set);
        printSubsequence(roq,ans+ch,set);
    }
}

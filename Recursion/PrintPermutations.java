package Recursion;

import java.util.Scanner;

public class PrintPermutations {
    static void main() {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        printPermutation(str,"");
}
//asf -> answer so far
    private static void printPermutation(String ques, String asf) {
    if(ques.length()==0){
        System.out.println(asf);
        return;
    }
        for (int i = 0; i < ques.length(); i++) {
            char ch = ques.charAt(i);
            String roq = ques.substring(0,i) + ques.substring(i+1);
            printPermutation(roq,asf+ch);
        }
    }
}


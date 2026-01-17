package Recursion;

import java.util.Scanner;

public class PrintKeypadCombination {
    static void main() {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        printKPC(str,"");
    }
    static String[] codes = {".;","abc","def","ghi","jkl","mno","pqrs","tu","vwx","yz"};
    private static void printKPC(String ques, String ans) {
        //base case
        if(ques.length()==0){
            System.out.println(ans);
            return;
        }
        char ch = ques.charAt(0);
        String roq = ques.substring(1);

        String code_for_ch = codes[ch-'0'];
        for (int i = 0; i < code_for_ch.length(); i++) {
            char cho = code_for_ch.charAt(i);
            printKPC(roq,ans + cho);

        }
    }
}

package Recursion;
import java.util.ArrayList;
import java.util.Scanner;

public class GetKeypadCombination {
    public static void main() {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        ArrayList<String> res = getSS(str);
        System.out.println(res);
    }
    static String [] codes = {".;","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    private static ArrayList<String> getSS(String str) {
        if(str.length() == 0){
            ArrayList<String> bres = new ArrayList<>();
            bres.add("");
            return bres;
        }
        char ch = str.charAt(0);
        String ros = str.substring(1);
        ArrayList<String> rres = getSS(ros);
        ArrayList<String> mres = new ArrayList<>();
        String p = codes[ch - '0'];
        for(int i=0;i<p.length();i++){
            char chCode = p.charAt(i);
            for(String s:rres){
                mres.add(chCode+s);
            }
        }
        return mres;
    }

}

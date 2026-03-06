package Recursion;
import java.util.ArrayList;
import java.util.Scanner;

public class GetSubsequence {
    static void main() {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        ArrayList <String> res = gss(str);
        System.out.println(res);
    }

    public static ArrayList<String> gss(String str){
    if(str.length() == 0) { //base case
        ArrayList <String> bres = new ArrayList<>(); //bres -> black result
        bres.add(" ");
        return bres;
    }
    char ch = str.charAt(0);
    String ros = str.substring(1); //ros -> rest of string
    ArrayList <String> rres = gss(ros); //rres -> recursive result

        ArrayList <String> mres = new ArrayList<>(); //my result
        for (String rstr: rres){
            mres.add(" " + rstr);
            mres.add(ch + rstr);
        }
        return mres;
    }
}

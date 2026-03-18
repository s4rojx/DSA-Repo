import java.util.*;

public class CountEncodings {
    static void main() {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int [] dp = new int[str.length()];
        dp[0] =  1;
        for (int i = 1; i <dp.length ; i++) {
            if(str.charAt(i-1)=='0'&& str.charAt(i) =='0'){
                dp[i] = 0;
            } else if (str.charAt(i-1)=='0'&& str.charAt(i) !='0') {
                dp[i] = dp[i-1];
            }
            else if (str.charAt(i-1)!='0'&& str.charAt(i) =='0') {
                    if(str.charAt(i-1) =='1' || str.charAt(i)== '2') {
                    dp[i] = dp[i-2];
                    }
                    else{
                        dp[i] = 0;
                    }
                }
            else{
                if(Integer.parseInt(str.substring(i-1,i+1)) <=26){
                    dp[i] = dp[i-1]+dp[i-2];
                }
                else{

                }
            }
        }
    }
}

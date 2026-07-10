package Sliding_Window;

import java.util.ArrayList;
import java.util.Scanner;

public class FirstNegativeIntegerInEveryWindowK {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int i = 0, j = 0;
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        while (j < n) {
            if(arr[j] < 0){
                list.add(arr[j]);
            }
            if(j-i+1 < k){
                j++;
            }else if(j-i+1 == k){
                if(list.size() == 0){
                    ans.add(0);
                }
                else{
                    ans.add(list.get(0));
                    if(arr[i]==list.get(0)){
                        list.remove(0);
                    }
                }
                i++;
                j++;
            }
        }
        System.out.println(ans.toString());

    }

}

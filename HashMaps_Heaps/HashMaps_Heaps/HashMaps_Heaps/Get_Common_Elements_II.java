package HashMaps_Heaps;
import java.util.*;

public class Get_Common_Elements_II {
    static void main() {
        Scanner sc  = new Scanner(System.in);
        int n1 = sc.nextInt();
        int [] a1 = new int[n1];
        for (int i = 0; i < n1; i++) {
            a1[i] = sc.nextInt();
        }
        int n2 = sc.nextInt();
        int [] a2 = new int[n2];
        for (int i = 0; i < n2; i++) {
            a2[i] = sc.nextInt();
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n1; i++) {
            map.merge(a1[i],1,Integer::sum);
        }
        for (int i = 0; i < n2; i++) {
            if(map.containsKey(a2[i]) && map.get(a2[i])>0){
                map.merge(a1[i],1,(a,b)->a-b );
                System.out.print(+a2[i]+" ");
            }
        }
    }
}

import java.util.Scanner;

public class ClimbStair {
    static void main() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int cp = countPaths(n, new int[n+1]);
        System.out.println(cp);

    }
    public static int countPaths(int n, int [] qb){

        if(n == 0){
            return 1;
        }
        else if (n < 0){
            return 0;
        }
        if(qb[n] != 0){
            return qb[n];
        }

        //Assuming that the below recursive code gives total no path for
        //n-1 stairs , n-2 stairs and n-3 stairs
        int nm1 = countPaths(n-1,qb);
        int nm2 = countPaths(n-2,qb);
        int nm3 = countPaths(n-3,qb);

        int cp = nm1 + nm2 + nm3;
        //CP = total no of paths from (n-1), (n-2), (n-3) steps
        qb[n] = cp;
        return cp;
    }
}

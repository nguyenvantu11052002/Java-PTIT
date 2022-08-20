
package newclass;

import java.util.*;

public class NewClass1 {
    
    public static long[] F = new long[100];
    
    public static void Prepare () {
        F[1] = F[2] = 1;
        for (int i = 3; i <= 92; i++) {
            F[i] = F[i - 2] + F[i - 1];
        }
    }
    
    public static int solve (int n, long k) {
        while (n > 2) {
            if (k <= F[n - 2]) {
                n -= 2;
            }
            else {
                k -= F[n - 2];
                n -= 1;
            }
        }
        if (n == 1)return 0;
        else return 1;
    }
    
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       int t = 1;
       t = sc.nextInt();
       Prepare();
       while (t--> 0) {
           int n = sc.nextInt();
           long k = sc.nextLong();
           System.out.println(solve(n, k));
       }
    }
    
}

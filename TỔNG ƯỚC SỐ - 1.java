
package newclass;

import java.util.*;

public class NewClass {
    
    public static int[] nTo = new int[2000001];
    
    public static void sangNTo () {
        nTo[0] = nTo[1] = -1;
        for (int i = 2; i <= Math.sqrt(2000001); i++) {
            if (nTo[i] == 0) {
                for (int j = i * i; j <= 2000000; j += i) {
                    nTo[j] = -1;
                }
            }
        }
    }
    
    public static long solve (int n) {
        if (nTo[(int) n] == 0) {
            return n;
        }
        long sum = 0;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            while (n % i == 0) {
                sum += i;
                n /= i;
            }
        }
        if (n > 1) {
            sum += n;
        }
        return sum;
    }

    
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       int t = 1;
       sangNTo();
       //t = sc.nextInt();
       while (t--> 0) {
           int n = sc.nextInt();
           int[] a = new int[n];
           long sum = 0;
           for (int i = 0; i < n; i++) {
               a[i] = sc.nextInt();
               sum += solve(a[i]);
           }
           System.out.println(sum);
       }
    }
    
}


package helloworld;

import java.util.*;

public class HelloWorld {

    public static boolean check (int[] a, int n) {
        int l = 0, r = n - 1;
        while (l <= r) {
            if (a[l] != a[r]) return false;
            ++l; --r;
        }
        return true;
    }
    
    public static void main(String[] args) {
 
        Scanner sc = new Scanner(System.in);
        int t = 1;
        t = sc.nextInt();
        while (t-->0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            if (check(a, n)) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
    

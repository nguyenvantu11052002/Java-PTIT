package newclass;

import java.util.*;

public class NewClass1 {
    
    public static int[] a = new int[15];
    public static int n;
    public static boolean[] vs = new boolean[15];
    
    public static boolean check () {
        for (int i = 1; i <= n - 1; i++) {
            if (Math.abs(a[i] - a[i + 1]) == 1) return false;
        }
        return true;
    }
    
    public static void solve () {
        for (int i = 1; i <= n; i++) {
            System.out.print(a[i]);
        }
        System.out.println("");
    }
    
    public static void Try (int i) {
        for (int j = 1; j <= n; j++) {
            if (vs[j] == false) {
                vs[j] = true;
                a[i] = j;
                if (i == n) {
                    if (check()) solve();
                }
                else Try(i + 1);
                vs[j] = false;
            }
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = 1;
        t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            n = sc.nextInt();
            Arrays.fill(vs, false);
            Try(1);
        }
    }
}

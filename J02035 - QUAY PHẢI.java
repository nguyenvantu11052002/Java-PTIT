package javaptit;

import java.util.*;

public class JavaPTIT {
    
    public static int solve (long[] a, int n, long x) {
        for (int i = 0; i < n; i++) {
            if (a[i] == x) return i;
        }
        return -1;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = 1;
        t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            int n = sc.nextInt();
            long[] a = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextLong();
            }
            long[] b = Arrays.copyOf(a, n);
            Arrays.sort(b);
            // tim vi tri cua phan tu a[0]; 
            // ket qua se la index;
            long x = b[0];
            System.out.println(solve(a, n, x));
        }
    }
}

package javaptit;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigInteger;
import java.util.*;
import java.util.ArrayList;
import java.util.Collections;

public class JavaPTIT {

    public static boolean checkCP(int a, int b) {
        long res = 1l * a * a + 1l * b * b;
        long can = (long) Math.sqrt(res);
        return res == can * can;
    }
    
    public static boolean timSo (int[] a, int l, int r, int x) {
        while (l <= r) {
            int m = (l + r)/2;
            if (a[m] == x) {
                return true;
            }
            else if (a[m] < x) {
                l = m + 1;
            }
            else r = m - 1;
        }
        return false;
    }
    
    public static boolean check(int[] a, int n) {
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (checkCP(a[i], a[j])) {
                    int x = (int) Math.sqrt(1l * a[i] * a[i] + 1l * a[j] * a[j]);
                    if (timSo(a, j, n - 1, x)) return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = 1;
        t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            Arrays.sort(a);
            if (check (a, n)) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}

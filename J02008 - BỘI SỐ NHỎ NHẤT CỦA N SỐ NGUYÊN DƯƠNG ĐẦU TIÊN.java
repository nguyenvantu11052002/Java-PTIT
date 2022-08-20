package newclass;

import java.util.*;

public class NewClass {

    public static long gcd(long a, long b) {
        while (b != 0) {
            long x = a % b;
            a = b;
            b = x;
        }
        return a;
    }

    public static long lcm(long a, long b) {
        return 1l * a * b / gcd(a, b);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = 1;
        t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            long res = 1;
            for (int i = 1; i <= n; i++) {
                res = lcm(res, i);
            }
            System.out.println(res);
        }
    }
}



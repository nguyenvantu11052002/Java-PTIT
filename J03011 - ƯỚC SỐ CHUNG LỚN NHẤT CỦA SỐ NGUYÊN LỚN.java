package newclass;

import java.util.*;

public class NewClass {
    
    public static long solve (String a, long b) {
        long res = 0;
        for (int i = 0; i < a.length(); i++) {
            res = res * 10 + a.charAt(i) - '0';
            res %= b;
        }
        return res;
    }
    
    public static long gcd (String a, long b) {
        long tmp = solve(a, b);
        long amoi = b;
        long bmoi = tmp;
        while (bmoi != 0) {
            long x = amoi % bmoi;
            amoi = bmoi;
            bmoi = x;
        }
        return amoi;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = 1;
        t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            long b = Long.parseLong(sc.nextLine());
            String a = sc.nextLine();
            System.out.println(gcd(a, b));
        }
    }
}

//1
//1221
//1234567891011121314151617181920212223242526272829

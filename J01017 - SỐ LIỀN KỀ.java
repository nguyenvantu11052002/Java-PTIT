 
import java.util.*;
 
public class NewClass {
    public static int chuyen (char c) {
        return c - '0';
    }
    public static boolean check (long n) {
        String s = Long.toString(n);
        s.toCharArray();
        int m = s.length();
        int a0 = s.charAt(0) - '0';
        int a1 = s.charAt(1) - '0';
        int aGanCuoi = s.charAt(m - 2) - '0';
        int aCuoi = s.charAt(m - 1) - '0';
        if (Math.abs(a0 - a1) != 1 || Math.abs(aCuoi - aGanCuoi) != 1) return false;
        for (int i = 1; i < s.length() - 1; i++) {
            if (Math.abs(chuyen(s.charAt(i))- chuyen(s.charAt(i - 1))) != 1 || 
                  Math.abs(chuyen(s.charAt(i))- chuyen(s.charAt(i + 1))) != 1   )  return false;
        }
        return true;
    }
 
    public static void main(String[] args) {
 
        Scanner sc = new Scanner(System.in);
        int t = 1;
        t = sc.nextInt();
        while (t-->0) {
            long n = sc.nextLong();
            if (check(n)) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}

 
import java.util.*;
 
public class NewClass {
    public static int chuyen (char c) {
        return c - '0';
    }
    public static boolean check1 (long n) {
        String s = Long.toString(n);
        s.toCharArray();
        int m = s.length();
        int a0 = s.charAt(0) - '0';
        int a1 = s.charAt(1) - '0';
        int aGanCuoi = s.charAt(m - 2) - '0';
        int aCuoi = s.charAt(m - 1) - '0';
        if (Math.abs(a0 - a1) != 2 || Math.abs(aCuoi - aGanCuoi) != 2) return false;
        for (int i = 1; i < s.length() - 1; i++) {
            if (Math.abs(chuyen(s.charAt(i))- chuyen(s.charAt(i - 1))) != 2 || 
                  Math.abs(chuyen(s.charAt(i))- chuyen(s.charAt(i + 1))) != 2   )  return false;
        }
        return true;
    }
 
    public static boolean check2 (long n) {
        int sum = 0;
        while (n > 0) {
            long d = n % 10;
            n /= 10;
            sum += d;
        }
        return sum % 10 == 0;
    }
    
    public static void main(String[] args) {
 
        Scanner sc = new Scanner(System.in);
        int t = 1;
        t = sc.nextInt();
        while (t-->0) {
            long n = sc.nextLong();
            if (check1(n) && check2(n)) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}

 
import java.util.*;
 
public class NewClass {
 
    public static boolean check (long n) {
        boolean ok = false;
        while (n > 0) {
            long d = n % 10;
            n /= 10;
            if (d != 0 && d != 1 && d != 8 && d != 9) return false;
            if (d == 1) ok = true;
        }
        if (ok) return true;
        return false;
    }
 
    public static long chuyen (long n) {
        StringBuilder str = new StringBuilder("");   
        while (n > 0) {
            long d = n % 10;
            n /= 10;
            if (d != 1) {
                str.append("0");
            }
            else str.append("1");
        }
        str.reverse();
        String s = str.toString();      
        long res = Long.parseLong(s);
        return res;
    }
 
    public static void main(String[] args) {
 
        Scanner sc = new Scanner(System.in);
        int t = 1;
        t = sc.nextInt();
        while (t-->0) {
            long n = sc.nextLong();
            if (check(n) == false) System.out.println("INVALID");
            else {
                System.out.println(chuyen(n));
            }
        }
    }
}

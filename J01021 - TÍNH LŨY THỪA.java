 
import java.util.*;
 
public class NewClass {
    public static long m = 1000000007;
    
    public static long powMod (long a, long b) {
        if (b == 0) return 1;
        long x = powMod(a, b/2);
        if (b % 2 == 1) return (((x * x) % m) * a) % m;
        else return x * x % m;
    }
    
    public static void main(String[] args) {
 
        Scanner sc = new Scanner(System.in);
        int t = 25;
        //t = sc.nextInt();
        while (t-->0) {
            long a = sc.nextLong(), b = sc.nextLong();
            if (a == 0 && b == 0) return;
            System.out.println(powMod(a, b));
        }
    }
}

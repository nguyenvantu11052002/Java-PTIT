
import java.util.*;

public class NewClass {
    
    public static long solve (long n) {
        long res = -1;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                while (n % i == 0) {
                    n /= i;
                }
                res = Math.max(res, i);
            }
        }
        if (n > 1) res = Math.max(res, n);
        return res;
    }
    
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = 1;
        t = sc.nextInt();
        while (t-->0) {
            long n = sc.nextLong();
            System.out.println(solve(n));
        }
    }
}


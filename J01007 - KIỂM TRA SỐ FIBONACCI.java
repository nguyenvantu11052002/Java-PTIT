
import java.util.*;

public class NewClass {
    public static long[] F = new long[100];
    public static boolean Fibo (long n) {
        if (n == 0 || n == 1) return true;
        F[0] = 0; F[1] = 1;
        for (int i = 2; i <= 92; i++) {
            F[i] = F[i - 1] + F[i - 2];
            if (F[i] == n) return true;
            else if (F[i] > n) return false;
        }
        return false;
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = 1;
        t = sc.nextInt();
        while (t-- > 0) {
            long n = sc.nextLong();
            if (Fibo(n)) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}


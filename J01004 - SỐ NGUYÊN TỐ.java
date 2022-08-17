
import java.util.*;

public class NewClass {
    public static boolean ktra (int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return n > 1;
    }
        
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = 1;
        t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            if (ktra(n)) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}


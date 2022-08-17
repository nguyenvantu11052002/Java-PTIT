
import java.util.*;

public class NewClass {
    
    public static boolean check (long n) {
        int cnt = 0;
        while (n > 0) {
            long d = n % 10;
            n /= 10;
            if (d == 4 || d == 7) cnt++;
        }
        return cnt == 4 || cnt == 7;
    }
    
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = 1;
        //t = sc.nextInt();
        while (t-->0) {
            long n = sc.nextLong();
            if (check(n)) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}


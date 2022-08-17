 
import java.util.*;
 
public class NewClass {
    public static long m = 1000000007;
    
    public static boolean check (int n) {
        int m = (int) Math.sqrt(n);
        return m * m == n;
    }
    
    public static void main(String[] args) {
 
        Scanner sc = new Scanner(System.in);
        int t = 1;
        t = sc.nextInt();
        while (t-->0) {
            int n = sc.nextInt();
            if (check(n)) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}

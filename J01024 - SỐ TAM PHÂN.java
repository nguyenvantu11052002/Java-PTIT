
package newclass;

import java.util.*;

public class NewClass1 {
    
    public static boolean check (int n) {
        while (n > 0) {
            int d = n % 10;
            n /= 10;
            if (d != 0 && d != 1 && d != 2) return false;
        }
        return true;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = 1;
        t = sc.nextInt();
        while (t--> 0) {
            int n = sc.nextInt();
            if (check(n)) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}

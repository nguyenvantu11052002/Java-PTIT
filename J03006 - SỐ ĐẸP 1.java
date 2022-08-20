package newclass;

import java.util.*;

public class NewClass {

    public static int chuyen (char c) {
        return c - '0';
    }
    
    public static boolean check (String s) {
        int l = 0, r = s.length() - 1;
        while (l <= r) {
            if (s.charAt(l) != s.charAt(r)) return false;
            ++l; --r;
        }
        for (int i = 0; i < s.length(); i++) {
            if (chuyen(s.charAt(i)) % 2 != 0) {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = 1;
        t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String s = sc.nextLine();
            if (check(s)) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}


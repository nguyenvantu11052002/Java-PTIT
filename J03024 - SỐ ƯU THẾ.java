package newclass;

import java.util.*;

public class NewClass {
    
    public static boolean check (String s) {
        if (s.charAt(0) == '0') return false;
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i)) == false) return false;
        }
        return true;
    }
    
    public static int chan (String s) {
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if ((s.charAt(i) - '0') % 2 == 0) cnt++;
        }
        return cnt;
    }
    
    public static int le (String s) {
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            int x = s.charAt(i) - '0';
            if (x % 2 != 0) cnt++;
        }
        return cnt;
    }
    
    public static boolean solve (String s) {
        int n = s.length();
        if (n % 2 == 0 && chan(s) > le(s) || n % 2 != 0 && le(s) > chan(s)) return true;
        return false;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = 1;
        t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String s = sc.nextLine();
            if (check(s)) {
                if (solve(s)) System.out.println("YES");
                else System.out.println("NO");
            }
            else {
                System.out.println("INVALID");
            }
        }
    }
}



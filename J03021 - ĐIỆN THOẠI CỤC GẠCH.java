package newclass;

import java.math.BigInteger;
import java.util.*;

public class NewClass {
    
    public static char solve (char c) {
        int x = (int) c;
        if (x >= 65 && x <= 67) return '2';
        if (x >= 68 && x <= 70) return '3';
        if (x >= 71 && x <= 73) return '4';
        if (x >= 74 && x <= 76) return '5';
        if (x >= 77 && x <= 79) return '6';
        if (x >= 80 && x <= 83) return '7';
        if (x >= 84 && x <= 86) return '8';
        if (x >= 87 && x <= 90) return '9';
        return '0';
    }
    
    public static boolean check (String s) {
        int l = 0, r = s.length() - 1;
        while (l <= r) {
            if (s.charAt(r) != s.charAt(l)) return false;
            l++; r--;
        }
        return true;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = 1;
        t = Integer.parseInt(sc.nextLine());
       
        while (t-- > 0) {
            String s = sc.nextLine();
            s = s.toUpperCase();
            String res = "";
            for (int i = 0; i < s.length(); i++) {
                res += solve(s.charAt(i));
            }
            if (check(res)) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
    
    
//2
//BOHIMA
//IamACoder

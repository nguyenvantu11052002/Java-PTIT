package newclass;

import java.util.*;

public class NewClass {
      
    public static boolean check (String s) {
        int len = s.length();
        if (s.charAt(0) != '8' || s.charAt(len - 1) != '8') return false;
        int  l = 0, r = len - 1;
        while (l <= r) {
            if (s.charAt(l) != s.charAt(r)) return false;
            ++l; --r;
        }
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += (s.charAt(i) - '0');
        }
        return sum % 10 == 0;
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

        

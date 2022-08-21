package newclass;

import java.util.*;

public class NewClass {

    public static boolean check(String s) {
        int len = s.length();
        int l = 0, r = len - 1;
        while (l <= r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            ++l;
            --r;
        }
        for (int i = 0; i < len; i++) {
            int x = s.charAt(i) - '0';
            if (x != 2 && x != 5 && x != 7 && x != 3) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = 1;
        t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String s = sc.nextLine();
            if (check(s)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}


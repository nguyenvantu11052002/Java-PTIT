package newclass;

import java.util.*;

public class NewClass {
    
    public static int check (String s) {
        int l = 0, r = s.length() - 1;
        int cnt = 0;
        while (l <= r) {
            if (s.charAt(l) != s.charAt(r)) {
                cnt++;
            }
            l++; r--;
        }
        return cnt;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = 1;
        t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String s = sc.nextLine();
            int n = s.length();
            if (n % 2 == 0) {
                if (check(s) == 1) {
                    System.out.println("YES");
                }
                else System.out.println("NO");
            }
            else {
                if (check(s) <= 1) System.out.println("YES");
                else System.out.println("NO");
            }
        }
    }
}


//3
//abccaa
//abbcca
//abcda

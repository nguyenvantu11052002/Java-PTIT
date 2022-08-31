package javaptit;

import java.util.*;

public class JavaPTIT {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = 1;
        t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String s = sc.nextLine();
            if (s.length() < 26) {
                System.out.println("NO");
                return;
            }
            int k = Integer.parseInt(sc.nextLine());
            Set<Character> set = new HashSet<>();
            for (int i = 0; i < s.length(); i++) {
                set.add(s.charAt(i));
            }    
            if (26 - set.size() > k) {
                System.out.println("NO");
            }
            else System.out.println("YES");
        }
    }
}


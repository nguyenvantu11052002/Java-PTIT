package javaptit;

import java.math.*;
import java.util.*;

public class JavaPTIT1 {
      
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int t = 1;
        t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String s1 = sc.nextLine();
            String s2 = sc.nextLine();
            int res = Math.max(s1.length(), s2.length());
            if (s1.equals(s2)) {
                System.out.println("-1");
            }
            else System.out.println(res);
        }
    }
}

//2
//abcd
//defgh
//a
//aJ03026 

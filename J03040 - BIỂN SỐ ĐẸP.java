package javaptit;

import java.math.BigInteger;
import java.util.*;

public class JavaPTIT {

    public static boolean check1 (String s) {
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) - '0' >= s.charAt(i + 1) - '0') return false;
        }
        return true;
    }
    
     public static boolean check2 (String s) {
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) - '0' != s.charAt(i + 1) - '0') return false;
        }
        return true;
    }
     
    public static boolean check3 (String s) {
        if (s.charAt(0) == s.charAt(1) && s.charAt(1) == s.charAt(2) && s.charAt(3) == s.charAt(4)) return true;
        return false;
    }
     
     public static boolean check4 (String s) {
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) != '6' && s.charAt(i) != '8') return false;
        }
        return true;
    }
    
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int t = 1;
        t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String s = sc.nextLine().substring(5, 11);
            StringBuilder sb = new StringBuilder(s);
            sb.deleteCharAt(3);
            //System.out.println(sb);
            String res = sb.toString();
            if (check1(res) || check2(res) || check3(res) || check4(res)) {
                System.out.println("YES");
            }
            else System.out.println("NO");
        }
    }
}


//7
//29T1–123.45
//29T1–555.55
//29T1–222.33
//29T1–686.88
//29T1–123.33
//29T1–555.54
//29T1–606.88

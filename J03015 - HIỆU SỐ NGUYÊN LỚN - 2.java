package newclass;

import java.math.BigInteger;
import java.util.*;

public class NewClass1 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = 1;
        //t = Integer.parseInt(sc.nextLine());
        
        while (t-- > 0) {
            String s1 = sc.nextLine();
            String s2 = sc.nextLine();
            int n = Math.max(s1.length(), s2.length());
            BigInteger a = new BigInteger(s1, 10);
            BigInteger b = new BigInteger(s2, 10);
            BigInteger res = a.subtract(b);
            String ans = res.toString();
           // while (ans.length() < n) ans = "0" + ans;
            System.out.println(ans);
        }
    }
}

//2
//978
//12977
//100
//1000000


//000123456789012345678901234567890
//00000000000000001234567890

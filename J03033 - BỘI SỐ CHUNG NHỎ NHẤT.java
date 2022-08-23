package newclass;

import java.math.BigInteger;
import java.util.*;

public class NewClass {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = 1;
        t = Integer.parseInt(sc.nextLine());
        
        while (t-- > 0) {
            String s1 = sc.nextLine();
            String s2 = sc.nextLine();
            BigInteger a = new BigInteger(s1, 10);
            BigInteger b = new BigInteger(s2, 10);
            BigInteger ucln = a.gcd(b);
            BigInteger res = a.multiply(b).divide(ucln);
            System.out.println(res);
        }
    }
}

    

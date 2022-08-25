package javaptit;

import java.math.BigInteger;
import java.util.*;

public class JavaPTIT {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int t = 1;
        t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            BigInteger a = sc.nextBigInteger();
            BigInteger b = sc.nextBigInteger();
            if (a.compareTo(b) < 0) {
                BigInteger tmp = a;
                a = b;
                b = tmp;
            }
            BigInteger so0 = new BigInteger("0");
            if (a.remainder(b).equals(so0)) {
                System.out.println("YES");
            }
            else System.out.println("NO");
        }
    }
}

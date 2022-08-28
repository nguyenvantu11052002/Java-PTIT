package javaptit;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.*;

public class JavaPTIT {

    public static void Try (String s) {
       if (s.length() <= 1) return;
       int n = s.length() / 2;
       BigInteger a1 = new BigInteger(s.substring(0, n));
       BigInteger a2 = new BigInteger(s.substring(n, s.length()));
       BigInteger res = a1.add(a2);
       System.out.println(res);
       Try (res.toString());
    }
    
    public static void main(String[] args) throws FileNotFoundException {
        //Scanner sc = new Scanner(System.in);
        int t = 1;
        //t = Integer.parseInt(sc.nextLine());
        while (t--> 0) {
            Scanner sc = new Scanner(new File("DATA.in"));
            String s = "";
            while (sc.hasNext()) {
                s = sc.next();
            }
            int n = s.length();
            Try (s);
        }
    }
}

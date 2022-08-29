package javaptit;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigInteger;
import java.util.*;
import java.util.ArrayList;
import java.util.Collections;

public class JavaPTIT {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = 1;
        t = Integer.parseInt(sc.nextLine());
        while (t-->0) {
            BigInteger a = new BigInteger(sc.nextLine());
            BigInteger b = new BigInteger("11");
            BigInteger so0 = new BigInteger("0");
            if (a.remainder(b).equals(so0)) {
                System.out.println(1);
            }
            else System.out.println(0);
        }
    }
}

//1
//12
//198111

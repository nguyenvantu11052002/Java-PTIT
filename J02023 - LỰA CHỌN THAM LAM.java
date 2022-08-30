package javaptit;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigInteger;
import java.util.*;
import java.util.ArrayList;
import java.util.Collections;

public class JavaPTIT {
    
    public static void solve (int n, int s) {
        if (s == 0) {
            if (n == 1){
                System.out.println("0 0");
                return;
            }
            else {
                System.out.println("-1 -1");
                return;
            }
        }
        if (s > 9 * n) {
            System.out.println("-1 -1");
            return;
        }
        String res = "";
        int luuS = s;
        s--;
        // tim so nho nhat
        for (int i = 1; i < n; i++) {
            if (s >= 9) {
                res = "9" + res;
                s -= 9;
            }
            else {
                res = Integer.toString(s) + res;
                s = 0;
            }
        }
        res = Integer.toString(s + 1) + res;
        String res1 = "";
        s = luuS;
        for (int i = 0; i < n; i++) {
            if (s >= 9) {
                res1 += "9";
                s -= 9;
            }
            else {
                res1 += Integer.toString(s);
                s = 0;
            }
        }
        System.out.println(res + " " + res1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = 1;
       // t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            int n = sc.nextInt(), s = sc.nextInt();
            solve(n, s);
        }
    }
}

package newclass;

import java.util.*;

public class NewClass1 {
    
    public static boolean check (String a, String b) {
        if (a.length() < b.length()) {
            return false;
        }
        else if (a.length() == b.length() && a.compareTo(b) < 0) {
            return false;
        }
        return true;
    }
     
    public static String solve (String a, String b) {
        int nho = 0;
        int n = a.length();
        String res = "";
        for (int i = n - 1; i >= 0; i--) {
            int so = (a.charAt(i) - '0') - (b.charAt(i) - '0') - nho;
            //System.out.println("so ne: " + so);
            if (so < 0) {
                nho = 1;
                so += 10;
                String c = Integer.toString(so);
                res = c + res;
                //System.out.println("res ne " + res);
            }
            else {
                nho = 0;
                String c = Integer.toString(so);
                res = c + res;
                //System.out.println("res ne " + res);
            }
        }
        return res;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = 1;
        t = Integer.parseInt(sc.nextLine());
        
        while (t-- > 0) {
            String a = sc.next();
            String b = sc.next();
            if (check(a, b) == false) {
                String tmp = a;
                a = b;
                b = tmp;
            }
            while(b.length() < a.length()) b = "0" + b;
            //System.out.println("a : " + a + " b : " + b);   
            System.out.println(solve(a, b));
        }
    }
}

//2
//978
//12977
//100
//1000000


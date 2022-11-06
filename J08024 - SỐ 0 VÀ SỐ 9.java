package javaptit;

import java.util.Collection;
import java.util.Scanner;
import java.util.*;
 
public class Main {
    public static void main(String [] agrs){
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        
        while (t-->0) {
            int n = sc.nextInt();
            ArrayDeque<String> dq = new ArrayDeque<>();
            dq.addLast("9");
            while(true) {
                long dinhHangDoi = Long.parseLong(dq.getFirst());
                if (dinhHangDoi % n == 0) {
                    System.out.println(dinhHangDoi);
                    break;
                }
                else {
                    String res = dq.getFirst();
                    dq.addLast(res + "0");
                    dq.addLast(res + "9");
                    dq.removeFirst();
                }
            }
        }
    }
 
}



package javaptit;

import java.util.Collection;
import java.util.Scanner;
import java.util.*;
 
public class Main {
    public static void main(String [] agrs){
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        
        while (t-->0) {
            ArrayList<Long> list = new ArrayList<>();
            
            int n = sc.nextInt();
            ArrayDeque<String> dq = new ArrayDeque<>();
            dq.addLast("6");
            dq.addLast("8");
            while(true) {
                String dinhHangDoi = dq.getFirst();
              
                if (dinhHangDoi.length() > n) {
                    break;
                }
                else {
                    dq.addLast(dinhHangDoi + "6");
                    dq.addLast(dinhHangDoi + "8");
                    list.add(Long.parseLong(dinhHangDoi));
                    dq.removeFirst();
                }
            }
            Collections.sort(list, Comparator.reverseOrder());
            System.out.println(list.size());
            for (Long x : list) {
                System.out.print(x + " ");
            }
            System.out.println("");
        }
    }
 
}

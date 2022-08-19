
package newclass;

import java.util.*;

public class NewClass {
    
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       int t = 1;
       //t = sc.nextInt();
       while (t--> 0) {
           int n = sc.nextInt(), m = sc.nextInt();
           TreeSet<Integer> set = new TreeSet<>();
           for (int i = 0; i < n; i++) {
               int x = sc.nextInt();
               set.add(x);
           }
           for (int i = 0; i < m; i++) {
               int x = sc.nextInt();
               set.add(x);
           }
           for (Integer x : set) {
               System.out.print(x + " ");
           }
       }
    }
    
}

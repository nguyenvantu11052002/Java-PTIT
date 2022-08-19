
package newclass;

import java.util.*;

public class NewClass {
    
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       int t = 1;
       //t = sc.nextInt();
       while (t--> 0) {
           int n = sc.nextInt(), m = sc.nextInt();
           Set<Integer> set1 = new HashSet<>();
           Set<Integer> set2 = new HashSet<>();
           TreeMap<Integer, Integer> map = new TreeMap<>();
           for (int i = 0; i < n; i++) {
               int x = sc.nextInt();
               set1.add(x);
           }
           for (int i = 0; i < m; i++) {
               int x = sc.nextInt();
               set2.add(x);
           }
           for (Integer x : set1) {
               if (map.containsKey(x)) {
                   int ts = map.get(x);
                   ++ts;
                   map.put(x, ts);
               }
               else map.put(x, 1);
           }
           
           for (Integer x : set2) {
               if (map.containsKey(x)) {
                   int ts = map.get(x);
                   ++ts;
                   map.put(x, ts);
               }
               else map.put(x, 1);
           }
           
           for (Map.Entry<Integer, Integer> x : map.entrySet()) {
               if (x.getValue() == 2) {
                   System.out.print(x.getKey() + " ");
               }
           }
           System.out.println("");
       }
    }
    
}

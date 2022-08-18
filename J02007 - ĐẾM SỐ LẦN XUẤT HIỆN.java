
package newclass;

import java.util.*;

public class NewClass1 {
       
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = 1;
        t = sc.nextInt();
        for (int j = 1; j <= t; j++) {
            System.out.println("Test " + j + ":");
            int n = sc.nextInt();
            int[] a = new int[n];
            LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
                if (map.containsKey(a[i])) {
                    int tanSuat = map.get(a[i]);
                    ++tanSuat;
                    map.put(a[i], tanSuat);
                }
                else {
                    map.put(a[i], 1);
                }
            }
            //Set<Integer> set = map.keySet();
            Set<Map.Entry<Integer, Integer>> setpair = map.entrySet();
            for (Map.Entry<Integer, Integer> x : setpair) {
                System.out.println(x.getKey() + " xuat hien " + x.getValue() + " lan");
            }
        }        
    }
}

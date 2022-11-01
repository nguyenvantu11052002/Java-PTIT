Main.java
package javaptit;

import java.util.*;
import static javaptit.SupportFunctions.check;


public class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int x, y;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < n - 1; i++) {
            x = sc.nextInt();
            y = sc.nextInt();
            if (map.containsKey(x)) {
                map.put(x, map.get(x) + 1);
            }
            else {
                map.put(x, 1);
            }
            if (map.containsKey(y)) {
                map.put(y, map.get(y) + 1);
            }
            else {
                map.put(y, 1);
            }
        }
        if (check(map, n)) {
            System.out.println("Yes");
        }
        else System.out.println("No");
        
    }


}


SupportFunctions.java
package javaptit;
import java.util.*;

public class SupportFunctions {
    
    public static boolean check(HashMap<Integer, Integer> map, int n) {
        int cnt = 0; // dem 1 so phai xuat hien n - 1 lan;
        Set<Integer> set = map.keySet();
        for (Integer x : set) {
            if (map.get(x) == n - 1) cnt += 1;
            if (cnt > 1) return false;
            if (map.get(x) != 1 && map.get(x) != n - 1) {
                return false;
            }
        }
        if (cnt != 1) return false;
        return true;
    }
}


package javaptit;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class JavaPTIT {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("DATA.in"));
        Map<Integer, Integer> map = new TreeMap<>();
        while(sc.hasNext()) {
            int n = Integer.parseInt(sc.next());
            if (map.containsKey(n)) {
                map.put(n, map.get(n) + 1);
            }
            else map.put(n, 1);
        }
        for (Map.Entry<Integer, Integer> x : map.entrySet()) {
            System.out.println(x.getKey() + " " + x.getValue());
        }
        sc.close();
    }
    
}

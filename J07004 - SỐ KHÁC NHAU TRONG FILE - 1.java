package javaptit;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class JavaPTIT {

    public static void main(String[] args) throws FileNotFoundException {
        Map<Integer, Integer> map = new TreeMap<>();
        
        try {
            File file = new File("DATA.in");
            Scanner sc = new Scanner(file);
            while (sc.hasNext()) {
                int n = sc.nextInt();
                if (map.containsKey(n)) {
                    map.put(n, map.get(n) + 1);
                }
                else map.put(n, 1);
            }
            for (Map.Entry<Integer, Integer> x : map.entrySet()) {
                System.out.println(x.getKey() + " " + x.getValue());
            }
        } catch (Exception e) {

        }
    }

}

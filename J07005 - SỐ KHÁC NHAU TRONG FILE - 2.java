
package javaptit;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class JavaPTIT {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        DataInputStream dis = new DataInputStream(new FileInputStream("DATA.IN"));
        Map<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < 100000; i++) {
            int n = dis.readInt();
            if (map.containsKey(n)) {
                map.put(n, map.get(n) + 1);
            }
            else map.put(n, 1);
        }
        for (Map.Entry<Integer, Integer> x : map.entrySet()) {
            System.out.println(x.getKey() + " " + x.getValue());
        }
        dis.close();
    }
    
}

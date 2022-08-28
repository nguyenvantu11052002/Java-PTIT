package javaptit;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class JavaPTIT {

    public static void main(String[] args) throws IOException {
        try {
            DataInputStream dt = new DataInputStream(new FileInputStream("DATA.IN"));
            Map<Integer, Integer> map = new TreeMap<>();
            for (int i = 0; i < 100000; i++) {
                int x = dt.readInt();
                if (map.containsKey(x)) {
                    map.put(x, map.get(x) + 1);
                }
                else map.put(x, 1);
            }
            for (Map.Entry<Integer, Integer> x : map.entrySet()) {
                System.out.println(x.getKey() + " " + x.getValue());
            }
            dt.close();
        } catch (Exception e) {

        }
    }
}

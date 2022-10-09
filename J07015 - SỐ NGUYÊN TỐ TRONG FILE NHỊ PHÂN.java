javaptit/CacHam.java

package javaptit;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class CacHam {
    public static long[] F = new long[1000005];
    
    public static void sangnto () {
        Arrays.fill(F, 1);
        F[0] = F[1] = 0;
        for (int i = 2; i <= 1001; i++) {
            if (F[i] == 1) {
                for (int j = i * i; j <= 1000001; j += i) {
                    F[j] = 0;
                }
            }
        }
    }
}

javaptit/Main.java
package javaptit;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.util.*;
import static javaptit.CacHam.F;
import static javaptit.CacHam.sangnto;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        sangnto();
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("SONGUYEN.in"));
        List<Integer> list = new ArrayList<>();
        list = (List<Integer>) ois.readObject();
        Map<Integer, Integer> map = new TreeMap<>();
        for (Integer x : list) {
            if (F[x] == 1) {
                if (map.containsKey(x)) {
                    map.put(x, map.get(x) + 1);
                } else {
                    map.put(x, 1);
                }
            }
        }
        for (Map.Entry<Integer, Integer> x : map.entrySet()) {
            System.out.println(x.getKey() + " " + x.getValue());
        }
    }

}


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
import static javaptit.SupportFunctions.generateReversibleNumbersWithConstraints;
import static javaptit.SupportFunctions.printResults;
import static javaptit.SupportFunctions.resultMap;
import static javaptit.SupportFunctions.toMap;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        generateReversibleNumbersWithConstraints();
        ObjectInputStream ois1 = new ObjectInputStream(new FileInputStream("DATA1.in"));
        ObjectInputStream ois2 = new ObjectInputStream(new FileInputStream("DATA2.in"));
        List<Integer> list1 = (List<Integer>) ois1.readObject();
        List<Integer> list2 = (List<Integer>) ois2.readObject();
        TreeMap<Integer, Integer> map1 = toMap(list1);
        TreeMap<Integer, Integer> map2 = toMap(list2);
        TreeMap<Integer, Integer> res = resultMap(map1, map2);
        printResults(res);
    }

}
javaptit/SupportFunctions.java
package javaptit;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class SupportFunctions {

    public static TreeMap<Integer, Integer> toMap(List<Integer> list) {
        TreeMap<Integer, Integer> res = new TreeMap<>();
        for (Integer x : list) {
            if (tick[x]) {
                if (res.containsKey(x)) {
                    res.put(x, res.get(x) + 1);
                } else {
                    res.put(x, 1);
                }
            }
        }
        return res;
    }

    public static boolean[] tick = new boolean[1000005];

    public static void generateReversibleNumbersWithConstraints() {
        Arrays.fill(tick, false);
        Queue<String> queue = new LinkedList<>();
        for (int i = 1; i <= 9; i += 2) {
            queue.add(Integer.toString(i));
        }
        while (!queue.isEmpty()) {
            StringBuilder top = new StringBuilder();
            top.append(queue.poll());
            for (int i = 1; i <= 9; i += 2) {
                int x = Integer.parseInt(top.toString() + i + top.reverse().toString());
                if (x > 9 && x <= 1000000) {
                    tick[x] = true;
                    queue.add(top.toString() + i);
                }
            }
        }
    }

    public static TreeMap<Integer, Integer> resultMap(TreeMap<Integer, Integer> map1, TreeMap<Integer, Integer> map2) {
        TreeMap<Integer, Integer> res = new TreeMap<>();
        for (Map.Entry<Integer, Integer> x : map1.entrySet()) {
            if (map2.containsKey(x.getKey())) {
                int frequency = map1.get(x.getKey()) + map2.get(x.getKey());
                res.put(x.getKey(), frequency);
            }
        }
        return res;
    }

    public static void printResults(TreeMap<Integer, Integer> res) {
        int cnt = 0;
        for (Map.Entry<Integer, Integer> x : res.entrySet()) {
            System.out.println(x.getKey() + " " + x.getValue());
            cnt += 1;
            if (cnt == 10) {
                break;
            }
        }
    }
}

package javaptit;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.*;

public class Main {

    public static int[] F = new int[1000005];

    public static void sangnto() {
        Arrays.fill(F, 1);
        F[0] = F[1] = 0;
        for (int i = 2; i <= 1001; i++) {
            if (F[i] != 0) {
                for (int j = i * i; j <= 1000001; j += i) {
                    F[j] = 0;
                }
            }
        }
    }

    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        sangnto();
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("DATA.in"));
        List<Integer> list = (List<Integer>) ois.readObject();
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
        List<Integer> list1 = new ArrayList<>();
        for (Map.Entry<Integer, Integer> x : map.entrySet()) {
            list1.add(x.getKey());
        }
        Collections.reverse(list1);
        for (int i = 0; i < 10; i++) {
            System.out.println(list1.get(i) + " " + map.get(list1.get(i)));
        }
    }
}

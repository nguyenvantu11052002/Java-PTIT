package javaptit;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.*;

public class JavaPTIT {
    
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        Scanner sc = new Scanner(System.in);
        int t = 1;
        //t = Integer.parseInt(sc.nextLine());
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("DATA.in"));
        List<Integer> list = (List<Integer>) ois.readObject();
        Map<Integer, Integer> map = new TreeMap<>();
        for (Integer x : list) {
            if (map.containsKey(x)) {
                map.put(x, map.get(x) + 1);
            }
            else map.put(x, 1);
        }
        Set<Integer> set = map.keySet();
        for (Integer x : set) {
            System.out.println(x + " " + map.get(x));
        }
    }
}

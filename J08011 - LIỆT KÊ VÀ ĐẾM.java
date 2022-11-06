Main.java
package javaptit;

import java.util.Collection;
import java.util.Scanner;
import java.util.*;
import java.util.Map.Entry;
 
public class Main {
    public static void main(String [] agrs){
        Scanner sc = new Scanner(System.in);
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
       // int cnt = 35;
        while(sc.hasNext()) {
            int tmp = sc.nextInt();
            if (Support.check(tmp)) {
                if (map.containsKey(tmp)) {
                    map.put(tmp, map.get(tmp) + 1);
                }
                else {
                    map.put(tmp, 1);
                }
            }
        }
        Set<Entry<Integer, Integer>> set = map.entrySet();
        ArrayList<Entry<Integer, Integer>> list = new ArrayList<>(set);
        Collections.sort(list, new SortBy());
        for (Entry<Integer, Integer> x : list) {
            System.out.println(x.getKey() + " " + x.getValue());
        }
    }
}



SortBy.java
package javaptit;

import java.util.*;
import java.util.Map.Entry;

public class SortBy implements Comparator<Entry<Integer, Integer>> {
    @Override
    public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2){
        if (o1.getValue() > o2.getValue()) return -1;
        return 1;
    }
}

Support.java

package javaptit;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Support {
    public static boolean check(int x) {
        String res = String.valueOf(x);
        res.toCharArray();
        for (int i = 0; i < res.length() - 1; i++) {
            if (res.charAt(i) > res.charAt(i + 1)) {
                return false;
            }
        }
        return true;
    }
}


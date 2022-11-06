Main.java
package javaptit;

import java.util.Collection;
import java.util.Scanner;
import java.util.*;
 
public class Main {
    public static void main(String [] agrs){
        Scanner sc = new Scanner(System.in);
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        long maxLength = 0;
        //int cnt = 32;
        while(sc.hasNext()) {
            String tmp = sc.next();
            if (Support.check(tmp)) {
                maxLength = Math.max(maxLength, tmp.length());
                if (map.containsKey(tmp)) {
                    map.put(tmp, map.get(tmp) + 1);
                }
                else {
                    map.put(tmp, 1);
                }
            }
        }
        Set<String> set = map.keySet();
        
        for (String x : set) {
            if (x.length() == maxLength) {
                System.out.println(x + " " + map.get(x));
            }
        }
    }
    
 
}


Support.java

package javaptit;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Support {
    public static boolean check(String s) {
        StringBuilder sbd = new StringBuilder(s);
        sbd.reverse();
        return sbd.toString().equals(s);
    }
}


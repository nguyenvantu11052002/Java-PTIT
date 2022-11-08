package javaptit;

import java.util.*;
import java.util.Map.Entry;

public class Main {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int test = Integer.parseInt(sc.nextLine());
        while (test-->0) {
            long s = sc.nextLong();
            long t = sc.nextLong();
            ArrayDeque<Long> dq = new ArrayDeque<>();
            HashMap<Long, Long> map = new HashMap<>();
            dq.addLast(s);
            map.put(s, 0L);
            while(true) {
                long first = dq.getFirst();
                dq.removeFirst();
                long second = map.get(first);
                if (first == t) {
                    System.out.println(second);
                    break;
                }
                if (first < t && !map.containsKey(first * 2)) {
                    dq.addLast(first * 2);
                    map.put(first * 2, second + 1);
                }
                if (first > 0 && !map.containsKey(first - 1)) {
                    dq.addLast(first - 1);
                    map.put(first - 1, second + 1);
                }
            }
        }
    }
}
 

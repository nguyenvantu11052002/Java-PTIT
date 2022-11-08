Main.java
package javaptit;

import java.util.*;
import java.util.Map.Entry;

public class Main {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int test = Integer.parseInt(sc.nextLine());
        while (test-->0) {
            String s1 = sc.next();
            String s2 = sc.next();
            int stx = (int) s1.charAt(0) - 97 + 1;
            int sty = Integer.parseInt(s1.substring(1, 2));
            int enx = (int) s2.charAt(0) - 97 + 1;
            int eny = Integer.parseInt(s2.substring(1, 2));
            System.out.println(Support.solve(stx, sty, enx, eny));
        }
    }
}
 
//8
//e2 e4
//a1 b2
//b2 c3
//a1 h8
//a1 h7
//h8 a1
//b1 c3
//f6 f6
Pair.java
package javaptit;

import java.util.*;

 
public class Pair<T1, T2> {
    private T1 first;
    private T2 second;

    public Pair(T1 first, T2 second) {
        this.first = first;
        this.second = second;
    }

    public T1 getFirst() {
        return first;
    }

    public T2 getSecond() {
        return second;
    }

    @Override
    public String toString() {
        return this.first + " " + this.second;
    }
    
}

Support.java

package javaptit;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Support {
    public static int[] dx = {-1, -2, -2, -1, 1, 2, 2, 1};
    public static int[] dy = {-2, -1, 1, 2, 2, 1, -1, -2};
    
    public static long solve(int stx, int sty, int enx, int eny) {
        ArrayDeque<Pair<Integer, Integer>> dq = new ArrayDeque<>();
        HashMap<Pair<Integer, Integer>, Integer> map = new HashMap<>();
        Pair<Integer, Integer> x = new Pair<>(stx, sty);
        dq.addLast(x);
        map.put(x, 0);
        while (!dq.isEmpty()) {
            Pair<Integer, Integer> top = dq.getFirst();
            dq.removeFirst();
            int cnt = map.get(top);
            if (top.getFirst().equals(enx) && top.getSecond().equals(eny)) {
                return cnt;
            }
            for (int i = 0; i < 8; i++) {
                Pair<Integer, Integer> tmp = new Pair<>(top.getFirst() + dx[i], top.getSecond() + dy[i]);
                int dem = cnt + 1;
                if (tmp.getFirst() >= 1 && tmp.getFirst() <= 8 && tmp.getSecond() >= 1 && tmp.getSecond() <= 8 && !map.containsKey(tmp)) {
                    dq.add(tmp);
                    map.put(tmp, dem);
                }
            }
        }
        return 0;
    }
    
}

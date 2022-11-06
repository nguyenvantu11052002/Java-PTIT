Main.java
package javaptit;

import java.util.Collection;
import java.util.Scanner;
import java.util.*;
 
public class Main {
    public static void main(String [] agrs){
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        
        while (t-->0) {
            String s = sc.nextLine();
            s.toCharArray();
            
            Stack<Pair<Character, Integer> > st = new Stack<>();
            ArrayList<Integer> list = new ArrayList<>();
            while (list.size() < s.length()) {
                list.add(0);
            }
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(') {
                    st.push(new Pair(s.charAt(i), i));
                }
                else {
                    if (st.isEmpty()) {
                        list.set(i, 0);
                    }
                    else {
                        list.set(i, 1);
                        Pair<Character, Integer> pa = st.pop();
                        list.set(pa.getSecond(), 1);
                    }
                }
            }
            while (!st.isEmpty()) {
                list.set(st.pop().getSecond(), 0);
            }
            System.out.println(Support.solve(list));
        }
    }
 
}

//3
//((()
//)()())
//()(()))))
Support.java

package javaptit;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Support {
    public static long solve(ArrayList<Integer> list) {
        int res = 0;
        int cnt = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == 1) {
                cnt += 1;
                res = Math.max(res, cnt);
            }
            else cnt = 0;
        }
        return res;
    }
}

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
    
    public T2 getSecond() {
        return this.second;
    }
    
}


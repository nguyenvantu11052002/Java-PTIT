test/Main.java

package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static test.SupportFunctions.check;

public class Main {
    
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("DATA.in"));
        List<Pair> list = (List<Pair>) ois.readObject();
        Map<Pair, Integer> map = new HashMap<>();
        List<Pair> res = new ArrayList<>();
        for (Pair x : list) {
            if (x.getFirst() < x.getSecond() && check(x.getFirst(), x.getSecond())) {
                
                if (map.containsKey(x)) {
                    
                }
                else {
                    map.put(x, 1);
                    res.add(x);
                }
            }
        }
        Collections.sort(res);
        for (Pair x : res) {
            System.out.println(x);
        }
    }
    
}

test/Pair.java

package test;

import java.io.Serializable;

public class Pair implements Serializable, Comparable<Pair> {
    private int first, second;

    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
    
    public int getFirst() {
        return first;
    }
    public int getSecond(){
        return second;
    }
    @Override
    public int compareTo(Pair o) {
        return this.first - o.first;
    }
    @Override
    public String toString() {
        return "(" + first + ", " + second + ")";
    }
    
}

test/SupportFunctions.java

package test;

public class SupportFunctions {
    public static boolean check (int a, int b) {
        while (b != 0) {
            int x = a % b;
            a = b;
            b = x;
        }
        if (a == 1) return true;
        return false;
    }
}


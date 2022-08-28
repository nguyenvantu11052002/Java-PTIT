package javaptit;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class WordSet {
    private Set<String> set = new TreeSet<>();
   
    public WordSet (String ss) throws FileNotFoundException  {
        Scanner sc = new Scanner(new File("VANBAN.in"));
        String s = "";
        while (sc.hasNext()) {
            s = sc.next();
            s = s.toLowerCase();
            this.set.add(s);
        }
    }
    
    @Override
    public String toString () {
        String res = "";
        for (String x : this.set) {
            res += x + "\n";
        }
        return res;
    }
    
    public static void main(String[] args) throws IOException {
        WordSet ws = new WordSet("VANBAN.in");
        System.out.println(ws);
    }
    public static void main9629608(String[] args) throws IOException {
        WordSet ws = new WordSet("VANBAN.in");
        System.out.println(ws);
    }
    
}

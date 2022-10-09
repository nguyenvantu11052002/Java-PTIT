javaptit/JavaPTIT.java

package javaptit;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class JavaPTIT {

    public static void main(String[] args) throws IOException {
        WordSet ws = new WordSet("VANBAN.in");
        System.out.println(ws);
    }
    public static void main8956705(String[] args) throws IOException {
        WordSet ws = new WordSet("VANBAN.in");
        System.out.println(ws);
    }
    
}


javaptit/WordSet.java

package javaptit;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class WordSet {
    Set<String> set = new TreeSet<>();
    public WordSet(String s) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(s));
        while (sc.hasNext()) {
            String tmp = sc.next().toLowerCase();
            set.add(tmp);
        }
    }
    
    @Override
    public String toString() {
        String res = "";
        for (String x : this.set) {
            res += x + "\n";
        }
        return res;
    }
}



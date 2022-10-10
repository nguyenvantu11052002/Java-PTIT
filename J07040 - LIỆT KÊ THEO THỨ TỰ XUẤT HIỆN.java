package javaptit;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.util.*;



public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectInputStream ois1 = new ObjectInputStream(new FileInputStream("NHIPHAN.in"));
        List<String> list = (List<String>) ois1.readObject();
        Scanner sc = new Scanner(new File("VANBAN.in"));
        LinkedHashSet<String> listResult = new LinkedHashSet<>();
        HashSet<String> set = new HashSet<>();
        
        for (String x : list) {
            String[] arr = x.trim().split("\\s+");
            for (String y : arr) {
                set.add(y.toLowerCase());
            }
        }
        
        while (sc.hasNext()) {
            listResult.add(sc.next().toLowerCase());
        }
        
        for (String x : listResult) {
            if (set.contains(x)) {
                System.out.println(x);
            }
        }
        
    }

}

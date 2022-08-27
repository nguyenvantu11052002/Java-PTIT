package javaptit;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class JavaPTIT {

    public static void main(String[] args) throws FileNotFoundException {
        long sum = 0;
        try {
            File file = new File("DATA.in");
            Scanner sc = new Scanner(file);
             while (sc.hasNext()) {
                String s = sc.next();
                try {
                    sum += Integer.parseInt(s);
                } catch (Exception e) {
                    
                }
            }
        } catch (Exception e) {

        }
        System.out.println(sum);
    }

}

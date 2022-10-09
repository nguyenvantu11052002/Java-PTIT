
package javaptit;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class JavaPTIT {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("DATA.in"));
        long res = 0;
        while(sc.hasNext()) {
            try{
                int n = Integer.parseInt(sc.next());
                res += n;
            } catch(NumberFormatException e) {
                
            }
        }
        System.out.println(res);
        sc.close();
    }
    
}

package javaptit;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class JavaPTIT {

    public static void main(String[] args) throws FileNotFoundException  {
        Scanner sc = new Scanner(new File("DATA.in"));
        List<String> list = new ArrayList<>();
        while (sc.hasNext()) {
            String s = sc.next();
            try {
                int n = Integer.valueOf(s);
            } catch (NumberFormatException e) {
                list.add(s);
            }
        }
        Collections.sort(list);
        for (String x : list) {
            System.out.print(x + " ");
        }
    }
}

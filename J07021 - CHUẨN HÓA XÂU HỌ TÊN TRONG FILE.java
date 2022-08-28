package javaptit;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class JavaPTIT {

    public static String solve (String s) {
        String res = "";
        String[] arr = s.split("\\s+");
        for (int i = 0; i < arr.length; i++) {
            res += Character.toUpperCase(arr[i].charAt(0));
            for (int j = 1; j < arr[i].length(); j++) {
                res += Character.toLowerCase(arr[i].charAt(j));
            }
            if (i != arr.length - 1) res += " ";
        }
        return res;
    }
    
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("DATA.in"));
        while(sc.hasNextLine()) {
            String s = sc.nextLine();
            s = s.trim();
            if (s.equals("END")) return;
            try {
                System.out.println(solve(s));
            } catch (Exception e) {
                
            }
        }
    }
}

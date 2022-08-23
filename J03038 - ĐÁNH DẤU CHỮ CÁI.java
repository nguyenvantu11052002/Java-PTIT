package newclass;

import java.math.BigInteger;
import java.util.*;

public class NewClass {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = 1;
        //t = Integer.parseInt(sc.nextLine());
        
        while (t-- > 0) {
            String s = sc.nextLine();
            Set<Character> set = new HashSet<>();
            for (int i = 0; i < s.length(); i++) {
                set.add(s.charAt(i));
            }
            System.out.println(set.size());
        }
    }
}

    

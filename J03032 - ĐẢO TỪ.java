package newclass;

import java.util.*;

public class NewClass {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = 1;
        t = Integer.parseInt(sc.nextLine());
        
        while (t-- > 0) {
            String s = sc.nextLine();
            String[] arr = s.split("\\s+");
            for (String x : arr) {
                for (int i = x.length() - 1; i >= 0; i--) {
                    System.out.print(x.charAt(i));
                }
                System.out.print(" ");
            }
            System.out.println("");
        }
    }
}


//2
//ABC DEF
//123 456

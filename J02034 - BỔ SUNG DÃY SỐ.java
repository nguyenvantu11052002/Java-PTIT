package newclass;

import java.util.*;

public class NewClass {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = 1;
        //t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            int ht = 1;
            boolean ok = true;
            for (int i = 0; i < n; i++) {
                if (a[i] != ht) {
                    ok = false;
                    i--;
                    System.out.println(ht);
                    ht++;
                }
                else ht++;
            }
            if (ok) {
                System.out.println("Excellent!");
            }
        }
    }
}


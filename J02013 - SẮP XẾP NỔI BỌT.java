package newclass;

import java.util.*;

public class NewClass {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = 1;
        //t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            for (int i = 0; i < n - 1; i++) {
                boolean ok = false;
                for (int j = 0; j < n - i - 1; j++) {
                    if (a[j] > a[j + 1]) {
                        ok = true;
                        int tmp = a[j];
                        a[j] = a[j + 1];
                        a[j + 1] = tmp;
                    }
                }
                if (ok == false) {
                    break;
                }
                System.out.print("Buoc " + (i + 1) + ": ");
                for (Integer x : a) {
                    System.out.print(x + " ");
                }
                System.out.println("");
            }
        }
    }
}

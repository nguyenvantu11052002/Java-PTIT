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
            for (int i = 0; i < n; i++) {
                int key = a[i];
                int j = i - 1;
                while (j >= 0 && key < a[j]) {
                    a[j + 1] = a[j];
                    j--;
                }
                a[j + 1] = key;
                System.out.print("Buoc " + i + ": ");
                for (int k = 0; k <= i; k++) {
                    System.out.print(a[k] + " ");
                }
                System.out.println("");
            }
        }
    }
}

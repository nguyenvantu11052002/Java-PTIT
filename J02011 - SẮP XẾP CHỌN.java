
package newclass;

import java.util.*;

public class NewClass {
   
    public static void swap (int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
    
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       int t = 1;
       //t = sc.nextInt();
       while (t--> 0) {
           int n = sc.nextInt();
           int[] a= new int[n];
           for (int i = 0; i < n; i++) {
               a[i] = sc.nextInt();
           }
           for (int i = 0; i < n - 1; i++) {
                System.out.print("Buoc " + (i + 1) + ": ");
                int temp = i;
                for (int j = i + 1; j < n; j++) {
                    if (a[j] < a[temp]) {
                        temp = j;
                    }
                }
                swap(a, i, temp);
                for (Integer x : a) {
                    System.out.print(x + " ");
                }
                System.out.println("");
           }
       }
    }
    
}

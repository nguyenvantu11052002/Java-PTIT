package newclass;

import java.util.*;

public class NewClass {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = 1;
        //t = sc.nextInt();
        while (t-- > 0) {
            ArrayList<Integer> list1 = new ArrayList<>();
            ArrayList<Integer> list2 = new ArrayList<>();
            for (int i = 0; i < 4; i++) {
                int x = sc.nextInt();
                if (i == 0 || i == 2) {
                    list1.add(x);
                }
                else list2.add(x);
            }
            for (int i = 0; i < 4; i++) {
                int x = sc.nextInt();
                if (i == 0 || i == 2) {
                    list1.add(x);
                }
                else list2.add(x);
            }
            int xmin = 1001, xmax = -1001, ymin = 1001, ymax = -1001;
            for (Integer x : list1) {
                xmin = Math.min(xmin, x);
                xmax = Math.max(xmax, x);
            }
            for (Integer x : list2) {
                ymin = Math.min(x, ymin);
                ymax = Math.max(x, ymax);
            }
           // System.out.println(xmax + " " + xmin + " " + ymax + " " + ymin);
            int res = Math.max(xmax - xmin, ymax - ymin);
            System.out.println(res * res);
        }
    }
}



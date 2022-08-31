package javaptit;

import java.util.*;

public class JavaPTIT {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = 1;
        //t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][2];
            for (int i = 0; i < n; i++) {
                a[i][0] = sc.nextInt();
                a[i][1] = sc.nextInt();
            }
            Arrays.sort(a, new Comparator<int[]> () {
                @Override
                public int compare(int[] a2, int[] a3) {
                    if (a2[0] < a3[0]) {
                        return -1;
                    }
                    return 1;
                }
            });
            int res = 0;
            for (int i = 0; i < n; i++) {
                res = Math.max(res, a[i][0]) + a[i][1];
            }
            System.out.println(res);
        }
    }
}

//3
//2 1
//5 7
//8 3

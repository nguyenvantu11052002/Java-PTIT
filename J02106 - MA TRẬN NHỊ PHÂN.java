package newclass;

import java.util.*;

public class NewClass {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = 1;
        //t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][3];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < 3; j++) {
                    a[i][j] = sc.nextInt();
                }
            }
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                int so1 = 0, so0 = 0;
                for (int j = 0; j < 3; j++) {
                    if (a[i][j] == 0) so0++;
                    else so1++;
                }
                if (so1 > so0) cnt++;
            }
            System.out.println(cnt);
        }
    }
}

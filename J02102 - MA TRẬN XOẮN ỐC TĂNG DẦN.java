
import java.util.*;

public class JavaPTIT1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = 1;
       // t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            int cnt1 = 0;
            int[] b = new int[n * n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    a[i][j] = sc.nextInt();
                    b[cnt1] = a[i][j];
                    cnt1++;
                }
            }
            Arrays.sort(b);
            int[][] res = new int[n][n];
            int h1 = 0, c1 = 0, h2 = n - 1, c2 = n - 1;
            int cnt = 0;
            while (cnt < n * n) {
                for (int i = c1; i <= c2; i++) {
                    res[h1][i] = b[cnt++];
                }
                h1++;
                for (int i = h1; i <= h2; i++) {
                    res[i][c2] = b[cnt++];
                }
                c2--;
                for (int i = c2; i >= c1; i--) {
                    res[h2][i] = b[cnt++];
                }
                h2--;
                for (int i = h2; i >= h1; i--) {
                    res[i][c1] = b[cnt++];
                }
                c1++;
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(res[i][j] + " ");
                }
                System.out.println("");
            }
        }
    }
}

//3
//3 6 1
//8 7 9
//4 12 5

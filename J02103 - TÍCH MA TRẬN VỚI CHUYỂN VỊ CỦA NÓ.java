package newclass;

import java.util.*;

public class NewClass1 {
    private int[][] mta, mtb, res;
    private int n, m;

    public NewClass1 (int n, int m) {
        this.mta = new int[n][m];
        this.mtb = new int[m][n];
        this.res = new int[n][n];
        this.n = n;
        this.m = m;
    }
    
    public void add (int n, int m, int val) {
        mta[n][m] = val;
        mtb[m][n] = val;
    }
    
    public void solve () {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                res[i][j] = 0;
                for (int k = 0; k < m; k++) {
                    res[i][j] += mta[i][k] * mtb[k][j];
                }
            }
        }
    }
    
    public void in () {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.println("");
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = 1;
        t = Integer.parseInt(sc.nextLine());
        int id = 1;
        while (t-- > 0) {
            int n = sc.nextInt(), m = sc.nextInt();
            NewClass1 matran = new NewClass1(n, m);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    int x = sc.nextInt();
                    matran.add(i, j, x);
                }
            }
            System.out.println("Test " + id + ":");
            id++;
            matran.solve();
            matran.in();
        }
    }

    
}

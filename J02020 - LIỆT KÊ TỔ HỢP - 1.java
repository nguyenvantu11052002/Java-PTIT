package newclass;

import java.util.*;

public class NewClass {
    public static int n, k, cnt;
    public static int[] a = new int[15];
    
    public static void solve () {
        for (int i = 1; i <= k; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println("");
    }
    
    public static void Try (int i) {
        for (int j = a[i - 1] + 1; j <= n - k + i; j++) {
            a[i] = j;
            if (i == k) {
                solve();
                cnt++;
            }
            else Try(i + 1);
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = 1;
        //t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            n = sc.nextInt(); k = sc.nextInt();
            cnt = 0;
            Try(1);
            System.out.println("Tong cong co " + cnt + " to hop");
        }
    }
}

package javaptit;

import java.util.*;


public class JavaPTIT {
    public static int n, k;
    public static int[] a = new int[20];
    public static int[] x = new int[20];
    public static List<List<Integer> > list = new ArrayList<>();
    
    public static void solve () {
        List<Integer> tmp = new ArrayList<>();
        for (int i = 1; i <= k; i++) {
            tmp.add(a[x[i]]);
        }
        list.add(tmp);
    }
    
    public static void Try (int i) {
        for (int j = x[i - 1] + 1; j <= n - k + i; j++) {
            x[i] = j;
            if (i == k) {
                solve();
            }
            else Try (i + 1);
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = 1;
        t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            Arrays.fill(x, 0);
            list.clear();
            n = sc.nextInt(); k = sc.nextInt();
            for (int i = 1; i <= n; i++) {
                a[i] = sc.nextInt();
            }
            Arrays.sort(a, 1, n + 1);
            Try (1);
            //System.out.println("set size" + list.size());
            for (List<Integer> x : list) {
                for (Integer y : x) {
                    System.out.print(y + " ");
                }
                System.out.println("");
            }
            
        }
    }
}


//1
//4 3
//3 2 5 4

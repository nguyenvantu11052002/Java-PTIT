Main.java
package javaptit;
 
import java.util.*;
 
public class Main {
 
    public static int n;
    public static ArrayList<Integer> list = new ArrayList<>();
    public static ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
    public static int[] a = new int[20];
 
    public static void Try(int i, int res) {
        for (int j = i + 1; j <= n; j++) {
            res += a[j];
            list.add(a[j]);
            if (res % 2 != 0) {
                ArrayList<Integer> tmp = new ArrayList<>();
                for (int k = 0; k < list.size(); k++) {
                    tmp.add(list.get(k));
                }
                //ans.add(list);
                ans.add(tmp);
            }
            Try(j, res);
            res -= a[j];
            list.remove(list.size() - 1);
        }
    }
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = 1;
        t = sc.nextInt();
        while (t-- > 0) {
            list.clear();
            ans.clear();
            n = sc.nextInt();
            for (int i = 1; i <= n; i++) {
                a[i] = sc.nextInt();
            }
            Arrays.sort(a, 1, n + 1);
            int l = 1, r = n;
            while (l <= r) {
                int tmp = a[l];
                a[l] = a[r];
                a[r] = tmp;
                l += 1;
                r -= 1;
            }
            Try(0, 0);
            Collections.sort(ans, new SortBy());
            for (ArrayList<Integer> x : ans) {
                for (Integer y : x) {
                    System.out.print(y + " ");
                }
                System.out.println("");
            }
        }
    }
}
 
//1
//4
//2 3 4 5
SortBy.java
package javaptit;

import java.util.*;

public class SortBy implements Comparator<ArrayList<Integer> > {
    @Override
    public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
        for (int i = 0; i < o1.size() && i < o2.size(); i++) {
            if (o1.get(i) != o2.get(i)) {
                if (o1.get(i) < o2.get(i)) return -1;
                return 1;
            }
        }
        if (o1.size() < o2.size()) return -1;
        return 1;
    }
}


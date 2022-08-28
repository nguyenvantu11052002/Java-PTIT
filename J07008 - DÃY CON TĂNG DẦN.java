package javaptit;

import java.io.File;
import java.io.FileNotFoundException;

import java.util.*;

public class JavaPTIT {
    public static int n;
    public static int[] a = new int[25];
    public static int[] x = new int[25];
    public static List<String> list = new ArrayList<>();
    
    public static void solve () {
        
        String res = "";
        for (int i = 0; i < n; i++) {
            if (x[i] == 1) {
                res += Integer.toString(a[i]) + " ";
            }
        }
        list.add(res);
    }
    
    public static boolean check () {
        List<Integer> list1 = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (x[i] == 1) {
                list1.add(a[i]);
            }
        }
        if (list1.size() < 2) return false;
        for (int i = 0; i < list1.size() - 1; i++) {
            if (list1.get(i) > list1.get(i + 1)) return false;
        }
        return true;
    }
    
    public static void Try (int i) {
        for (int j = 0; j <= 1; j++) {
            x[i] = j;
            if (i == n - 1) {
                if (check()) {
                    solve();
                }
            }
            else Try (i + 1);
        }
    }
    
    public static void main(String[] args) throws FileNotFoundException {

        Scanner sc = new Scanner(new File("DAYSO.in"));
        n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(sc.next());
        }
        Try(0);
        Collections.sort(list);
        for (String x : list) {
            System.out.println(x);
        }
    }
}


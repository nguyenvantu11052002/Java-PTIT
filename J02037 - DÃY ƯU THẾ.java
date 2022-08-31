package javaptit;

import java.util.*;

public class JavaPTIT {
    
    public static boolean chan (List<Integer> x) {
        if (x.size() % 2 != 0) return false;
        int cnt = 0;
        for (int i = 0; i < x.size(); i++) {
            if (x.get(i) % 2 == 0) ++cnt;
        }
        return cnt > x.size() - cnt;
    }
    
    public static boolean le (List<Integer> x) {
        if (x.size() % 2 == 0) return false;
        int cnt = 0;
        for (int i = 0; i < x.size(); i++) {
            if (x.get(i) % 2 == 1) ++cnt;
        }
        return cnt > x.size() - cnt;
    }
    
    public static boolean check (List<Integer> x) {
        if (chan(x) || le(x)) return true;
        else return false;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = 1;
        t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String[] arr = sc.nextLine().split("\\s+");
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < arr.length; i++) {
                list.add(Integer.parseInt(arr[i]));
            }
            if (check (list)) {
                System.out.println("YES");
            }
            else System.out.println("NO");
        }
    }
}

//2
//11 22 33 44 55 66 77
//23 34 45 56 67 78 89 90 121 131 141 151 161 171

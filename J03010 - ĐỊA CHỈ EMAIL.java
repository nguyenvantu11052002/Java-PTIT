package newclass;

import java.util.*;

public class NewClass {
    
    public static String solve (String s1) {
        String[] s = s1.split("\\s+");
        StringBuilder sb = new StringBuilder("");
       int n = s.length;
       for (int i = 0; i < s[n - 1].length(); i++) {
           sb.append(Character.toLowerCase(s[n - 1].charAt(i)));
       }
       for (int i = 0; i < n - 1; i++) {
           sb.append(Character.toLowerCase(s[i].charAt(0)));
       }
       return sb.toString();
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = 1;
        t = Integer.parseInt(sc.nextLine());
        ArrayList<String> arr = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        
        while (t-- > 0) {
            String s = sc.nextLine();
            s = s.trim();
            if (map.containsKey(solve(s))) {
                int ts = map.get(solve(s));
                ++ts;
                map.put(solve(s), ts);
                String res = solve(s) + Integer.toString(ts);
                arr.add(res);
            }
            else {
                map.put(solve(s), 1);
                arr.add(solve(s));
            }
        }
        for (String x : arr) {
            System.out.println(x + "@ptit.edu.vn");
        }
    }
}


//4
//    nGUYEn    quaNG   vInH  
//   tRan   thi THU    huOnG
//   nGO   quoC  VINH
// lE            tuAn    aNH

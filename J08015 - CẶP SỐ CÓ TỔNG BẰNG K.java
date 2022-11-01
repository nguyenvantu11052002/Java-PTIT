package javaptit;

import java.util.*;

public class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t --> 0) {
            long n = sc.nextLong();
            long k = sc.nextLong();
            long cnt = 0;
            Map<Long, Long> map = new HashMap<>();
            List<Long> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                long x = sc.nextLong();
                list.add(x);
                if (map.containsKey(x)) {
                    map.put(x, map.get(x) + 1);
                }
                else{
                    map.put(x, 1L);
                }
            }
            for (Long x : list) {
                if (map.containsKey(k - x)) {
                    cnt += map.get(k - x);
                    if (x == k - x) cnt -= 1;
                }
            }
            System.out.println(cnt/2);
        }
        
    }


}

//4
//4 6
//1 5 7 -1
//5 6
//1 5 7 -1 5
//4 2
//1 1 1 1
//13 11
//10 12 10 15 -1 7 6 5 4 2 1 1 1

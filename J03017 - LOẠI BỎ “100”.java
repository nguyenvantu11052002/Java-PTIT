package javaptit;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-->0) {
            String s = sc.nextLine();
            ArrayList<Integer> list = new ArrayList<>();
            String s1 = "";
            list.add(-1);
            long res = 0;
            for (int i = 0; i < s.length(); i++) {
                s1 += s.charAt(i);
                list.add(i);
                if (s1.endsWith("100")) {
                    s1 = s1.substring(0, s1.length() - 3);
                    for (int j = 0; j < 3; j++) {
                        list.remove(list.size() - 1);
                    }
                    res = Math.max(res, i - list.get(list.size() - 1));
                }
                
            }
            System.out.println(res);
        }    
    }
}

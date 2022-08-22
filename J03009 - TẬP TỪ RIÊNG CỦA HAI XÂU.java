package newclass;

import java.util.*;

public class NewClass {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = 1;
        t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String s1 = sc.nextLine();
            String s2 = sc.nextLine();
            String[] t1 = s1.split(" ");
            String[] t2 = s2.split(" ");
            TreeSet<String> set1 = new TreeSet<>();
            TreeSet<String> set2 = new TreeSet<>();
            for (int i = 0; i < t1.length; i++) {
                set1.add(t1[i]);
            }   
            for (int i = 0; i < t2.length; i++) {
                set2.add(t2[i]);
            }
            for (String x : set1) {
                if (set2.contains(x) == false) {
                    System.out.print(x + " ");
                }
            }
            System.out.println("");
        }
    }
}

//2
//abc ab ab ab abcd
//ab abc
//aaa xyz ab zzz abc dd dd abc
//xyz dd ttt sas cdc

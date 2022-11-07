Main.java
package javaptit;

import java.util.Collection;
import java.util.Scanner;
import java.util.*;
import java.util.Map.Entry;
 
public class Main {
    public static void main(String [] agrs){
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-->0) {
            int n = sc.nextInt();
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                int x = sc.nextInt();
                list.add(x);
            }
            ArrayList<Integer> listTrai = Support.solveTrai(list);
            ArrayList<Integer> listPhai = Support.solvePhai(list);
            long res = 0;
          
            for (int i = 0; i < list.size(); i++) {
                //System.out.println(listPhai.get(i) + " " + listTrai.get(i));
                long dienTichHCN = (long) list.get(i) * (listPhai.get(i) - listTrai.get(i) + 1);
                res = Math.max(res, dienTichHCN);
            }
            System.out.println(res);
        }
    }
}


//2
//7
//6 2 5 4 5 1 6
//3
//2 2 2
Support.java

package javaptit;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Support {
    public static ArrayList<Integer> solveTrai(ArrayList<Integer> list) {
        ArrayList<Integer> listTrai = new ArrayList<>(list);
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < list.size(); i++) {
            while (!st.isEmpty() && list.get(st.peek()) >= list.get(i)) {
                st.pop();
            }
            if (st.isEmpty()) {
                listTrai.set(i, 0);
            }
            else {
                listTrai.set(i, st.peek() + 1);
            }
            st.push(i);
        }
        return listTrai;
    }
    
    public static ArrayList<Integer> solvePhai(ArrayList<Integer> list) {
        ArrayList<Integer> listPhai = new ArrayList<>(list);
        Stack<Integer> st = new Stack<>();
        for (int i = list.size() - 1; i >= 0; i--) {
            while (!st.isEmpty() && list.get(st.peek()) >= list.get(i)) {
                st.pop();
            }
            if (st.isEmpty()) {
                listPhai.set(i, list.size() - 1);
            }
            else {
                listPhai.set(i, st.peek() - 1);
            }
            st.push(i);
        }
        return listPhai;
    }
}


Main.java
package javaptit;

import java.util.Collection;
import java.util.Scanner;
import java.util.*;
import java.util.Map.Entry;
 
public class Main {
    public static void main(String [] agrs){
        Scanner sc = new Scanner(System.in);
        int t = 1;
        //int t = Integer.parseInt(sc.nextLine());
        while (t-->0) {
            int m = sc.nextInt();
            int n = sc.nextInt();
            
            int[] listVang = new int[n];
            int[] listXanh = new int[n];
            for (int i = 0; i < n; i++) {
                listVang[i] = sc.nextInt();
                listXanh[i] = m - listVang[i];
            }
            
            int[] listTraiVang = Support.solveTrai(listVang, n);
            int[] listPhaiVang = Support.solvePhai(listVang, n);
            int[] listTraiXanh = Support.solveTrai(listXanh, n);
            int[] listPhaiXanh = Support.solvePhai(listXanh, n);
            
            long res = 0;
          
            for (int i = 0; i < n; i++) {
                long dienTichHCN = (long) listVang[i] * (listPhaiVang[i] - listTraiVang[i] + 1);
                res = Math.max(res, dienTichHCN);
                dienTichHCN = (long) listXanh[i] * (listPhaiXanh[i] - listTraiXanh[i] + 1);
                res = Math.max(res, dienTichHCN);
            }
            
            System.out.println(res);
        }
    }
}


//5 9
//1 3 4 4 5 4 4 3 1
Support.java

package javaptit;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Support {
    public static int[] solveTrai(int[] list, int n) {
        int[] listTrai = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && list[st.peek()] >= list[i]) {
                st.pop();
            }
            if (st.isEmpty()) {
                listTrai[i] = 0;
            }
            else {
                listTrai[i] = st.peek() + 1;
            }
            st.push(i);
        }
        return listTrai;
    }
    
    public static int[] solvePhai(int[] list, int n) {
        int[] listPhai = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && list[st.peek()] >= list[i]) {
                st.pop();
            }
            if (st.isEmpty()) {
                listPhai[i] = n - 1;
            }
            else {
                listPhai[i] = st.peek() - 1;
            }
            st.push(i);
        }
        return listPhai;
    }
}

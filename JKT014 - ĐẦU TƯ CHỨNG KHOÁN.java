package javaptit;

import java.util.Collection;
import java.util.Scanner;
import java.util.*;
 
public class Main {
    public static void main(String [] agrs){
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        
        while (t-->0) {
            int n = sc.nextInt();
            ArrayList<Integer> list = new ArrayList<>();
            Stack<Integer> st = new Stack<>();
            
            for (int i = 0; i < n; i++) {
                int x = sc.nextInt();
                list.add(x);
            }
            
            ArrayList<Integer> listRes = new ArrayList<>(list);  
            
            for (int i = 0; i < n; i++) {
                while (!st.isEmpty() && list.get(st.peek()) <= list.get(i)) {
                    st.pop();
                }
                if (st.isEmpty()) {
                    listRes.set(i, 0);
                }
                else {
                    listRes.set(i, st.peek() + 1);
                }
                st.push(i);
            }
            for (int i = 0; i < listRes.size(); i++) {
                System.out.print(i - listRes.get(i) + 1 + " ");
            }
            System.out.println("");
        }
    }
 
}


//1
//7
// 0  1  2    3    4    5    6
//100 80 60   70   60   75   85
//1   1   1    2    1    4    6 

//1
//7
//100 80 60 75 60 75 85

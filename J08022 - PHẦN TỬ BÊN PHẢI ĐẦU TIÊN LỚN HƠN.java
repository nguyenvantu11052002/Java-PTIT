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
            
            for (int i = n - 1; i >= 0; i--) {
                while (!st.isEmpty() && st.peek() <= list.get(i)) {
                    st.pop();
                }
                if (st.isEmpty()) {
                    listRes.set(i, -1);
                }
                else {
                    listRes.set(i, st.peek());
                }
                st.push(list.get(i));
            }
            for (Integer x : listRes) {
                System.out.print(x + " ");
            }
            System.out.println("");
        }
    }
 
}

//3
//4
//4 5 2 25
//3
//2 2 2
//4
//4 4 5 5

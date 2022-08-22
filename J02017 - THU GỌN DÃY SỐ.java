package newclass;

import java.util.*;

public class NewClass {  
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = 1;
        //t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            Stack<Integer> st = new Stack<>();
            for (int i = 0; i <= n; i++) {           
                if (st.size() >= 2) {
                    int top1 = st.pop();
                    int top2 = st.peek();
                    //System.out.println("top1 " + top1 + " top2 " + top2);
                    int d = top1 + top2;
                    if (d % 2 == 0) {
                        st.pop();
                    }
                    else {
                        st.push(top1);
                    }
                }
                if (i != n ) st.push(a[i]);
            }
            System.out.println(st.size());
        }
    }
}

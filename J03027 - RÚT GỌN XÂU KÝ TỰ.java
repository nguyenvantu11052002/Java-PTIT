package javaptit;

import java.math.BigInteger;
import java.util.*;

public class JavaPTIT {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int t = 1;
        //t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String s = sc.nextLine();
            Stack<Character> st = new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                st.add(s.charAt(i));
                if (st.size() >= 2) {
                    char s1 = st.pop();
                    char s2 = st.peek();
                    if (s1 == s2) {
                        st.pop();
                    }
                    else st.push(s1);
                }
            }
            if (st.isEmpty()) {
                System.out.println("Empty String");
            }
            else {
                String res= "";
                while (st.isEmpty() == false) {
                    res = st.pop() + res;
                }
                
                System.out.println(res);
            }
        }
    }
}



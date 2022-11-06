package javaptit;

import java.util.Collection;
import java.util.Scanner;
import java.util.*;
 
public class Main {
    public static void main(String [] agrs){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        Stack<Character> st = new Stack<>();
        ArrayDeque<Character> dq = new ArrayDeque<>();
        
        s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '-') {
                if (!st.isEmpty()) {
                    st.pop();
                }
            }
            else if (s.charAt(i) == '<') {
                if (!st.isEmpty()) {
                    Character tmp = st.pop();
                    dq.addLast(tmp);
                } 
            }
            else if (s.charAt(i) == '>') {
                if (!dq.isEmpty()) {
                    Character tmp = dq.getLast();
                    dq.removeLast();
                    st.push(tmp);
                }
            }
            else {
                st.push(s.charAt(i));
            }
        }
        StringBuilder sbd = new StringBuilder();
        while (!dq.isEmpty()) {
            sbd.append(dq.getFirst());
            dq.removeFirst();
        }
        while (!st.isEmpty()) {
            sbd.append(st.pop());
        }
        sbd.reverse();
        System.out.println(sbd);
    }
    
 
}

Main.java
package javaptit;

import java.util.*;
import static javaptit.SupportFunctions.check;

public class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t --> 0) {
            String s = sc.nextLine();
            if (check(s)) {
                System.out.println("YES");
            }
            else {
                System.out.println("NO");
            }
          
        }
        
    }


}

//2
//[()]{}{[()()]()}
//[(])
SupportFunctions.java
package javaptit;
import java.util.*;

public class SupportFunctions {
    
    public static boolean check1 (Character x) {
        if (x.equals('(') || x.equals('[') || x.equals('{')) {
            return true;
        }
        return false;
    }
   
    public static boolean check(String s) {
        Stack<Character> q = new Stack<>();
        s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if (check1(s.charAt(i))) {
                q.push(s.charAt(i));
            }
            else {
                if (s.charAt(i) == ')') {
                    if (q.size() == 0 || q.peek()!= '(') return false;
                    q.pop();
                }
                else if (s.charAt(i) == ']') {
                    if (q.size() == 0 || q.peek() != '[') return false;
                    q.pop();
                }
                else {
                    if (q.size() == 0 || q.peek() != '{') return false;
                    q.pop();
                }
            }
        }
        if (q.size() > 0) return false;
        return true;
    }
}

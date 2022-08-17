
import java.util.*;

public class NewClass {

    public static long gcd (int a, int b) {
        while (b != 0) {
            int x = a % b;
            a = b;
            b = x;
        }
        return a;
    }
    
    public static long lcm (int a, int b) {
        return 1l * a * b / gcd(a, b);
    }
    
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = 1;
        t = sc.nextInt();
        while (t-->0) {
            int a = sc.nextInt(), b = sc.nextInt();
            System.out.println(lcm(a, b) + " " + gcd(a, b));      
        }
    }
}


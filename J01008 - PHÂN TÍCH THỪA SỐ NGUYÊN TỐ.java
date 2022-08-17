
import java.util.*;

public class NewClass {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = 1;
        t = sc.nextInt();
        for (int j = 1; j <= t; j++) {
            System.out.print("Test " + j + ": ");
            int n = sc.nextInt();
            for (int i = 2; i <= Math.sqrt(n); i++) {
                int cnt = 0;
                while (n % i == 0) {
                    n /= i;
                    cnt++;
                }
                if (cnt > 0) System.out.print(i + "(" + cnt + ") ");
                cnt = 0;
            }
            if (n > 1) System.out.print(n + "(" + 1 + ")");
            System.out.println("");
        }
    }
}


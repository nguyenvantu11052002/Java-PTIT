
import java.util.*;

public class NewClass {
    
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = 1;
        //t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            long res = 0;
            long tich = 1;
            for (int i = 1; i <= n; i++) {
                tich *= i;
                res += tich;
            }
            System.out.println(res);
        }
    }
}


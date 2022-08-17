
import java.util.*;

public class NewClass {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            long res = 1l * n * (n + 1) / 2;
            System.out.println(res);
        }
    }
}



import java.util.*;

public class NewClass {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = 1;
        //t = sc.nextInt();
        while (t-- > 0) {
            double a = sc.nextDouble(), b = sc.nextDouble();
            if (a == 0 && b == 0) {
                System.out.println("VSN");
            }
            else if (a == 0 && b != 0) {
                System.out.println("VN");
            }
            else {
                double res = 1f * b/a * (-1);
                System.out.printf("%.2f", res);
            }
        }
    }
}


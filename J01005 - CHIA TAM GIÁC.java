import java.util.*;

public class NewClass {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = 1;
        t = sc.nextInt();
        while (t-->0) {
            int n = sc.nextInt(), h = sc.nextInt();
            for (int i = 1; i < n; i++) {
                double res = 1.0 * h * Math.sqrt(1.0 * i/n);
                System.out.printf("%.6f ", res);
            }
            System.out.println("");
        }
    }
}

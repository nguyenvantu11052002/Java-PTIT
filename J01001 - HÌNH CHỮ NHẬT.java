
import java.util.*;

public class NewClass {
    public static void main(String[] args) {
   
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        boolean ok = true;
        if (n <= 0 || m <= 0) ok = false;
        int chuVi = 2 * (n + m);
        int dienTich = n * m;
        if (ok) {
            System.out.println(chuVi + " " + dienTich);
        }
        else System.out.println(0);
    }
}


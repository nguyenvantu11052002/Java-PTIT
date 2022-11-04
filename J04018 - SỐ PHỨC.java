Main.java
package javaptit;

import java.text.ParseException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        //ArrayList<SoPhuc> list = new ArrayList<>();
        SoPhuc A = new SoPhuc(0, 0);
        SoPhuc B = new SoPhuc(0, 0);
        SoPhuc C = new SoPhuc(0, 0);
        SoPhuc D = new SoPhuc(0, 0);
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            int s1 = sc.nextInt();
            int s2 = sc.nextInt();
            A = new SoPhuc(s1, s2);
            int s3 = sc.nextInt();
            int s4 = sc.nextInt();
            B = new SoPhuc(s3, s4);
            C = C.nhanHaiSoPhuc(A, C.tongHaiSoPhuc(A, B));
            System.out.print(C + ", ");
            D = D.nhanHaiSoPhuc(D.tongHaiSoPhuc(A, B), D.tongHaiSoPhuc(A, B));
            System.out.println(D);
        }
    } 
}

//3
//1 2 3 4
//2 3 4 5
//1 -2 5 -6




SoPhuc.java
package javaptit;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class SoPhuc {
    private int a, b;

    public SoPhuc(int a, int b) {
        this.a = a;
        this.b = b;
    }
    
    public SoPhuc tongHaiSoPhuc(SoPhuc sp1, SoPhuc sp2) {
        int phanThuc = sp1.a + sp2.a;
        int phanAo = sp1.b + sp2.b;
        SoPhuc res = new SoPhuc(phanThuc, phanAo);
        return res;
    }
    
    public SoPhuc nhanHaiSoPhuc(SoPhuc sp1, SoPhuc sp2) {
        int phanThuc = sp1.a * sp2.a + sp1.b * sp2.b * (-1);
        int phanAo = sp1.a * sp2.b + sp1.b * sp2.a;
        SoPhuc res = new SoPhuc(phanThuc, phanAo);
        return res;
    }

    @Override
    public String toString() {
        return this.a + " + " + this.b + "i"; 
    }
}

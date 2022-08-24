
package javaptit;

import java.util.*;

public class PhanSo {
    private long tu, mau;

    public PhanSo(long tu, long mau) {
        this.tu = tu;
        this.mau = mau;
    }
    
    public void rutGon () {
        long a = this.tu, b = this.mau;
        while (b != 0) {
            long x = a % b;
            a = b;
            b = x;
        }
        this.tu /= a;
        this.mau /= a;
    }
    
    public static PhanSo tongBinhPhuong (PhanSo p1, PhanSo p2) {
        PhanSo res = new PhanSo(0, 0);
        res.tu = p1.tu * p2.mau + p2.tu * p1.mau;
        res.mau = p1.mau * p2.mau;
        res.tu *= res.tu;
        res.mau *= res.mau;
        res.rutGon();
        return res;
    }
    
    public static PhanSo tich3PhanSo (PhanSo p1, PhanSo p2, PhanSo p3) {
        PhanSo res = new PhanSo(0, 0);
        res.tu = p1.tu * p2.tu * p3.tu;
        res.mau = p1.mau * p2.mau * p3.mau;
        res.rutGon();
        return res;
    }
    
    
    @Override
    public String toString () {
        return this.tu + "/" + this.mau;
    }
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        int t = 1;
        t = Integer.parseInt(sc.nextLine());
        while (t-->0) {
            long a = sc.nextLong(), b = sc.nextLong(), c = sc.nextLong(), d = sc.nextLong();
            PhanSo p1 = new PhanSo(a, b);
            PhanSo p2 = new PhanSo(c, d);
            PhanSo res1 = tongBinhPhuong(p1, p2);
            PhanSo res2 = tich3PhanSo(p1, p2, res1);
            System.out.println(res1 + " " + res2);
        }
    }
}

//2
//1 2 3 4
//2 3 4 5

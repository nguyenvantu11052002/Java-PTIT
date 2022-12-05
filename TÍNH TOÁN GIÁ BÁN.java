TinhToanGiaBan/DonHang.java
package OOPS.TinhToanGiaBan;

public class DonHang {
    private String maDonHang;
    private long donGia, soLuong;

    public DonHang(String maDonHang, long donGia, long soLuong) {
        this.maDonHang = maDonHang;
        this.donGia = donGia;
        this.soLuong = soLuong;
    }

    public double thue() {
        if(this.maDonHang.startsWith("T")) return 0.29;
        if(this.maDonHang.startsWith("C")) return 0.1;
        if(this.maDonHang.startsWith("D")) return 0.08;
        return 0.02;
    }

    public double thueCoChungTu() {
        if(this.maDonHang.endsWith("C")) return thue() * 0.95;
        return thue();
    }

    public double phiVanChuyen() {
        if(this.maDonHang.startsWith("T")) return 0.04;
        if(this.maDonHang.startsWith("C")) return 0.03;
        if(this.maDonHang.startsWith("D")) return 0.025;
        return 0.005;
    }

    public long giaTien() {
        return this.soLuong * this.donGia;
    }
    
    public double tongTien() {
        return giaTien() + giaTien() * thueCoChungTu() + giaTien() * phiVanChuyen();
    }

    public double thanhTien() {
        double res = tongTien() + tongTien() * 0.2;
        return res ;
    }

    public double giaBan() {
        return (double) Math.round((thanhTien() / this.soLuong) * 100) / 100;
    }
    public String toString() {
        return this.maDonHang + " " + String.format("%.2f", giaBan()) ;
    }
}

TinhToanGiaBan/Main.java
package OOPS.TinhToanGiaBan;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList < DonHang> list = new ArrayList<>();

        int n =Integer.parseInt(sc.nextLine());
        while(n --> 0) {
            String s1 = sc.next();
            long s2 = sc.nextLong();
            long s3 = sc.nextLong();
            list.add( new DonHang(s1, s2, s3));
        }
        for(DonHang x : list) {
            System.out.println(x);
        }
        sc.close();
    }
}

// 2
// TTVC 400 300
// CCAK 200 200

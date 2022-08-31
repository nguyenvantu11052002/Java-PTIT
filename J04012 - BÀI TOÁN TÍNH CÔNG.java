package javaptit;

import java.util.*;

public class NhanVien {

    private String maNhanVien, hoTen, chucVu;
    private int luongCoBan, soNgayCong;

    public NhanVien(String hoTen, String chucVu, int luongCoBan, int soNgayCong) {
        this.maNhanVien = "NV01";
        this.hoTen = hoTen;
        this.chucVu = chucVu;
        this.luongCoBan = luongCoBan;
        this.soNgayCong = soNgayCong;
    }
    
    public int luongThang () {
        return this.luongCoBan * this.soNgayCong;
    }
    
    public int thuong () {
        if (this.soNgayCong >= 25) return this.luongThang() / 5;
        if (this.soNgayCong >= 22 && this.soNgayCong < 25) return this.luongThang() / 10;
        return 0;
    }
    
    public int phuCap () {
        String x = this.chucVu;
        if (x.equals("GD")) return 250000;
        if (x.endsWith("PGD")) return 200000;
        if (x.equals("TP")) return 180000;
        return 150000;
    }
    
    
    public int thuNhap () {
        return this.luongThang() + this.thuong() + this.phuCap();
    }
    
    @Override
    public String toString () {
        return this.maNhanVien + " " + this.hoTen + " " + this.luongThang() + " " + this.thuong() + " " 
                + this.phuCap() + " " + this.thuNhap();
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = 1;
        //t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String hoTen = sc.nextLine();
            int luongCoBan = Integer.parseInt(sc.nextLine());
            int soNgayCong = Integer.parseInt(sc.nextLine());
            String chucVu = sc.nextLine();
            NhanVien x = new NhanVien(hoTen, chucVu, luongCoBan, soNgayCong);
            System.out.println(x);
        }
    }
}

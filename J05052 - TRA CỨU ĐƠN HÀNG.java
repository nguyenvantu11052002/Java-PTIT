package javaptit;

import java.util.*;

public class DonHang {
    private String tenHang, maDonHang;
    private int donGia, soLuong;

    public DonHang(String tenHang, String maDonHang, int donGia, int soLuong) {
        this.tenHang = tenHang;
        this.maDonHang = maDonHang;
        this.donGia = donGia;
        this.soLuong = soLuong;
    }
    
    public String soThuTuDon () {
        return this.maDonHang.substring(1, 4);
    }
    
    public int giamGia () {
        char c = this.maDonHang.charAt(this.maDonHang.length() - 1);
        if (c == '1') return this.donGia * this.soLuong / 2;
        return (int) this.donGia * this.soLuong * 30 / 100;
    }
    
    public int thanhTien () {
        return this.donGia * this.soLuong - this.giamGia();
    }
    
    @Override
    public String toString () {
        return this.tenHang + " " + this.maDonHang + " " + this.soThuTuDon() + " " + this.giamGia() + " " + this.thanhTien();
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while(t-- >0){
            String s1 = sc.nextLine(), s2 = sc.nextLine();
            int s3 = Integer.parseInt(sc.nextLine()), s4 = Integer.parseInt(sc.nextLine());
            DonHang x = new DonHang (s1, s2, s3, s4);
            System.out.println(x);
        }
    }
}



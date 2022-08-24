
package javaptit;

import java.util.*;

public class SinhVien {
    private String maThiSinh, hoTen;
    private double toan, ly, hoa;

    public SinhVien(String maThiSinh, String hoTen, double toan, double ly, double hoa) {
        this.maThiSinh = maThiSinh;
        this.hoTen = hoTen;
        this.toan = toan;
        this.ly = ly;
        this.hoa = hoa;
    }
    
    public double diemUuTien () {
        String tmp = this.maThiSinh.substring(0, 3);
        if (tmp.equals("KV1")) {
            return 0.5;
        }
        else if (tmp.equals("KV2")) {
            return 1.0;
        }
        else return 2.5;
    }
    
    public double tongDiemNotUuTien () {
        return this.toan * 2 + this.ly + this.hoa;
    }
    
    public double tongDiem () {
        return this.tongDiemNotUuTien() + this.diemUuTien();
    }
    
    public String ketQua () {
        if (this.tongDiem() >= 24) return "TRUNG TUYEN";
        else return "TRUOT";
    }
    
    @Override
    public String toString () {
        String res = this.maThiSinh + " " + this.hoTen + " " + String.format("%.0f", this.diemUuTien()) + " ";
        if (this.tongDiemNotUuTien() == (int) this.tongDiemNotUuTien()) {
            res += String.format("%.0f", this.tongDiemNotUuTien());
        }
        else res += String.format("%.1f", this.tongDiemNotUuTien());
        res += " " + this.ketQua();
        return res;
    }
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        int t = 1;
        //t = Integer.parseInt(sc.nextLine());
        while (t-->0) {
            String maThiSinh = sc.nextLine(), hoTen = sc.nextLine();
            double toan = sc.nextDouble(), ly = sc.nextDouble(), hoa = sc.nextDouble();
            SinhVien x = new SinhVien(maThiSinh, hoTen, toan, ly, hoa);
            System.out.println(x);
        }
    }
}

//KV2A002
//Hoang Thanh Tuan
//5
//6
//5


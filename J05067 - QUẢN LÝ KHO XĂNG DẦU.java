Main.java
package javaptit;

import java.util.Collection;
import java.util.Scanner;
import java.util.*;
import java.util.Map.Entry;
 
public class Main {
    public static void main(String [] agrs){
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            String[] arr = s.trim().split("\\s+");
            String s1 = arr[0];
            int s2 = Integer.parseInt(arr[1]);
            DonHang x = new DonHang(s1, s2);
            System.out.println(x);
        }
    }
}


//4
//N89BP 4500
//D00BP 3500
//X92SH 2600
//X84TN 1000
DonHang.java
package javaptit;

import java.util.*;

public class DonHang {

    private String maDonHang;
    private int soLuong;

    public DonHang(String maDonHang, int soLuong) {
        this.maDonHang = maDonHang;
        this.soLuong = soLuong;
    }
    
    public String hangSanXuat() {
        String res = this.maDonHang.substring(this.maDonHang.length() - 2, this.maDonHang.length());
        if (res.equals("BP")) return "British Petro";
        if (res.equals("ES")) return "Esso";
        if (res.equals("SH")) return "Shell";
        if (res.equals("CA")) return "Castrol";
        if (res.equals("MO")) return "Mobil";
        return "Trong Nuoc";
    }
    
    public long donGia() {
        String res = this.maDonHang.substring(0, 1);
        if (res.equals("X")) return 128000;
        if (res.equals("D")) return 11200;
        return 9700;
    }
    
    public long thue() {
        if (this.hangSanXuat().equals("Trong Nuoc")) return 0;
        String res = this.maDonHang.substring(0, 1);
        if (res.equals("X")) return Math.round(this.soLuong * this.donGia() * 0.03) ;
        if (res.equals("D")) return Math.round(this.soLuong * this.donGia() * 0.035);
        return Math.round(this.soLuong * this.donGia() * 0.02);
    }
    
    public long thanhTien() {
        return this.donGia() * this.soLuong + this.thue();
    }
    
    @Override
    public String toString() {
        return this.maDonHang + " " + this.hangSanXuat() + " " + this.donGia() + " " + this.thue() + " " + this.thanhTien();
    }
    
}


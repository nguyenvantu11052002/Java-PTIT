package javaptit;

import java.util.*;

public class GiaoVien {
    private String maNganh, hoTen;
    private int luongCoBan;

    public GiaoVien(String maNganh, String hoTen, int luongCoBan) {
        this.maNganh = maNganh;
        this.hoTen = hoTen;
        this.luongCoBan = luongCoBan;
    }
    
    public int getBacLuong () {
        return (this.maNganh.charAt(2) - '0') * 10 + this.maNganh.charAt(3) - '0';
    }
    
    public int getPhuCap () {
        String res = this.maNganh.substring(0, 2);
        //System.out.println(res);
        if (res.equals("HT")) return 2000000;
        else if (res.equals("HP")) return 900000;
        else return 500000;
    }
    
    public int getThuNhap () {
        return this.luongCoBan * getBacLuong() + getPhuCap();
    }
        
    @Override
    public String toString () {
        return this.maNganh + " " + this.hoTen + " " + this.getBacLuong() + " " + this.getPhuCap() + " " + this.getThuNhap();
    }
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        int t = 1;
        //t = Integer.parseInt(sc.nextLine());
        while (t-->0) {
            String maNganh = sc.nextLine(), hoTen = sc.nextLine();
            int luongCoBan = sc.nextInt();
            GiaoVien x = new GiaoVien (maNganh, hoTen, luongCoBan);
            System.out.println(x);
        }
    }
}

//HP04
//Tran Quoc Huy
//1578000

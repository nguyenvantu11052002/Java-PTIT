Main.java
package javaptit;

import java.text.ParseException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        ArrayList<MatHang> list = new ArrayList<>();
        
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            String s1 = sc.nextLine();
            String s2 = sc.nextLine();
            int s3 = Integer.parseInt(sc.nextLine());
            int s4 = Integer.parseInt(sc.nextLine());
            
            list.add(new MatHang(s1, s2, s3, s4));
        }
        
        for (MatHang x : list) {
            System.out.println(x);
        }
    } 
}






MatHang.java
package javaptit;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class MatHang {
    private String maHang, tenHang, donViTinh;
    private int donGiaNhap, soLuong;

    public static int index = 1;
    
    public MatHang(String tenHang, String donViTinh, int donGiaNhap, int soLuong) {
        this.maHang = "MH" + String.format("%02d", index++);
        this.tenHang = tenHang;
        this.donViTinh = donViTinh;
        this.donGiaNhap = donGiaNhap;
        this.soLuong = soLuong;
    }
    
    public long phiVanChuyen() {
        return Math.round(this.donGiaNhap * this.soLuong * 0.05);
    }
    
    public long thanhTien() {
        return this.donGiaNhap * this.soLuong + this.phiVanChuyen();
    }
    
    public long giaBan() {
        return Math.round(this.thanhTien() + this.thanhTien() * 0.02);
    }
    
    @Override
    public String toString() {
        return this.maHang + " " + this.tenHang + " " + this.donViTinh + " " + this.phiVanChuyen() + " " + 
                this.thanhTien() + " " + this.giaBan();
    }
    
}

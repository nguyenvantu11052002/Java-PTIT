javaptit/Main.java
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
        
        Collections.sort(list, new SortBy());
        
        for (MatHang x : list) {
            System.out.println(x);
        }
    } 
}


//4
//DUONG
//KG
//7500
//150
//TRUNG
//CHUC
//10000
//225
//GAO
//KG
//14000
//118
//SUA
//HOP
//48000
//430




javaptit/MatHang.java
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
    
    public long giaBanLe() {
        return (long) Math.ceil(((this.thanhTien() + this.thanhTien() * 0.02)/this.soLuong)/100) * 100;
    }
    
    @Override
    public String toString() {
        return this.maHang + " " + this.tenHang + " " + this.donViTinh + " " + this.phiVanChuyen() + " " + 
                this.thanhTien() + " " + this.giaBanLe();
    }
    
}
javaptit/SortBy.java

package javaptit;

import java.util.*;

public class SortBy implements Comparator<MatHang> {
    
    @Override
    public int compare(MatHang o1, MatHang o2) {
        if (o1.giaBanLe() > o2.giaBanLe()) return -1;
        return 1;
    }
}


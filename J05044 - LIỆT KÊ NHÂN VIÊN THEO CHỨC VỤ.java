Main.java
package javaptit;

import java.text.ParseException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        ArrayList<NhanVien> list = new ArrayList<>();
        
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            String s1 = sc.nextLine();
            String s2 = sc.nextLine();
            int s3 = Integer.parseInt(sc.nextLine());
            int s4 = Integer.parseInt(sc.nextLine());
            list.add(new NhanVien(s1, s2, s3, s4));
        }
        String chucVu = sc.nextLine();
        
        for (NhanVien x : list) {
            if (x.getChucVu().equals(chucVu)) {
                System.out.println(x);
            }
        }
    } 
}




NhanVien.java
package javaptit;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class NhanVien {
    private String maNhanVien, hoVaTen, chucVu;
    private int luongCoBan, soNgayCong;

    public static int index = 1;
    
    public NhanVien(String hoVaTen, String chucVu, int luongCoBan, int soNgayCong) {
        this.maNhanVien = "NV" + String.format("%02d", index++);
        this.hoVaTen = hoVaTen;
        this.chucVu = chucVu;
        this.luongCoBan = luongCoBan;
        this.soNgayCong = soNgayCong;
    }
    
    public long phuCapChucVu() {
        if (this.chucVu.equals("GD")) return 500;
        if (this.chucVu.equals("PGD")) return 400;
        if (this.chucVu.equals("TP")) return 300;
        if (this.chucVu.equals("KT")) return 250;
        return 100;
    }
    
    
    public long luongChinh() {
        return (long) this.luongCoBan * this.soNgayCong;
    }
    
    public long tamUng() {
        double res = (double) (this.luongChinh() + this.phuCapChucVu()) * 2/3;
        if (res < 25000) {
            return Math.round(res / 1000) * 1000;
        }
        return 25000;
    }
    
    public long conLai() {
        return this.luongChinh() + this.phuCapChucVu() - this.tamUng();
    }
    
    public String getChucVu() {
        return this.chucVu;
    }
    
    @Override
    public String toString() {
        return this.maNhanVien + " " + this.hoVaTen + " " + this.phuCapChucVu() + " " + this.luongChinh()
               + " " + this.tamUng() + " " + this.conLai();
    }
}

javaptit/Main.java
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
        Collections.sort(list, new SortBy());
        
        for (NhanVien x : list) {
            System.out.println(x);
        }
    } 
}


//4
//Tran Thi Yen
//NV
//1000
//24
//Nguyen Van Thanh
//BV
//1000
//30
//Doan Truong An
//TP
//3000
//25
//Le Thanh
//GD
//5000
//28
//TP
javaptit/NhanVien.java
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
    
    public long getThuNhap() {
        return this.luongChinh() + this.phuCapChucVu();
    }
    
    public String getMaNhanVien() {
        return this.maNhanVien;
    }
    
    @Override
    public String toString() {
        return this.maNhanVien + " " + this.hoVaTen + " " + this.phuCapChucVu() + " " + this.luongChinh()
               + " " + this.tamUng() + " " + this.conLai();
    }
}
javaptit/SortBy.java

package javaptit;

import java.util.*;

public class SortBy implements Comparator<NhanVien> {
    
    @Override
    public int compare(NhanVien o1, NhanVien o2) {
        if (o1.getThuNhap() == o2.getThuNhap()) {
            if (o1.getMaNhanVien().compareTo(o2.getMaNhanVien()) < 0) return -1;
            return 1;
        }
        else {
            if (o1.getThuNhap() > o2.getThuNhap()) return -1;
            return 1;
        }
    }
}


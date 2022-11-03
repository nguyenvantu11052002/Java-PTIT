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
            int s2 = Integer.parseInt(sc.nextLine());
            int s3 = Integer.parseInt(sc.nextLine());
            String s4 = sc.nextLine();
            
            list.add(new NhanVien(s1, s2, s3, s4));
        }
        long res = 0;
        for (NhanVien x : list) {
            System.out.println(x);
            res += x.thucLinh();
        }
        System.out.println("Tong chi phi tien luong: " + res);
    } 
}

//5
//Cao Van Vu
//50000
//26
//GD
//Bui Thi Trang
//45000
//23
//PGD
//Do Van Truong
//40000
//25
//PGD
//Nguyen Van Cam
//37000
//26
//TP
//Truong Thi Tu Linh
//45000
//22
//NV




NhanVien.java
package javaptit;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class NhanVien {
    private String maNhanVien, hoTen, chucVu;
    private int luongNgay, soNgayCong;

    public static int index = 1;
    
    public NhanVien(String hoTen, int luongNgay, int soNgayCong, String chucVu) {
        this.maNhanVien = "NV" + String.format("%02d", index++);
        this.hoTen = hoTen;
        this.chucVu = chucVu;
        this.luongNgay = luongNgay;
        this.soNgayCong = soNgayCong;
    }
    
    public long luongThang() {
        return this.luongNgay * this.soNgayCong;
    }
    
    public long thuong() {
        if (this.soNgayCong >= 25) return (long) (this.luongThang() * 0.2);
        if (this.soNgayCong >= 22) return (long) (this.luongThang() * 0.1);
        return 0;
    }
    
    public long phuCapChucVu() {
        if (this.chucVu.equals("GD")) return 250000;
        if (this.chucVu.equals("PGD")) return 200000;
        if (this.chucVu.equals("TP")) return 180000;
        return 150000;
    }
    
    public long thucLinh() {
        return this.luongThang() + this.thuong() + this.phuCapChucVu();
    }

    @Override
    public String toString() {
        return this.maNhanVien + " " + this.hoTen + " " + this.luongThang() + " " + this.thuong() + " " + 
                this.phuCapChucVu() + " " + this.thucLinh();
    }
}

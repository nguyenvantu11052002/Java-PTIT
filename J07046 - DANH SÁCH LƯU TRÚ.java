test/KhachHang.java

package test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class KhachHang implements Comparable<KhachHang>{
    private String maKhachHang, hoTen, maPhong;
    private Date ngayDen, ngayDi;
    public static int index = 1;
    public static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    
    public KhachHang(String hoTen, String maPhong, String ngayDen, String ngayDi) throws ParseException {
        this.maKhachHang = "KH" + String.format("%02d", index++);
        this.hoTen = hoTen;
        this.maPhong = maPhong;
        this.ngayDen = sdf.parse(ngayDen);
        this.ngayDi = sdf.parse(ngayDi);
    }
    
    public long getSoNgayLuuTru() {
        long res = (this.ngayDi.getTime() - this.ngayDen.getTime()) / (60 * 60 * 24 * 1000);
        return res;
    }
    
    
    @Override
    public int compareTo(KhachHang other) {
        if (this.getSoNgayLuuTru() > other.getSoNgayLuuTru()) return -1;
        return 1;
    }
    
    @Override
    public String toString() {
        return this.maKhachHang + " " + this.hoTen + " " + this.maPhong + " " + this.getSoNgayLuuTru();
    }
}

test/Main.java

package test;

import java.io.File;
import java.io.FileNotFoundException;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;

import java.util.*;

public class Main {
    
    public static void main(String[] args) throws FileNotFoundException, ParseException {
        Scanner sc = new Scanner(new File("KHACH.in"));
        List<KhachHang> list = new ArrayList<>();
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            String s1 = sc.nextLine();
            String s2 = sc.nextLine();
            String s3 = sc.nextLine();
            String s4 = sc.nextLine();
            KhachHang x = new KhachHang(s1, s2, s3, s4);
            list.add(x);
        }
        Collections.sort(list);
        for (KhachHang x : list) {
            System.out.println(x);
        }
    }
}


package javaptit;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.ArrayList;
import java.util.Collections;

public class SanPham implements Comparable<SanPham> {
    private String maSanPham, tenSanPham;
    private int giaBan, thoiHanBaoHanh;

    public SanPham(String maSanPham, String tenSanPham, int giaBan, int thoiHanBaoHanh) {
        this.maSanPham = maSanPham;
        this.tenSanPham = tenSanPham;
        this.giaBan = giaBan;
        this.thoiHanBaoHanh = thoiHanBaoHanh;
    }
    
    public int getGiaBan () {
        return this.giaBan;
    }
    
    public String getMa () {
        return this.maSanPham;
    }
        
    @Override
    public String toString () {
        return this.maSanPham + " " + this.tenSanPham + " " + this.giaBan + " " + this.thoiHanBaoHanh;
    }
    
    @Override
    public int compareTo (SanPham other) {
        if (this.getGiaBan() == other.getGiaBan()) {
            if (this.getMa().compareTo(other.getMa()) < 0) return -1;
            return 1;
        }
        else if (this.getGiaBan() > other.getGiaBan()) {
            return -1;
        }
        else return 1;
    }
    
    public static void main(String[] args) throws IOException {
        ArrayList<SanPham> ds = new ArrayList<>();
        Scanner sc = new Scanner(new File("SANPHAM.in"));
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            String ma = sc.nextLine();
            String ten = sc.nextLine();
            int giaBan = Integer.parseInt(sc.nextLine());
            int baoHanh = Integer.parseInt(sc.nextLine());
            SanPham x = new SanPham(ma, ten, giaBan, baoHanh);
            ds.add(x);
        }
        Collections.sort(ds);
        for (SanPham x : ds) {
            System.out.println(x);
        }
    }
}


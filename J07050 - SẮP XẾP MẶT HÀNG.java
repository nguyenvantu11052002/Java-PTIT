package javaptit;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.ArrayList;
import java.util.Collections;

public class MatHang implements Comparable<MatHang> {
    private String maHang, tenHang, nhomHang;
    private double giaMua, giaBan;
    public static int id = 1;
    
    public MatHang(String tenHang, String nhomHang, double giaMua, double giaBan) {
        this.maHang = "MH" + String.format("%02d", id++);
        this.tenHang = tenHang;
        this.nhomHang = nhomHang;
        this.giaMua = giaMua;
        this.giaBan = giaBan;
    }
    
    public double loiNhuan () {
        return this.giaBan - this.giaMua;
    }
    
    @Override
    public String toString () {
        return this.maHang + " " + this.tenHang + " " + this.nhomHang + " " + String.format("%.2f", this.loiNhuan());
    }
    
    @Override
    public int compareTo (MatHang other) {
        if (this.loiNhuan() > other.loiNhuan()) return -1;
        return 1;
    }
    
    public static void main(String[] args) throws IOException {
        ArrayList<MatHang> ds = new ArrayList<>();
        Scanner sc = new Scanner(new File("MATHANG.in"));
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            String ten = sc.nextLine();
            String nhom = sc.nextLine();
            double giaMua = Double.parseDouble(sc.nextLine());
            double giaBan = Double.parseDouble(sc.nextLine());
            MatHang x = new MatHang(ten, nhom, giaMua, giaBan);
            ds.add(x);
        }
        Collections.sort(ds);
        for (MatHang x : ds) {
            System.out.println(x);
        }
    }
}

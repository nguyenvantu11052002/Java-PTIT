package javaptit;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.ArrayList;
import java.util.Collections;

public class LoaiPhong implements Comparable<LoaiPhong> {
    private String kyHieu, ten, donGia, phiPhucVu;

    public LoaiPhong(String s) {
        s = s.trim();
        String[] arr = s.split("\\s+");
        this.kyHieu = arr[0];
        this.ten = arr[1];
        this.donGia = arr[2];
        this.phiPhucVu = arr[3];
    }
     
    public String getTen () {
        return this.ten;
    }
    
    @Override
    public String toString () {
        return this.kyHieu + " " + this.ten + " " + this.donGia + " " + this.phiPhucVu;
    }
    
    @Override
    public int compareTo (LoaiPhong other) {
        if (this.getTen().compareTo(other.getTen()) < 0) return -1;
        return 1;
    }
    
    public static void main(String[] args) throws IOException {
        ArrayList<LoaiPhong> ds = new ArrayList<>();
        Scanner in = new Scanner(new File("PHONG.in"));
        int n = Integer.parseInt(in.nextLine());
        while(n-->0){
            ds.add(new LoaiPhong(in.nextLine()));
        }
        Collections.sort(ds);
        for(LoaiPhong tmp : ds){
            System.out.println(tmp);
        }
    }
    public static void main8579927(String[] args) throws IOException {
        ArrayList<LoaiPhong> ds = new ArrayList<>();
        Scanner in = new Scanner(new File("Phong.in"));
        int n = Integer.parseInt(in.nextLine());
        while(n-->0){
            ds.add(new LoaiPhong(in.nextLine()));
        }
        Collections.sort(ds);
        for(LoaiPhong tmp : ds){
            System.out.println(tmp);
        }
    }
}


J07045 - LOẠI PHÒNG

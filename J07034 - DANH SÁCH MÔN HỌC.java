package javaptit;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.ArrayList;
import java.util.Collections;

public class MonHoc implements Comparable<MonHoc> {
    private String maMonHoc, tenMonHoc;
    private int soTinChi;

    public MonHoc(String maMonHoc, String tenMonHoc, int soTinChi) {
        this.maMonHoc = maMonHoc;
        this.tenMonHoc = tenMonHoc;
        this.soTinChi = soTinChi;
    }
    
    public String getTen () {
        return this.tenMonHoc;
    }
    
    @Override
    public String toString () {
        return this.maMonHoc + " " + this.tenMonHoc + " " + this.soTinChi;
    }
    
    @Override
    public int compareTo (MonHoc other) {
        if (this.getTen().compareTo(other.getTen()) < 0) return -1;
        return 1;
    }
    
    public static void main(String[] args) throws IOException {
        ArrayList<MonHoc> ds = new ArrayList<>();
        Scanner sc = new Scanner(new File("MONHOC.in"));
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            String ma = sc.nextLine();
            String ten = sc.nextLine();
            int tinChi = Integer.parseInt(sc.nextLine());
            MonHoc x = new MonHoc(ma, ten, tinChi);
            ds.add(x);
        }
        Collections.sort(ds);
        for (MonHoc x : ds) {
            System.out.println(x);
        }
    }
}


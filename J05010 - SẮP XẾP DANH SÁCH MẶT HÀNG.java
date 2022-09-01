package javaptit;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class MatHang implements Comparable<MatHang> {
    private String maMatHang, tenMatHang, nhomHang;
    private double giaMua, giaBan;
    public static int id = 1;
    
    public MatHang(String tenMatHang, String nhomHang, double giaMua, double giaBan) {
        this.maMatHang = Integer.toString(id++);
        this.tenMatHang = tenMatHang;
        this.nhomHang = nhomHang;
        this.giaMua = giaMua;
        this.giaBan = giaBan;
    }
    
    public double getLoiNhuan () {
        return this.giaBan - this.giaMua;
    }
    
    @Override
    public int compareTo (MatHang other) {
        if (this.getLoiNhuan() - other.getLoiNhuan() > 0) return -1;
        return 1;
    }
    
    @Override
    public String toString () {
        return this.maMatHang + " " + this.tenMatHang + " " + this.nhomHang + " " + String.format("%.2f", this.getLoiNhuan());
    }
    
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        List<MatHang> list = new ArrayList<>();
        while(t-- >0){
            String s1 = sc.nextLine(), s2 = sc.nextLine();
            double s3 = Double.parseDouble(sc.nextLine()), s4 = Double.parseDouble(sc.nextLine());
            MatHang x = new MatHang (s1, s2, s3, s4);
            list.add(x);
        }
        Collections.sort(list);
        for (MatHang x : list) {
            System.out.println(x);
        }
    }
}

//3
//May tinh SONY VAIO
//Dien tu
//16400
//17699
//Tu lanh Side by Side
//Dien lanh
//18300
//25999
//Banh Chocopie
//Tieu dung
//27.5
//37

Main.java
package javaptit;

import java.util.Collection;
import java.util.Scanner;
import java.util.*;
 
public class Main {
    public static void main(String [] agrs){
        Scanner sc = new Scanner(System.in);
        ArrayList<NguoiThiTuyen> list = new ArrayList<>();
 
        int n = Integer.parseInt(sc.nextLine());
        for(int i = 0; i < n; i++){
            String s1 = sc.nextLine();
            String s2 = sc.nextLine();
            double s3 = Double.parseDouble(sc.nextLine());
            double s4 = Double.parseDouble(sc.nextLine());
            list.add(new NguoiThiTuyen(s1, s2, s3, s4));
        }
        Collections.sort(list, new SortBy());
        for(NguoiThiTuyen x : list){
            System.out.println(x);
        }
    }
 
}


//3
//Doan Thi Kim
//13/03/1982
//8
//9.5
//Dinh Thi Ngoc Ha
//03/09/1996
//6.5
//8
//Tran Thanh Mai
//12/09/2004
//8
//9
NguoiThiTuyen.java
package javaptit;

import java.util.*;

public class NguoiThiTuyen {

    private String maThiTuyen, hoTen, ngaySinh;
    private double diemLyThuyet, diemThucHanh;

    private static int index = 1;
    
    public NguoiThiTuyen(String hoTen, String ngaySinh, double diemLyThuyet, double diemThucHanh) {
        this.maThiTuyen = "PH" + String.format("%02d", index++);
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.diemLyThuyet = diemLyThuyet;
        this.diemThucHanh = diemThucHanh;
    }
    
    public String getMaThiTuyen() {
        return this.maThiTuyen;
    }
    
    public long tuoi() {
        String[] arr = this.ngaySinh.trim().split("/");
        return 2021 - Integer.parseInt(arr[2]);
    }
    
    public double diemThuong() {
        if (this.diemLyThuyet >= 8 && this.diemThucHanh >= 8) return 1.0;
        if (this.diemLyThuyet >= 7.5 && this.diemThucHanh >= 7.5) return 0.5;
        return 0.0;
    }
    
    public long diemTrungBinh() {
        double res = (this.diemLyThuyet + this.diemThucHanh)/2 + this.diemThuong();
        if (res > 10) res = 10;
        return Math.round(res); 
    }
    
    public String xepLoai() {
        long res = this.diemTrungBinh();
        if (res == 9 || res == 10) return "Xuat sac";
        if (res == 8) return "Gioi";
        if (res == 7) return "Kha";
        if (res >= 5 && res <= 6) return "Trung binh";
        return "Truot";
    }

    @Override
    public String toString() {
        return this.maThiTuyen + " " + this.hoTen + " " + this.tuoi() + " " + this.diemTrungBinh() + " " + this.xepLoai();
    }

}

SortBy.java
package javaptit;

import java.util.*;

public class SortBy implements Comparator<NguoiThiTuyen> {
    @Override
    public int  compare(NguoiThiTuyen o1, NguoiThiTuyen o2){
        if (o1.diemTrungBinh() == o2.diemTrungBinh()) {
            if (o1.getMaThiTuyen().compareTo(o2.getMaThiTuyen()) < 0) return -1;
            return 1;
        }
        else {
            if (o1.diemTrungBinh() > o2.diemTrungBinh()) return -1;
            return 1;
        }
    }
}


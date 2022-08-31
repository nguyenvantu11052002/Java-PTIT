package javaptit;

import java.util.*;

public class SinhVien {

    private String maSinhVien, hoTen, lop, ngaySinh;
    private double gpa;
    public static int id = 1;

    public SinhVien(String hoTen, String lop, String ngaySinh, double gpa) {
        this.maSinhVien = "B20DCCN" + String.format("%03d", id++);
        this.hoTen = hoTen;
        this.lop = lop;
        this.ngaySinh = ngaySinh;
        this.gpa = gpa;
    }

    public void chuanHoaNgaySinh() {
        String[] arr = this.ngaySinh.trim().split("/");
        if (arr[0].length() < 2) {
            arr[0] = "0" + arr[0];
        }
        if (arr[1].length() < 2) {
            arr[1] = "0" + arr[1];
        }
        this.ngaySinh = arr[0] + "/" + arr[1] + "/" + arr[2];
    }

    public void chuanHoaHoTen () {
        String[] arr = this.hoTen.trim().split("\\s+");
        String res = "";
        for (int i = 0; i < arr.length; i++) {
            res += Character.toUpperCase(arr[i].charAt(0));
            for (int j = 1; j < arr[i].length(); j++) {
                res += Character.toLowerCase(arr[i].charAt(j));
            }
            res += " ";
        }
        res.trim();
        this.hoTen = res;
    }
    
    @Override
    public String toString() {
        return this.maSinhVien + " " + this.hoTen + " " + this.lop + " " + this.ngaySinh + " " + String.format("%.2f", this.gpa);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = 1;
        //t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            int n = Integer.parseInt(sc.nextLine());
            for (int i = 0; i < n; i++) {
                String ten = sc.nextLine(), lop = sc.nextLine(), ngaySinh = sc.nextLine();
                double gpa = Double.parseDouble(sc.nextLine());
                SinhVien x = new SinhVien(ten, lop, ngaySinh, gpa);
                x.chuanHoaNgaySinh();;
                x.chuanHoaHoTen();
                System.out.println(x);
            }
        }
    }
}


//1
//nGuyEn  vaN    biNH
//D20CQCN01-B
//2/12/2002
//3.1

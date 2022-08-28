package javaptit;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
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

    public void chuanHoa() {
        String[] arr = this.ngaySinh.split("/");
        if (arr[0].length() < 2) {
            arr[0] = "0" + arr[0];
        }
        if (arr[1].length() < 2) {
            arr[1] = "0" + arr[1];
        }
        this.ngaySinh = arr[0] + "/" + arr[1] + "/" + arr[2];
    }

    @Override
    public String toString() {
        return this.maSinhVien + " " + this.hoTen + " " + this.lop + " " + this.ngaySinh + " " + String.format("%.2f", this.gpa);
    }

    public static void main(String[] args) throws FileNotFoundException {

        Scanner sc = new Scanner(new File("SV.in"));
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            String s1 = sc.nextLine(), s2 = sc.nextLine(), s3 = sc.nextLine();
            double s4 = Double.parseDouble(sc.nextLine());
            SinhVien x = new SinhVien(s1, s2, s3, s4);
            x.chuanHoa();
            System.out.println(x);

        }
    }
}

//1
//Nguyen Van An
//D20CQCN01-B
//2/12/2002
//3.19

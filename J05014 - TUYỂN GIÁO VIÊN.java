TuyenGiaoVien/GiaoVien.java
package TuyenGiaoVien;

public class GiaoVien {
    private String maGiaoVien, tenGiaoVien, maXetTuyen;
    private double diemTinHoc, diemChuyenMon;

    private static int index = 1;

    public GiaoVien( String tenGiaoVien, String maXetTuyen, double diemTinHoc, double diemChuyenMon) {
        this.maGiaoVien = "GV" + String.format("%02d", index++);
        this.tenGiaoVien = tenGiaoVien;
        this.maXetTuyen = maXetTuyen;
        this.diemTinHoc = diemTinHoc;
        this.diemChuyenMon = diemChuyenMon;
    }

    public double diemUuTien(){
        if(this.maXetTuyen.substring(1).equals("1")) return 2.0;
        if(this.maXetTuyen.substring(1).equals("2")) return 1.5;
        if(this.maXetTuyen.substring(1).equals("3")) return 1.0;
        return 0.0;
    }

    public String monHoc(){
        String res = this.maXetTuyen.substring(0,1);
        if(res.equals("A")) return "TOAN";
        if(res.equals("B")) return "LY";
        return "HOA";
    }

    public double tongDiem(){
        return this.diemTinHoc * 2 + this.diemChuyenMon + diemUuTien();
    }

    public String trangThai(){
        if(tongDiem() >= 18) return "TRUNG TUYEN";
        return "LOAI";
    }

    @Override
    public String toString(){
        return this.maGiaoVien + " " + this.tenGiaoVien + " " + monHoc() + " " + tongDiem() + " " + trangThai();
    }
    
}

TuyenGiaoVien/Main.java
package TuyenGiaoVien;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<GiaoVien> list = new ArrayList<>();

        int n = Integer.parseInt(sc.nextLine());
        for(int i = 0; i < n; i++){
            String s1 = sc.nextLine();
            String s2 = sc.nextLine();
            double s3 = Double.parseDouble(sc.nextLine());
            double s4 = Double.parseDouble(sc.nextLine());
            list.add(new GiaoVien(s1, s2, s3, s4));
        }
        Collections.sort(list, new SortBy());
        for(GiaoVien x : list){
            System.out.println(x);
        }
        sc.close();
    }
}

// 3
// Le Van Binh
// A1
// 7.0
// 3.0
// Tran Van Toan
// B3
// 4.0
// 7.0
// Hoang Thi Tam
// C2
// 7.0
// 6.0
TuyenGiaoVien/SortBy.java
package TuyenGiaoVien;

import java.util.Comparator;

public class SortBy implements Comparator<GiaoVien> {
    @Override
    public int compare(GiaoVien o1, GiaoVien o2){
        if(o1.tongDiem() > o2.tongDiem()) return -1;
        return 1;
    }
    
}


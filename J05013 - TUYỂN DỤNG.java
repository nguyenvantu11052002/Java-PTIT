TuyenDung/Main.java
package TuyenDung;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<ThiSinh> list = new ArrayList<>();

        int n = Integer.parseInt(sc.nextLine());
        for(int i = 0; i < n; i++){
            String s1 = sc.nextLine();
            double s2 = Double.parseDouble(sc.nextLine());
            double s3 = Double.parseDouble(sc.nextLine());
            list.add(new ThiSinh(s1, s2, s3));
        }
        Collections.sort(list, new SortBy());
        for(ThiSinh x : list){
            System.out.println(x);
        }
        sc.close();
    }
}

// 3
// Nguyen Thai Binh
// 45
// 75
// Le Cong Hoa
// 4
// 4.5
// Phan Van Duc
// 56
// 56
TuyenDung/SortBy.java
package TuyenDung;

import java.util.Comparator;

public class SortBy implements Comparator<ThiSinh>{
    @Override
    public int compare(ThiSinh o1, ThiSinh o2){
        if(o1.diemTB() > o2.diemTB()) return -1;
        return 1;
    }
    
}

TuyenDung/ThiSinh.java
package TuyenDung;

public class ThiSinh {
    private String maThiSinh, hoTen;
    private double diemLyThuyet, diemThucHanh;

    private static int index = 1;

    public ThiSinh( String hoTen, double diemLyThuyet, double diemThucHanh) {
        this.maThiSinh = "TS" + String.format("%02d", index ++);
        this.hoTen = hoTen;
        this.diemLyThuyet = diemLyThuyet;
        this.diemThucHanh = diemThucHanh;
    }

    public double DiemLyThuyet(){
        if(this.diemLyThuyet <= 10) return this.diemLyThuyet;
        return this.diemLyThuyet / 10;
    }

    public double DiemThucHanh(){
        if(this.diemThucHanh <= 10) return this.diemThucHanh;
        return this.diemThucHanh / 10;
    }
    
    public double diemTB(){
        return (DiemLyThuyet() + DiemThucHanh()) / 2;
    }

    public String xepLoai(){
        if(diemTB() > 9.5) return "XUAT SAC";
        if(diemTB() >= 8) return "DAT";
        if(diemTB() >= 5) return "CAN NHAC";
        return "TRUOT";
    }

    @Override
    public String toString(){
        return this.maThiSinh + " " + this.hoTen + " " + String.format("%.2f",diemTB()) + " " + xepLoai();
    }
}


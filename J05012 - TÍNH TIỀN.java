TinhTien/Main.java
package TinhTien;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<MatHang> list = new ArrayList<>();

        int n = Integer.parseInt(sc.nextLine());
        while(n --> 0){
            String s1 = sc.nextLine();
            String s2 = sc.nextLine();
            long s3 = Long.parseLong(sc.nextLine());
            long s4 = Long.parseLong(sc.nextLine());
            long s5 = Long.parseLong(sc.nextLine());
            list.add(new MatHang(s1, s2, s3, s4, s5));
        }
        Collections.sort(list, new SortBy());
        for(MatHang x : list){
            System.out.println(x);
        }
        sc.close();
    }
}

// 3
// ML01
// May lanh SANYO
// 12
// 4000000
// 2400000
// ML02
// May lanh HITACHI
// 4
// 2550000000
// 0
// ML03
// May lanh NATIONAL
// 5
// 3000000
// 150000
TinhTien/MatHang.java
package TinhTien;

public class MatHang {
    private String maMatHang, tenMatHang;
    private long soLuong, donGia, tienChietKhau;

    public MatHang(String maMatHang, String tenMatHang, long soLuong, long donGia, long tienChietKhau) {
        this.maMatHang = maMatHang;
        this.tenMatHang = tenMatHang;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.tienChietKhau = tienChietKhau;
    }

    public long tienThanhToan(){
        return this.donGia * this.soLuong - this.tienChietKhau;
    }

    @Override
    public String toString(){
        return this.maMatHang + " " + this.tenMatHang + " " + this.soLuong + " " + this.donGia + " " + this.tienChietKhau + " " + tienThanhToan();
    }
    
}

TinhTien/SortBy.java
package TinhTien;

import java.util.Comparator;

public class SortBy implements Comparator<MatHang> {
    @Override
    public int compare(MatHang o1, MatHang o2){
        if(o1.tienThanhToan() > o2.tienThanhToan()) return -1;
        return 1;
    }
    
}


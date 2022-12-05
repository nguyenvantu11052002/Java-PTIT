TinhLuong/Main.java
package TinhLuong;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<PhongBan> listPB = new ArrayList<>();

        int t = Integer.parseInt(sc.nextLine());
        while(t --> 0) {
            String s1 = sc.next();
            String s2 = sc.nextLine();
            listPB.add(new PhongBan(s1, s2));
        }

        ArrayList<NhanVien> list = new ArrayList<>();

        int n = Integer.parseInt(sc.nextLine());
        while(n --> 0) {
            String s1 = sc.nextLine();
            String s2 = sc.nextLine();
            long s3 = Long.parseLong(sc.nextLine());
            long s4 = Long.parseLong(sc.nextLine());
            NhanVien x = new NhanVien(s1, s2, s3, s4);
            for(PhongBan a : listPB) {
                if(x.maPhong().equals(a.getMa())) {
                    x.setTenPhong(a);
                }
            }
            list.add(x);
        }
        for(NhanVien x : list) {
            System.out.println(x);
        }
        sc.close();
    }
}

// 2
// HC Hanh chinh
// KH Ke hoach Dau tu
// 2
// C06HC
// Tran Binh Minh
// 65
// 25
// D03KH
// Le Hoa Binh
// 59
// 24

TinhLuong/NhanVien.java
package TinhLuong;

public class NhanVien {
    private PhongBan tenPhong;
    private String maNhanVien, tenNhanVien;
    private long luongCoBan, soNgayCong;
    public NhanVien( String maNhanVien, String tenNhanVien, long luongCoBan,
            long soNgayCong) {
        
        this.maNhanVien = maNhanVien;
        this.tenNhanVien = tenNhanVien;
        this.luongCoBan = luongCoBan;
        this.soNgayCong = soNgayCong;
    }

    public void setTenPhong(PhongBan tenPhong) {
        this.tenPhong = tenPhong;
    }

    public String maPhong() {
        return this.maNhanVien.substring(3);
    }

    public long heSoNhan() {
        String nam = this.maNhanVien.substring(1,3);
        int soNam = Integer.parseInt(nam);
        if(this.maNhanVien.startsWith("A")) {
            if(soNam >= 16) return 20;
            if(soNam >= 9) return 14;
            if(soNam >= 4) return 12;
            return 10;
        }
        if(this.maNhanVien.startsWith("B")) {
            if(soNam >= 16) return 16;
            if(soNam >= 9) return 13;
            if(soNam >= 4) return 11;
            return 10;
        }
        if(this.maNhanVien.startsWith("C")) {
            if(soNam >= 16) return 14;
            if(soNam >= 9) return 12;
            if(soNam >= 4) return 10;
            return 9;
        }
        if(this.maNhanVien.startsWith("D")) {
            if(soNam >= 16) return 13;
            if(soNam >= 9) return 11;
            if(soNam >= 4) return 9;
            return 8;
        }
        return 0;
    }
    
    public long luongThang() {
        return this.luongCoBan * 1000 * this.soNgayCong * heSoNhan();
    }
    
    @Override
    public String toString() {
        return this.maNhanVien + " " + this.tenNhanVien + " " + this.tenPhong + " " + luongThang();
    }
}

TinhLuong/PhongBan.java
package TinhLuong;

public class PhongBan {
    private String maPhong, tenPhong;

    public PhongBan(String maPhong, String tenPhong) {
        this.maPhong = maPhong;
        this.tenPhong = tenPhong;
    }

    public String getMa(){
        return maPhong;
    }

    @Override
    public String toString(){
        return this.tenPhong;
    }
}


Main.java
package javaptit;

import java.util.*;
import java.util.Map.Entry;

public class Main {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        HashMap<String, KhachHang> mapKH = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            String s1 = sc.nextLine(), s2 = sc.nextLine();
            String s3 = sc.nextLine(), s4 = sc.nextLine();
            KhachHang x = new KhachHang(s1, s2, s3, s4);
            String tmp = x.getMaKhachHang();
            mapKH.put(tmp, x);
        }
        
        int m = sc.nextInt();
        HashMap<String, MatHang> mapMH = new HashMap<>();
        
        for (int i = 0; i < m; i++) {
            sc.nextLine();
            String s1 = sc.nextLine();
            String s2 = sc.nextLine();
            int s3 = sc.nextInt();
            int s4 = sc.nextInt();
            MatHang x = new MatHang(s1, s2, s3, s4);
            mapMH.put(x.getMaMatHang(), x);
        }
        sc.nextLine();
        int q = Integer.parseInt(sc.nextLine());
        ArrayList<HoaDon> listHD = new ArrayList<>();
        
        for (int i = 0; i < q; i++) {
            String[] arr = sc.nextLine().trim().split("\\s+");
            KhachHang kh = mapKH.get(arr[0]);
            MatHang mh = mapMH.get(arr[1]);
            int soLuong = Integer.parseInt(arr[2]);
            HoaDon x = new HoaDon(kh, mh, soLuong);
            listHD.add(x);
        }
        Collections.sort(listHD, new SortBy());
        for (HoaDon x : listHD) {
            System.out.println(x);
        }
    }
}


//2
//Nguyen Van Nam
//Nam
//12/12/1997
//Mo Lao-Ha Dong-Ha Noi
//Tran Van Binh
//Nam
//11/14/1995
//Phung Khoang-Nam Tu Liem-Ha Noi
//2
//Ao phong tre em
//Cai
//25000
//41000
//Ao khoac nam
//Cai
//240000
//515000
//3
//KH001 MH001 2
//KH001 MH002 3
//KH002 MH002 4



HoaDon.java

package javaptit;
import java.util.*;

public class HoaDon {
    private String maHoaDon;
    private int soLuong;
    private KhachHang kh;
    private MatHang mh;

    private static int index = 1;

    public HoaDon(KhachHang kh, MatHang mh, int soLuong) {
        this.maHoaDon = "HD" + String.format("%03d", index++);
        this.kh = kh;
        this.mh = mh;
        this.soLuong = soLuong;
    }
    
    public long thanhTien() {
        return (long) this.soLuong * this.mh.getGiaBan();
    }
    
    public long loiNhuan() {
        return this.thanhTien() - (long) this.mh.getGiaMua() * this.soLuong;
    }
    
    public String getMaHoaDon() {
        return this.maHoaDon;
    }
    
    @Override
    public String toString() {
        return this.maHoaDon + " " + this.kh + " " + this.mh + " " + this.soLuong + 
                " " + this.thanhTien() + " " + this.loiNhuan();
    }
    
}

KhachHang.java
package javaptit;

import java.util.*;

public class KhachHang {
    private String maKhachHang, tenKhachHang, gioiTinh, ngaySinh, diaChi;

    private static int index = 1;
    
    public KhachHang(String tenKhachHang, String gioiTinh, String ngaySinh, String diaChi) {
        this.maKhachHang = "KH" + String.format("%03d", index++);
        this.tenKhachHang = tenKhachHang;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
    }
    
    public String getMaKhachHang() {
        return this.maKhachHang;
    }
    
    @Override
    public String toString() {
        return this.tenKhachHang + " " + this.diaChi;
    }
    
}

MatHang.java
package javaptit;

import java.util.*;

public class MatHang {
    private String maMatHang, tenMatHang, donViTinh;
    private int giaMua, giaBan;

    private static int index = 1;
    
    public MatHang(String tenMatHang, String donViTinh, int giaMua, int giaBan) {
        this.maMatHang = "MH" + String.format("%03d", index++);
        this.tenMatHang = tenMatHang;
        this.donViTinh = donViTinh;
        this.giaMua = giaMua;
        this.giaBan = giaBan;
    }
    
    public String getMaMatHang() {
        return this.maMatHang;
    }
    
    public int getGiaBan() {
        return this.giaBan;
    }
    
    public int getGiaMua() {
        return this.giaMua;
    }
    
    @Override
    public String toString() {
        return this.tenMatHang;
    }
    
}

SortBy.java
package javaptit;

import java.util.*;
import java.util.Map.Entry;

public class SortBy implements Comparator<HoaDon>{
    @Override
    public int compare(HoaDon o1, HoaDon o2) {
        if (o1.loiNhuan() == o2.loiNhuan()) {
            if (o1.getMaHoaDon().compareTo(o2.getMaHoaDon()) < 0) return -1;
            return 1;
        }
        else {
            if (o1.loiNhuan() > o2.loiNhuan()) return -1;
            return 1;
        }
    }
}


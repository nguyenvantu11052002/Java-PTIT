javaptit/HoaDon.java

package javaptit;

public class HoaDon {
    private String maHoaDon, tenSanPham;
    private long soTienGiamGia, soTienPhaiTra;

    public HoaDon(String maHoaDon, String tenSanPham, long soTienGiamGia, long soTienPhaiTra) {
        this.maHoaDon = maHoaDon;
        this.tenSanPham = tenSanPham;
        this.soTienGiamGia = soTienGiamGia;
        this.soTienPhaiTra = soTienPhaiTra;
    }
    
    @Override
    public String toString() {
        return this.maHoaDon + " " + this.tenSanPham + " " + this.soTienGiamGia + " " + this.soTienPhaiTra;
    }
}

javaptit/Main.java
package javaptit;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.*;

public class Main {
    
    public static int idx = 1;
    
    public static double giamGia(long soLuong) {
        if (soLuong >= 150) return 0.5;
        if (soLuong >= 100) return 0.3;
        if (soLuong >= 50) return 0.15;
        return 0;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long t = 1;
        t = Integer.parseInt(sc.nextLine());
        List<SanPham> list = new ArrayList<>();

        while (t-->0) {
            String s1 = sc.nextLine(), s2 = sc.nextLine();
            long s3 = Integer.parseInt(sc.nextLine()), s4 = Integer.parseInt(sc.nextLine());
            SanPham x = new SanPham(s1, s2, s3, s4);
            list.add(x);
        }
        int q = Integer.parseInt(sc.nextLine());
        while(q-->0) {
            String s = sc.nextLine();
            String[] arr = s.split("\\s+");
            String maLoai = arr[0].substring(0, 2);
            String loai = arr[0].substring(2, 3);
            long soLuong = Integer.parseInt(arr[1]);
          
            
            
            long soTienGiamGia = 0;
            long soTienPhaiTra = 0;
            String tenSanPham = "";
            String maHoaDon = arr[0] + "-" + String.format("%03d", idx++);
            
            
            
            for (SanPham x : list) {
                if (x.getMaLoai().equals(maLoai)) {  
                    tenSanPham = x.getTenSanPham();
                    if (loai.equals("1")) {
                        soTienGiamGia = (long) (x.getDonGiaLoai1() * soLuong * giamGia(soLuong));
                        soTienPhaiTra = soLuong * x.getDonGiaLoai1() - soTienGiamGia;
                    }
                    else{
                        soTienGiamGia = (long) (x.getDonGiaLoai2() * soLuong * giamGia(soLuong));
                        soTienPhaiTra = soLuong * x.getDonGiaLoai2() - soTienGiamGia;
                    }
                }
            }        
            HoaDon x = new HoaDon(maHoaDon, tenSanPham, soTienGiamGia, soTienPhaiTra);
            System.out.println(x);
        }
    }
}



//2
//AT
//Ao thun
//80000
//45000
//QJ
//Quan Jean
//220000
//125000
//2
//AT1 95
//QJ2 105
javaptit/SanPham.java

package javaptit;

public class SanPham {
    private String maLoai, tenSanPham;
    private long donGiaLoai1, donGiaLoai2;

    public SanPham(String maLoai, String tenSanPham, long donGiaLoai1, long donGiaLoai2) {
        this.maLoai = maLoai;
        this.tenSanPham = tenSanPham;
        this.donGiaLoai1 = donGiaLoai1;
        this.donGiaLoai2 = donGiaLoai2;
    }

    public String getMaLoai() {
        return maLoai;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public long getDonGiaLoai1() {
        return donGiaLoai1;
    }

    public long getDonGiaLoai2() {
        return donGiaLoai2;
    }
    
}


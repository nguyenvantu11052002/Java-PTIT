javaptit/HoaDon.java

package javaptit;

public class HoaDon {
    private String maHoaDon;
    private long soLuong;

    public HoaDon(String maHoaDon, long soLuong) {
        this.maHoaDon = maHoaDon;
        this.soLuong = soLuong;
    }

    public String getMaHoaDon() {
        return maHoaDon;
    }

    public long getSoLuong() {
        return soLuong;
    }
}
javaptit/Inra.java

package javaptit;

import java.util.*;

public class Inra implements Comparable<Inra> {
    private String maHoaDonDayDu, tenSanPham;
    private long soTienGiamGia, soTienPhaiTra;

    public Inra(String maHoaDonDayDu, String tenSanPham, long soTienGiamGia, long soTienPhaiTra) {
        this.maHoaDonDayDu = maHoaDonDayDu;
        this.tenSanPham = tenSanPham;
        this.soTienGiamGia = soTienGiamGia;
        this.soTienPhaiTra = soTienPhaiTra;
    }
    
    @Override
    public int compareTo(Inra other) {
        if (this.soTienPhaiTra > other.soTienGiamGia) return -1;
        return 1;
    }
    
    @Override
    public String toString() {
        return this.maHoaDonDayDu + " " + this.tenSanPham +
                " " + this.soTienGiamGia + " " + this.soTienPhaiTra;
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
import static javaptit.Support.solve;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long t = 1;
        t = Integer.parseInt(sc.nextLine());
        HashMap<String, SanPham> map = new HashMap<>();

        while (t-- > 0) {
            String s1 = sc.nextLine(), s2 = sc.nextLine();
            long s3 = Integer.parseInt(sc.nextLine()), s4 = Integer.parseInt(sc.nextLine());
            SanPham x = new SanPham(s1, s2, s3, s4);
            map.put(s1, x);
        }
        int q = Integer.parseInt(sc.nextLine());
        ArrayList<HoaDon> list = new ArrayList<>();
        while (q-- > 0) {
            String s = sc.nextLine();
            String[] arr = s.trim().split("\\s+");
            String s1 = arr[0];
            long s2 = Long.parseLong(arr[1]);
            list.add(new HoaDon(s1, s2));
        }
        solve(map, list);
        
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
javaptit/Support.java
package javaptit;

import java.util.*;

public class Support {

    public static int index = 1;

    public static double giamGia(long soLuong) {
        if (soLuong >= 150) {
            return 0.5;
        }
        if (soLuong >= 100) {
            return 0.3;
        }
        if (soLuong >= 50) {
            return 0.15;
        }
        return 0;
    }

    public static void solve(HashMap<String, SanPham> map, ArrayList<HoaDon> list) {
        ArrayList<HoaDonInRa> listHoaDonInRa = new ArrayList<>();
        for (HoaDon tmp : list) {
            String maHoaDon = tmp.getMaHoaDon() + "-" + String.format("%03d", index++);
            String tenSanPham = "";
            String maLoai = tmp.getMaHoaDon().substring(0, 2);
            String loai = tmp.getMaHoaDon().substring(2, 3);
            long soTienGiamGia = 0;
            long soTienPhaiTra = 0;
            long soLuong = tmp.getSoLuong();
            if (map.containsKey(maLoai)) {
                SanPham x = map.get(maLoai);
                tenSanPham = x.getTenSanPham();
                if (loai.equals("1")) {
                    soTienGiamGia = (long) (x.getDonGiaLoai1() * soLuong * giamGia(soLuong));
                    soTienPhaiTra = soLuong * x.getDonGiaLoai1() - soTienGiamGia;
                } else {
                    soTienGiamGia = (long) (x.getDonGiaLoai2() * soLuong * giamGia(soLuong));
                    soTienPhaiTra = soLuong * x.getDonGiaLoai2() - soTienGiamGia;
                }

            }

            listHoaDonInRa.add(new HoaDonInRa(maHoaDon, tenSanPham, soTienGiamGia, soTienPhaiTra));

        }
        Collections.sort(listHoaDonInRa);
        for (HoaDonInRa y : listHoaDonInRa) {
            System.out.println(y);
        }

    }

}

javaptit/HoaDonInRa.java
package javaptit;
 
public class HoaDonInRa implements Comparable<HoaDonInRa> {
    private String maHoaDon, tenSanPham;
    private long soTienGiamGia, soTienPhaiTra;
 
    public HoaDonInRa(String maHoaDon, String tenSanPham, long soTienGiamGia, long soTienPhaiTra) {
        this.maHoaDon = maHoaDon;
        this.tenSanPham = tenSanPham;
        this.soTienGiamGia = soTienGiamGia;
        this.soTienPhaiTra = soTienPhaiTra;
    }
 
    @Override
    public int compareTo(HoaDonInRa other) {
        if (this.soTienPhaiTra > other.soTienPhaiTra) return -1;
        return 1;
    }
    
    @Override
    public String toString() {
        return this.maHoaDon + " " + this.tenSanPham + " " + this.soTienGiamGia + " " + this.soTienPhaiTra;
    }

    
}

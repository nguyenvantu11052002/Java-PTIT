javaptit/DonHang.java
package javaptit;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class DonHang {
    private String tenHang, maDonHang;
    private int donGia, soLuong;

    public DonHang(String tenHang, String maDonHang, int donGia, int soLuong) {
        this.tenHang = tenHang;
        this.maDonHang = maDonHang;
        this.donGia = donGia;
        this.soLuong = soLuong;
    }
    
    public String soThuTuDonHang() {
        return this.maDonHang.substring(1, 4);
    }
    
    public String maLoai() {
        return this.maDonHang.substring(4, 5);
    }
    
    public long giamGia() {
        if (this.maLoai().equals("1")) {
            return (long) (this.donGia * this.soLuong * 0.5);
        }
        else {
            return (long) (this.donGia * this.soLuong * 0.3);
        }
    }
    
    public long thanhTien() {
        return this.donGia * this.soLuong - this.giamGia();
    }
    
    @Override
    public String toString() {
        return this.tenHang + " " + this.maDonHang + " " + this.soThuTuDonHang() + " " + this.giamGia() + " " + this.thanhTien();
    }
}
javaptit/Main.java
package javaptit;

import java.text.ParseException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        ArrayList<DonHang> list = new ArrayList<>();
        
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            String s1 = sc.nextLine();
            String s2 = sc.nextLine();
            int s3 = Integer.parseInt(sc.nextLine());
            int s4 = Integer.parseInt(sc.nextLine());
            list.add(new DonHang(s1, s2, s3, s4));
        }
        Collections.sort(list, new SortBy());
        
        for (DonHang x : list) {
            System.out.println(x);
        }
    } 
}

//3
//Kaki 2
//K0252
//80000
//15
//Jean 1
//J2011
//200000
//24
//Jean 2
//J0982
//150000
//12

javaptit/SortBy.java

package javaptit;

import java.util.*;

public class SortBy implements Comparator<DonHang> {
    
    @Override
    public int compare(DonHang o1, DonHang o2) {
        if (o1.soThuTuDonHang().compareTo(o2.soThuTuDonHang()) < 0) return -1;
        return 1;
    }
}


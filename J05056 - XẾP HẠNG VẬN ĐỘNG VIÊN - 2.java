javaptit/Main.java
package javaptit;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
 
public class Main {
 
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        ArrayList<VanDongVien> list = new ArrayList<>();
    
        ArrayList<String> listThanhTich = new ArrayList<>();
        
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            String s1 = sc.nextLine();
            String s2 = sc.nextLine();
            String s3 = sc.nextLine();
            String s4 = sc.nextLine();
            int s5 = 0;
            VanDongVien x = new VanDongVien(s1, s2, s3, s4, s5);
            list.add(x);
            listThanhTich.add(x.thanhTichDeXepHang());
        }
        Collections.sort(listThanhTich);
        
        for (VanDongVien x : list) {
            x.setHang(Support.rank(x.thanhTichDeXepHang(), listThanhTich));
        }
        
        Collections.sort(list, new SortBy());
        for (VanDongVien x : list) {
            System.out.println(x);
        }
    }
}


//3
//Nguyen Van Thanh
//20/03/1990
//07:00:00
//07:10:01
//Nguyen Hoa Binh
//01/10/1993
//07:02:00
//07:11:20
//Le Thanh Van
//15/03/1998
//07:05:00
//07:15:30

javaptit/SortBy.java
package javaptit;

import java.util.*;

public class SortBy implements Comparator<VanDongVien> {
    @Override
    public int compare(VanDongVien o1, VanDongVien o2) {
        if (o1.getHang() < o2.getHang()) return -1;
        return 1;
    }
}

javaptit/Support.java

package javaptit;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Support {

    
    public static String truHaiThoiGian(String s1, String s2) {
        String[] arr1 = s1.trim().split(":");
        String[] arr2 = s2.trim().split(":");
        int gio1 = Integer.parseInt(arr1[0]);
        int phut1 = Integer.parseInt(arr1[1]);
        int giay1 = Integer.parseInt(arr1[2]);
        int gio2 = Integer.parseInt(arr2[0]);
        int phut2 = Integer.parseInt(arr2[1]);
        int giay2 = Integer.parseInt(arr2[2]);
        int tongTime = gio1 * 3600 + phut1 * 60 + giay1 - (gio2 * 3600 + phut2 * 60 + giay2);
        int gio = tongTime/3600;
        int phut = (tongTime % 3600)/60;
        int giay = (tongTime % 3600 % 60);
        return String.format("%02d:%02d:%02d", gio, phut, giay);
    }
    
    public static int rank(String x, ArrayList<String> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(x)) return i + 1;
        }
        return 0;
    }
    
    
}

javaptit/VanDongVien.java
package javaptit;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;
public class VanDongVien {
 
    private String ma, hoTen, ngaySinh;
    private int hang;
    private Date thoiGianXuatPhat, thoiGianDenDich;

    private static int index = 1;
    
    private static final SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
    
    public VanDongVien(String hoTen, String ngaySinh, String thoiGianXuatPhat, String thoiGianDenDich, int hang) throws ParseException {
        this.ma = "VDV" + String.format("%02d", index++);
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.thoiGianXuatPhat = sdf.parse(thoiGianXuatPhat);
        this.thoiGianDenDich = sdf.parse(thoiGianDenDich);
        this.hang = hang;
    }

    public void setHang(int hang) {
        this.hang = hang;
    }
    
    public int getHang() {
        return this.hang;
    }
    
    public String thanhTichThucTe() {
        long tongTime = this.thoiGianDenDich.getTime() - this.thoiGianXuatPhat.getTime();
        long gio = TimeUnit.MILLISECONDS.toHours(tongTime);
        long phut = TimeUnit.MILLISECONDS.toMinutes(tongTime - gio * 60 * 60 * 1000);
        long giay = TimeUnit.MILLISECONDS.toSeconds(tongTime - gio * 60 * 60 * 1000 - phut * 60 * 1000);
        return String.format("%02d:%02d:%02d", gio, phut, giay);
    }
    
    public String uuTien() {
        String[] arr = this.ngaySinh.trim().split("/");
        int namSinh = Integer.parseInt(arr[2]);
        int tuoi = 2021 - namSinh;
        if (tuoi > 32) return "00:00:03";
        if (tuoi >= 25) return "00:00:02";
        if (tuoi >= 18) return "00:00:01";
        return "00:00:00";
    }
    
    public String thanhTichDeXepHang() {
        return Support.truHaiThoiGian(this.thanhTichThucTe(), this.uuTien());
    }
    
    @Override
    public String toString() {
        return this.ma + " " + this.hoTen + " " + this.thanhTichThucTe() + " " + this.uuTien() + " " +
                this.thanhTichDeXepHang() + " " + this.hang;
    }
}

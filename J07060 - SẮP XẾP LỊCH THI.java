ThiCuoiKy/CaThi.java
package ThiCuoiKy;

public class CaThi {
    private String maCaThi, ngayThi, gioThi, phongThi;

    private static int index = 1;
    public CaThi(String ngayThi, String gioThi, String phongThi) {
        this.maCaThi = String.format("C%03d", index++);
        this.ngayThi = ngayThi;
        this.gioThi = gioThi;
        this.phongThi = phongThi;
    }
    public String getMaCaThi() {
        return maCaThi;
    }
    public String getNgayThi() {
        return ngayThi;
    }
    public String getGioThi() {
        return gioThi;
    }
    public String getPhongThi() {
        return phongThi;
    }  
}

ThiCuoiKy/LichThi.java
package ThiCuoiKy;

public class LichThi {
    private String maCaThi, ngayThi, gioThi, phongThi, monThi, nhomThi, soSinhVien;

    public LichThi(String maCaThi, String ngayThi, String gioThi, String phongThi, String monThi, String nhomThi,
            String soSinhVien) {
        this.maCaThi = maCaThi;
        this.ngayThi = ngayThi;
        this.gioThi = gioThi;
        this.phongThi = phongThi;
        this.monThi = monThi;
        this.nhomThi = nhomThi;
        this.soSinhVien = soSinhVien;
    }

    public String getMaCaThi() {
        return maCaThi;
    }

    public String getNgayThi() {
        return ngayThi;
    }

    public String getGioThi() {
        return gioThi;
    }

    @Override
    public String toString() {
        return  this.ngayThi + " " + this.gioThi + " " + this.phongThi + " " + this.monThi + " " + this.nhomThi + " " +
                this.soSinhVien;
    }

}

ThiCuoiKy/Main.java
package ThiCuoiKy;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("MONTHI.in"));
        //System.out.println("Chay de");
        int n = Integer.parseInt(sc.nextLine());
        HashMap<String, MonThi> mapMT = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String s1 = sc.nextLine(), s2 = sc.nextLine(), s3 = sc.nextLine();
            MonThi x = new MonThi(s1, s2, s3);
            mapMT.put(s1, x);
        }
        /////////////////////////////////////////////////
        sc = new Scanner(new File("CATHI.in"));
        int m = Integer.parseInt(sc.nextLine());
        HashMap<String, CaThi> mapCT = new HashMap<>();
        for (int i = 0; i < m; i++) {
            String s1 = sc.nextLine(), s2 = sc.nextLine(), s3 = sc.nextLine();
            CaThi x = new CaThi(s1, s2, s3);
            mapCT.put(x.getMaCaThi(), x);
        }
        ////////////////////////////////////////////////////
        sc = new Scanner(new File("LICHTHI.in"));
        int p = Integer.parseInt(sc.nextLine());
        ArrayList<LichThi> list = new ArrayList<>();
        for (int i = 0; i < p; i++) {
            String[] arr = sc.nextLine().trim().split("\\s+");
            String s1 = arr[0];
            String s2 = mapCT.get(arr[0]).getNgayThi();
            String s3 = mapCT.get(arr[0]).getGioThi();
            String s4 = mapCT.get(arr[0]).getPhongThi();
            String s5 = mapMT.get(arr[1]).getTenMon();
            String s6 = arr[2];
            String s7 = arr[3];
            LichThi x = new LichThi(s1, s2, s3, s4, s5, s6, s7);
            list.add(x);   
        }
        Collections.sort(list, new SortBy());
        for (LichThi x : list) {
            System.out.println(x);
        }
    }

}



ThiCuoiKy/MonThi.java
package ThiCuoiKy;

public class MonThi {
    private String maMon, tenMon, hinhThuc;

    public MonThi(String maMon, String tenMon, String hinhThuc) {
        this.maMon = maMon;
        this.tenMon = tenMon;
        this.hinhThuc = hinhThuc;
    }

    public String getTenMon() {
        return tenMon;
    }
    
}

ThiCuoiKy/SortBy.java
package ThiCuoiKy;

import java.util.Comparator;

public class SortBy implements Comparator<LichThi> {
    @Override
    public int compare(LichThi a, LichThi b) {
        if (!a.getNgayThi().equals(b.getNgayThi())) {
            if (a.getNgayThi().compareTo(b.getNgayThi()) < 0) return -1;
            return 1;
        }
        else {
            if (!a.getGioThi().equals(b.getGioThi())) {
                if (a.getGioThi().compareTo(b.getGioThi()) < 0) return -1;
                return 1;
            }
            else {
                if (a.getMaCaThi().compareTo(b.getMaCaThi()) < 0) return -1;
                return 1;
            }
        }
    }
}


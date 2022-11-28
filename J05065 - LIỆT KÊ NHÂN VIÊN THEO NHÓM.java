Main.java
package javaptit;

import java.text.ParseException;
import java.util.*;


public class Main {
    public static void main(String [] args) throws ParseException{
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<NhanVien> list = new ArrayList<>();
        int gd = 0, tp = 0, pp = 0;
        for (int i = 0; i < n; i++) {
            String[] arr = sc.nextLine().trim().split("\\s+");
            String s = "";
            for (int j = 1; j < arr.length; j++) {
                s += arr[j] + " ";
            }
            String sau = arr[0].substring(2);
            if (arr[0].startsWith("GD")) {
                gd += 1;
                if (gd > 1) arr[0] = "NV" + sau;
            }
            else {
                if (arr[0].startsWith("TP")) {
                    tp += 1;
                    if (tp > 3) arr[0] = "NV" + sau;
                }
                else {
                    if (arr[0].startsWith("PP")) {
                        pp += 1;
                        if (pp > 3) arr[0] = "NV" + sau;
                    }
                }
            }
            list.add(new NhanVien(arr[0], s.trim()));
        }
        Collections.sort(list, new SortBy());
        int q = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < q; i++) {
            String s = sc.nextLine();
            for (NhanVien x : list) {
                if (x.maChucVu().equals(s)) {
                    System.out.println(x);
                }
            }
            System.out.println("");
        }
    }
}


//6
//GD08001 Nguyen Kim Loan
//TP05002 Hoang Thanh Tuan
//TP05001 Tran Binh Nguyen
//PP06002 Phan Trung Tuan
//PP06001 Tran Quoc Huy
//NV04003 Vo Van Lan
//2
//TP
//PP


NhanVien.java
package javaptit;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class NhanVien {
    private String maNhanVien, tenNhanVien;

    public NhanVien(String maNhanVien, String tenNhanVien) {
        this.maNhanVien = maNhanVien;
        this.tenNhanVien = tenNhanVien;
    }
    
    public String getBacLuong() {
        return this.maNhanVien.substring(2, 4);
    }
    
    public String getSoHieu() {
        return this.maNhanVien.substring(4);
    }
    
    public String maChucVu() {
        return this.maNhanVien.substring(0, 2);
    }
    
    @Override
    public String toString() {
        return this.tenNhanVien + " " + this.maChucVu() + " " + this.getSoHieu() + " " + this.getBacLuong();
    }

}

SortBy.java
package javaptit;

import java.util.*;

public class SortBy implements Comparator<NhanVien> {
    @Override
    public int compare(NhanVien o1, NhanVien o2) {
        if (!o1.getBacLuong().equals(o2.getBacLuong())) {
            if (o1.getBacLuong().compareTo(o2.getBacLuong()) > 0) return -1;
            return 1;
        }
        else {
            if (o1.getSoHieu().compareTo(o2.getSoHieu()) < 0) return -1;
            return 1;
        }
    }
}


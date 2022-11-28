javaptit/BangDiem.java


package javaptit;

public class BangDiem {
    private String maSinhVien, maMonHoc, diem;

    public BangDiem(String maSinhVien, String maMonHoc, String diem) {
        this.maSinhVien = maSinhVien;
        this.maMonHoc = maMonHoc;
        this.diem = diem;
    }
    
    public String getMaSinhVien() {
        return this.maSinhVien;
    }
    
    public String getDiem() {
        return this.diem;
    }
    
}

javaptit/InRa.java

package javaptit;

public class InRa {
    private SinhVien sv;
    private double diem;

    public InRa(SinhVien sv, double diem) {
        this.sv = sv;
        this.diem = diem;
    }

    public SinhVien getSv() {
        return sv;
    }

    public double getDiem() {
        return diem;
    }

    @Override
    public String toString() {
        if (this.diem == (int) this.diem) {
            return this.sv + " " + String.format("%.0f", this.diem);
        }
        else return this.sv + " " + String.format("%.1f", this.diem);
    } 
}

javaptit/Main.java
package javaptit;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.*;


public class Main {
    public static void main(String [] args) throws ParseException, FileNotFoundException{
        Scanner sc1 = new Scanner(new File("SINHVIEN.in"));
        int n = Integer.parseInt(sc1.nextLine());
        ArrayList<SinhVien> listSV = new ArrayList<>();
        HashMap<String, SinhVien> mapSV = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String s1 = sc1.nextLine(), s2 = sc1.nextLine();
            String s3 = sc1.nextLine(), s4 = sc1.nextLine();
            SinhVien x = new SinhVien(s1, s2, s3, s4);
            mapSV.put(s1, x);  
        }
        Scanner sc2 = new Scanner(new File("MONHOC.in"));
        int m = Integer.parseInt(sc2.nextLine());
        HashMap<String, MonHoc> mapMH = new HashMap<>();
        for (int i = 0; i < m; i++) {
            String s1 = sc2.nextLine();
            String s2 = sc2.nextLine();
            String s3 = sc2.nextLine();
            mapMH.put(s1, new MonHoc(s1, s2, s3));
        }
        Scanner sc3 = new Scanner(new File("BANGDIEM.in"));
        int k = Integer.parseInt(sc3.nextLine());
        HashMap<String, ArrayList<BangDiem> > mapBD = new HashMap<>();
        for (int i = 0; i < k; i++) {
            String[] arr = sc3.nextLine().trim().split("\\s+");
            BangDiem x = new BangDiem(arr[0], arr[1], arr[2]);
            ArrayList<BangDiem> tmp = new ArrayList<>();
            tmp.add(x);
            if (mapBD.containsKey(arr[1])) {
                mapBD.get(arr[1]).add(x);
            }
            else {
                mapBD.put(arr[1], tmp);
            }
        }
        int q = Integer.parseInt(sc3.nextLine());
        for (int i = 0; i < q; i++) {
            String s = sc3.nextLine();
            System.out.print("BANG DIEM MON ");
            System.out.println(mapMH.get(s).getTenMonHoc() + ":");
            ArrayList<InRa> listInRa = new ArrayList<>();
            for (BangDiem x : mapBD.get(s)) {
                SinhVien svAdd = mapSV.get(x.getMaSinhVien());
                double diemAdd = Double.parseDouble(x.getDiem());
                listInRa.add(new InRa(svAdd, diemAdd));
            }
            Collections.sort(listInRa, new SortBy());
            for (InRa x : listInRa) {
                System.out.println(x);
            }
        }
    }
}







javaptit/MonHoc.java

package javaptit;

public class MonHoc {
    private String maMonHoc, tenMonHoc, soTinChi;

    public MonHoc(String maMonHoc, String tenMonHoc, String soTinChi) {
        this.maMonHoc = maMonHoc;
        this.tenMonHoc = tenMonHoc;
        this.soTinChi = soTinChi;
    }
    
    public String getTenMonHoc() {
        return this.tenMonHoc;
    }
}

javaptit/SinhVien.java
package javaptit;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class SinhVien {
    private String maSinhVien, hoTen, lop, email;

    public SinhVien(String maSinhVien, String hoTen, String lop, String email) {
        this.maSinhVien = maSinhVien;
        this.hoTen = Support.chuanHoa(hoTen);
        this.lop = lop;
        this.email = email;
    }
    
    public String getMaSinhVien() {
        return this.maSinhVien;
    }
    
    @Override
    public String toString() {
        return this.maSinhVien + " " + this.hoTen + " " + this.lop;
    }

}

javaptit/SortBy.java
package javaptit;

import java.util.*;

public class SortBy implements Comparator<InRa> {
    @Override
    public int compare(InRa o1, InRa o2) {
        String maSinhVien1 = o1.getSv().getMaSinhVien();
        String maSinhVien2 = o2.getSv().getMaSinhVien();
        if (o1.getDiem() != o2.getDiem()) {
            if (o1.getDiem() > o2.getDiem()) return -1;
            return 1;
        }
        else {
            if (maSinhVien1.compareTo(maSinhVien2) < 0) return -1;
            return 1;
        }
    }
}

javaptit/Support.java

package javaptit;

import java.util.ArrayList;
import java.util.Stack;

public class Support {

    public static String chuanHoa(String s) {
        String[] arr = s.trim().split("\\s+");
        String res = "";
        for (int i = 0; i < arr.length; i++) {
            res += Character.toUpperCase(arr[i].charAt(0));
            for (int j = 1; j < arr[i].length(); j++) {
                res += Character.toLowerCase(arr[i].charAt(j));
            }
            res += " ";
        }
        return res.trim();
    }
}


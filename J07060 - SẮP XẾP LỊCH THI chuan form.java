taodungonetbeans/CaThi.java
package taodungonetbeans;

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
    
    @Override
    public String toString() {
        return this.ngayThi + " " + this.gioThi + " " + this.phongThi;
    }
}

taodungonetbeans/LichThi.java
package taodungonetbeans;

public class LichThi {
    private MonThi monThi;
    private CaThi caThi;
    private String maNhom, soSinhVien;

    public LichThi(MonThi monThi, CaThi caThi, String maNhom, String soSinhVien) {
        this.monThi = monThi;
        this.caThi = caThi;
        this.maNhom = maNhom;
        this.soSinhVien = soSinhVien;
    }

    public CaThi getCaThi() {
        return caThi;
    }
    
    @Override
    public String toString() {
        return this.caThi + " " + this.monThi.getTenMon() + " " + this.maNhom + " " + this.soSinhVien;
    }
}

taodungonetbeans/Main.java
package taodungonetbeans;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.*;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("MONTHI.in"));
        int n = Integer.parseInt(sc.nextLine());
        HashMap<String, MonThi> mapMT = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String s1 = sc.nextLine(), s2 = sc.nextLine(), s3 = sc.nextLine();
            MonThi x = new MonThi(s1, s2, s3);
            mapMT.put(s1, x);
        }
        sc = new Scanner(new File("CATHI.in"));
        int m = Integer.parseInt(sc.nextLine());
        HashMap<String, CaThi> mapCT = new HashMap<>();
        for (int i = 0; i < m; i++) {
            String s1 = sc.nextLine(), s2 = sc.nextLine(), s3 = sc.nextLine();
            CaThi x = new CaThi(s1, s2, s3);
            mapCT.put(x.getMaCaThi(), x);
        }
        sc = new Scanner(new File("LICHTHI.in"));
        int p = Integer.parseInt(sc.nextLine());
        ArrayList<LichThi> list = new ArrayList<>();
        for (int i = 0; i < p; i++) {
            String[] arr = sc.nextLine().trim().split("\\s+");
            MonThi s1 = mapMT.get(arr[1]);
            CaThi s2 = mapCT.get(arr[0]);
            String s3 = arr[2];
            String s4 = arr[3];
            LichThi x = new LichThi(s1, s2, s3, s4);
            list.add(x);
        }
        Collections.sort(list, new SortBy());
        for (LichThi x : list) {
            System.out.println(x);
        } 
    }
}

taodungonetbeans/MonThi.java

package taodungonetbeans;

public class MonThi {
    private String maMon, tenMon, hinhThucThi;

    public MonThi(String maMon, String tenMon, String hinhThucThi) {
        this.maMon = maMon;
        this.tenMon = tenMon;
        this.hinhThucThi = hinhThucThi;
    }

    public String getTenMon() {
        return tenMon;
    }
      
}

taodungonetbeans/SortBy.java
package taodungonetbeans;

import java.util.Comparator;

public class SortBy implements Comparator<LichThi> {
    @Override
    public int compare(LichThi a, LichThi b) {
        if (!a.getCaThi().getNgayThi().equals(b.getCaThi().getNgayThi())) {
            if (a.getCaThi().getNgayThi().compareTo(b.getCaThi().getNgayThi()) < 0) return -1;
            return 1;
        }
        else {
            if (!a.getCaThi().getGioThi().equals(b.getCaThi().getGioThi())) {
                if (a.getCaThi().getGioThi().compareTo(b.getCaThi().getGioThi()) < 0) return -1;
                return 1;
            }
            else {
                if (a.getCaThi().getMaCaThi().compareTo(b.getCaThi().getMaCaThi()) < 0) return -1;
                return 1;
            }
        }
    }
}


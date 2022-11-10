Main.java
package javaptit;

import java.util.*;
import java.util.Map.Entry;

public class Main {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        HashMap<String, MonHoc> mapMH = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String[] arr = sc.nextLine().trim().split("\\s+");
            String s2 = "";
            for (int j = 1; j < arr.length; j++) {
                s2 += arr[j] + " ";
            }
            MonHoc x = new MonHoc(arr[0], s2.trim());
            mapMH.put(arr[0], x);
        }
        HashMap<String, GiangVien> mapGV = new HashMap<>();
        int m = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < m; i++) {
            String[] arr = sc.nextLine().trim().split("\\s+");
            String s2 = "";
            for (int j = 1; j < arr.length; j++) {
                s2 += arr[j] + " ";
            }
            GiangVien x = new GiangVien(arr[0], s2.trim());
            mapGV.put(arr[0], x);
        }
        int p = Integer.parseInt(sc.nextLine());
        LinkedHashMap<String, ArrayList<HocPhan>> mapHP = new LinkedHashMap<>();
        for (int i = 0; i < p; i++) {
            String[] arr = sc.nextLine().trim().split("\\s+");
            HocPhan x = new HocPhan(arr[0], arr[1], Double.parseDouble(arr[2]));
            ArrayList<HocPhan> list = new ArrayList<>();
            list.add(x);
            if (mapHP.containsKey(arr[0])) {
                mapHP.get(arr[0]).add(x);
            }
            else {
                mapHP.put(arr[0], list);
            }
        }
        String s = sc.nextLine();
        System.out.print("Giang vien: ");
        System.out.println(mapGV.get(s).getTenGiangVien());
        double tongGioChuan = 0.0;
        for (HocPhan x : mapHP.get(s)) {
            System.out.println(mapMH.get(x.getMaMon()).getTenMonHoc() + " " + x.getGioChuan());
            tongGioChuan += x.getGioChuan();
        }
        System.out.println("Tong: " + String.format("%.2f", tongGioChuan));
    }
}





//2
//INT1155 Tin hoc co so 2
//INT1306 Cau truc du lieu va giai thuat
//2
//GV01 Nguyen Van An
//GV02 Hoang Binh Minh
//3
//GV01 INT1155 113.2
//GV02 INT1306 126.72
//GV01 INT1306 112.2
//GV01
GiangVien.java
package javaptit;

import java.util.*;

public class GiangVien {
    private String maGiangVien, tenGiangVien;

    public GiangVien(String maGiangVien, String tenGiangVien) {
        this.maGiangVien = maGiangVien;
        this.tenGiangVien = tenGiangVien;
    }
    
    public String getTenGiangVien() {
        return this.tenGiangVien;
    }
    
}

HocPhan.java

package javaptit;
import java.util.*;

public class HocPhan {
    private String maGiangVien, maMon;
    private double gioChuan;

    public HocPhan(String maGiangVien, String maMon, double gioChuan) {
        this.maGiangVien = maGiangVien;
        this.maMon = maMon;
        this.gioChuan = gioChuan;
    }
    
    public String getMaMon() {
        return this.maMon;
    }
    
    public double getGioChuan() {
        return this.gioChuan;
    }

}

MonHoc.java
package javaptit;

import java.util.*;

public class MonHoc {
    private String maMonHoc, tenMonHoc;

    public MonHoc(String maMonHoc, String tenMonHoc) {
        this.maMonHoc = maMonHoc;
        this.tenMonHoc = tenMonHoc;
    }

    public String getTenMonHoc() {
        return this.tenMonHoc;
    }
    
}

